package com.wipro.test.getdataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.test.getdataservice.entity.WiproEmployee;
import com.wipro.test.getdataservice.service.WiproEmployeeService;

@RestController
public class WiproEmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(WiproEmployeeController.class);

	@Autowired
	private WiproEmployeeService service;

	
	// Values added in the DB , op values taking from console taking from the log
	// WiproEmployees List{} [WiproEmployee(id=1, employeeName=Aurobindo Nayak, age=26, hasExperienced=true), WiproEmployee(id=2, employeeName=Elon Musk, age=52, hasExperienced=true), WiproEmployee(id=3, employeeName=XXX YYY, age=32, hasExperienced=true), WiproEmployee(id=1, employeeName=Aurobindo Nayak, age=22, hasExperienced=true)]
	
	@PostMapping("/add-emp")
	public WiproEmployee addEmployee(@RequestBody WiproEmployee emp) {
		return service.addEmployee(emp);
	}

	@GetMapping("/highestNumber")
	public Integer numbersMeetNumbers() {
		logger.info("highestNumber{}" +service.numbersMeetNumbers());
		//op--> highestAge{} 52
		return service.numbersMeetNumbers();

	}

	@GetMapping("/duplicates")
	public String findDuplicates() {
		logger.info("duplicates{}" +service.findDuplicates());
		//op---> allDuplicates{} [Aurobindo Nayak, Aurobindo Nayak]
		return service.findDuplicates();
	}

	@GetMapping("/remove-space/{id}")
	public String whiteSpacesGalore(@PathVariable int id) {
		logger.info("after-removing-space{}" +service.whiteSpacesGalore(id));
		//op--->after-removing-space{}AurobindoNayak
		return service.whiteSpacesGalore(id);
	}
}
