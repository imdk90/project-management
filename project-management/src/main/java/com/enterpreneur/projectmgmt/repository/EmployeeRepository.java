package com.enterpreneur.projectmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.enterpreneur.projectmgmt.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	public List<Employee> findAll();
}
