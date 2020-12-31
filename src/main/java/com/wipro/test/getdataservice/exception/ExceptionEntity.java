package com.wipro.test.getdataservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionEntity {

	private Date timeStamp;
	private String message;
	private String Details;

	
}
