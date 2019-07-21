package com.eksad.MiniProject.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.MiniProject.dao.EmployeeDao;
import com.eksad.MiniProject.model.Employee;
import com.eksad.MiniProject.service.ReportService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping(value = "/report")
	public String generateReport() {
		return reportService.generateReport();
		
	}

	@Cacheable(value = "getAll")
	@GetMapping("getAll")
	public List<Employee> getAll(){
		List<Employee> result = new ArrayList<>();
		employeeDao.findAll().forEach(result::add);
		return result;
	}
	
	@Cacheable(value = "save")
	@PostMapping(value = "save")
	public Employee save(@RequestBody Employee employee) 
	{	
		return employeeDao.save(employee);
	}
	@Cacheable(value = "update", key = "#id")
	@PutMapping (value = "update/{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
		Employee employeeSelected = employeeDao.findById(id).orElse(null);
		if (employeeSelected != null) {
			employeeSelected.setName(employee.getName());
			employeeSelected.setDob(employee.getDob());
			employeeSelected.setAddress(employee.getAddress());
			employeeSelected.setPhone(employee.getPhone());
			employeeSelected.setAge(employee.getAge());
			employeeSelected.setPob(employee.getPob());
			employeeSelected.setSalary(employee.getSalary());
			employeeSelected.setId_div(employee.getId_div());
			
			return employeeDao.save(employeeSelected);
		}else {
			return null;
		}
	}
	@Cacheable(value = "delete", key = "#id")
	@DeleteMapping (value = "delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		employeeDao.deleteById(id);
		result.put("message", "berhasil dihapus");
		return result;
	}

}


