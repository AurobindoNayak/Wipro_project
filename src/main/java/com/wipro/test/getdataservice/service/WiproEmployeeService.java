package com.wipro.test.getdataservice.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.wipro.test.getdataservice.entity.WiproEmployee;
import com.wipro.test.getdataservice.exception.EmployeeNotFondException;
import com.wipro.test.getdataservice.repository.WiproRepository;

@Service
public class WiproEmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(WiproEmployeeService.class);

	@Autowired
	private WiproRepository repository;

	public WiproEmployee addEmployee(WiproEmployee emp) {
		return repository.save(emp);
	}

	public Integer numbersMeetNumbers() {
		List<WiproEmployee> employees = repository.findAll();
		logger.info("WiproEmployees List{} " + employees);
		List<Integer> ageList = employees.stream().map(x -> x.getAge()).collect(Collectors.toList());
		logger.info("Age List{} " + ageList);
		
		// To get the highest age
		Integer highestAge = ageList.stream().max((a, b) -> a - b).get();
		logger.info("highestAge{} " + highestAge);
		return highestAge;

	}

	public String findDuplicates() {
		List<WiproEmployee> employees = repository.findAll();
		logger.info("WiproEmployees List{} " + employees);

		List<String> nameList = employees.stream().map(x -> x.getEmployeeName()).collect(Collectors.toList());
		logger.info("NameList{} " + nameList);

		// To get the first duplicate
		String duplicate = nameList.stream().filter(i -> Collections.frequency(nameList, i) > 1).findFirst()
				.orElse(null);

		// To get Any Duplicate just replace the finFirst() with findAny
		String duplicateAny = nameList.stream().filter(i -> Collections.frequency(nameList, i) > 1).findAny()
				.orElse(null);
		logger.info("duplicateAny{} " + duplicateAny);

		// To get All the Duplictaes
		List<String> allDuplicates = nameList.stream().filter(i -> Collections.frequency(nameList, i) > 1)
				.collect(Collectors.toList());
		logger.info("allDuplicates{} " + allDuplicates);

		// Currently I'm returning the first duplicate
		return duplicate;

	}

	public String whiteSpacesGalore(int id) {
		
		Optional<WiproEmployee> emp = repository.findById(id);
		logger.info("WiproEmployee{} " + emp);

		String name = "";

		if (ObjectUtils.isEmpty(emp)) {
			throw new EmployeeNotFondException("The Given Id is not prsent" + id);
		} else {
			
			logger.info("Name{} " + emp.get().getEmployeeName());

			List<String> nameSplit = Arrays.asList((emp.get().getEmployeeName()).split(" "));
			for (String empName : nameSplit) {
				name = name + empName;
			}
		}

		return name;

	}
}
