package com.nhsbsa.projmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.entity.Employee;
import com.nhsbsa.projmgmt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee save(Employee employee) {
		return empRepo.save(employee);

	}

	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findByEmployeeId(long theId) {
		return empRepo.findByEmpId(theId);
	}

	@Override
	public void delete(Employee theEmp) {
		empRepo.delete(theEmp);
	}

}
