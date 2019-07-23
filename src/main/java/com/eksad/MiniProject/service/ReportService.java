package com.eksad.MiniProject.service;

import java.math.BigDecimal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eksad.MiniProject.dao.EmployeeDao;
import com.eksad.MiniProject.model.EmployeeReport;


import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public String generateReport() {
	
		try {
			List<Object[]> treport = employeeDao.employeereport();
			List<EmployeeReport> EmployeeList = new ArrayList<>();
			
			for(Object[] tr : treport) {
				EmployeeReport employee = new EmployeeReport();
				employee.setId((Integer)tr[0]);
				employee.setName((String)tr[1]);
				employee.setDob((Date)tr[2]);
				employee.setAddress((String)tr[3]);
				employee.setPhone((String)tr[4]);
				employee.setAge((Integer)tr[5]);
				employee.setPob((String)tr[6]);
				employee.setSalary((Integer)tr[7]);
				employee.setId_div((Integer)tr[8]);
				EmployeeList.add(employee);
			}
			
			//filepath
			String reportPath = "C:\\Users\\User-PC\\Documents\\MiniProject\\src\\main\\resources";
			
			//jasper report initial
			JasperReport jasperReport = JasperCompileManager.compileReport(reportPath+"\\Employee_Report.jrxml");
			
			//datasource
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(EmployeeList);
			
			//paramater
		
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrBeanCollectionDataSource);
			
			
			JasperExportManager.exportReportToPdfFile(jasperPrint,reportPath+"\\employee_report.pdf");
			
			System.out.println("Done");
			
			
			return "jasper report successfuly generated @path ="+reportPath;
		}catch (Exception e){
			e.printStackTrace();
			return "Error--> check console log";
			
		}
	}
}
