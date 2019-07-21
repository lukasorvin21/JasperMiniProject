package com.eksad.MiniProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.eksad.MiniProject.dao.EmployeeDao;

@SpringBootApplication
@EnableCaching
public class MiniProjectApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	public MiniProjectApplication(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
