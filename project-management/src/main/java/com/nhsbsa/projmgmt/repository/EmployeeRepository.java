package com.nhsbsa.projmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nhsbsa.projmgmt.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
	
	public Employee findByEmpId(long theId);
}
