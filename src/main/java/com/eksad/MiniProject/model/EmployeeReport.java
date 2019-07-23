package com.eksad.MiniProject.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class EmployeeReport {

	private Integer id;
	private String name;
	private Date dob;
	private String address;
	private String phone;
	private Integer age;
	private String pob;
	private Integer salary;
	private Integer id_div;
	
	
}
