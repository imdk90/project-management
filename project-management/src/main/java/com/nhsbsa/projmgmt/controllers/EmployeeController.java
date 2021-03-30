package com.nhsbsa.projmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhsbsa.projmgmt.entity.Employee;
import com.nhsbsa.projmgmt.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping
	public String displayEmployee(Model model) {
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("employees", employees);
		return "employee/list-employee";
	}

	@GetMapping("/create")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(Employee employee, Model model) {
		empService.save(employee);
		return "redirect:/employees/create";
	}

	@GetMapping("/update")
	public String displyaEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {
		Employee theEmp = empService.findByEmployeeId(theId);
		model.addAttribute("employee", theEmp);
		return "employee/new-employee";
	}

	@GetMapping("/delete")
	public String deletEmployee(@RequestParam("id") long theId, Model model) {
		Employee employee = empService.findByEmployeeId(theId);
		empService.delete(employee);
		return "redirect:/employees";
	}
}
