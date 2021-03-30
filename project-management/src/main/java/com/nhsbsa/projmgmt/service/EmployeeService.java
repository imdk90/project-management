package com.nhsbsa.projmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.entity.Employee;

@Service
public interface EmployeeService {

	public Employee save(Employee employee);

	public List<Employee> getAll();

	// public List<EmployeeProject> employeeProjects() ;

	public Employee findByEmployeeId(long theId);

	public void delete(Employee theEmp);
}
