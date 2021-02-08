package com.enterpreneur.projectmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.enterpreneur.projectmgmt.entity.Employee;
import com.enterpreneur.projectmgmt.entity.Project;
import com.enterpreneur.projectmgmt.repository.EmployeeRepository;
import com.enterpreneur.projectmgmt.repository.ProjectRepository;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String disPlayHome(Model model) {
		List<Project> projectList = proRepo.findAll();
		model.addAttribute("projectList", projectList);

		List<Employee> employeeList = empRepo.findAll();
		model.addAttribute("employeeList", employeeList);
		return "main/home";
	}
}
