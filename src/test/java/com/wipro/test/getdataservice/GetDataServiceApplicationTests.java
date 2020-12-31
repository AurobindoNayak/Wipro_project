package com.wipro.test.getdataservice;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wipro.test.getdataservice.entity.WiproEmployee;
import com.wipro.test.getdataservice.exception.EmployeeNotFondException;
import com.wipro.test.getdataservice.service.WiproEmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringMongoConfiguration.class})
class GetDataServiceApplicationTests {

	@Autowired
	WiproEmployeeService service;
	
	@Before
	public void init() {
		WiproEmployee emp = new WiproEmployee();
		emp.setId(1);
		emp.setEmployeeName("Aurobindo Nayak");
		emp.setAge(26);
		emp.setHasExperienced(true);
	}
	
	
	@Test
	public void getNamewhiteSpacesGaloreSuccess() {
		String name=  service.whiteSpacesGalore(1);
		assertEquals("AurobindoNayak", name);
	}

	@Test
	public void getNamewhiteSpacesGaloreFailure() {
		String name=  service.whiteSpacesGalore(1);
		assertNotEquals("Aurobindo Nayak", name);
	}
	
}
