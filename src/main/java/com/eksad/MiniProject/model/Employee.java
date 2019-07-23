package com.eksad.MiniProject.model;

import java.io.Serializable;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javassist.SerialVersionUID;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=false)
	private Integer age;
	
	@Column(nullable=false)
	private String pob;
	
	@Column(nullable=false)
	private Integer salary;
	
	@Column(nullable=false)
	private int id_div;

}
