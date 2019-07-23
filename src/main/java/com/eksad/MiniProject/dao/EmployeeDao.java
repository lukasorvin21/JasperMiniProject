package com.eksad.MiniProject.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eksad.MiniProject.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

	@Query(value = "select id, name, dob , address, phone, age,pob,salary,id_div " +
			"from Employee", nativeQuery = true)	
	public List<Object[]> employeereport(); 
}
