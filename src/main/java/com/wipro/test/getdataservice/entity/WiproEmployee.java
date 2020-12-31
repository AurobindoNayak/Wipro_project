package com.wipro.test.getdataservice.entity;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "WiproEmployee")
public class WiproEmployee {
	
	@Id
	private int id;
	
	@NotNull(message = "employeeName can't be null")
	private String employeeName;
	
	@Min(2)
	private int age;
	
	
	private boolean hasExperienced;

}
