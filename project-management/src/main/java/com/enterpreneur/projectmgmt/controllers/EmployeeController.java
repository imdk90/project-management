package com.enterpreneur.projectmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterpreneur.projectmgmt.entity.Employee;
import com.enterpreneur.projectmgmt.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/create")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new-employee";
	}
	
	@PostMapping("/save")
	public String saveProject(Employee employee, Model model) {
		empRepo.save(employee);
		//
		return "redirect:/employees/create";
	}
}
