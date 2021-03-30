package com.nhsbsa.projmgmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhsbsa.projmgmt.dto.ChartData;
import com.nhsbsa.projmgmt.entity.Employee;
import com.nhsbsa.projmgmt.entity.Project;
import com.nhsbsa.projmgmt.service.EmployeeService;
import com.nhsbsa.projmgmt.service.ProjectService;

@Controller
public class HomeController {

	@Autowired
	ProjectService proService;

	@Autowired
	EmployeeService empService;

	@Value("${version}")
	private String version;

	@GetMapping("/")
	public String disPlayHome(Model model) {
		String jsonString = null;
		model.addAttribute("versionNumber", version);
		List<Project> projectList = proService.getAll();
		model.addAttribute("projectList", projectList);

		List<Employee> employeeList = empService.getAll();
		model.addAttribute("employeeList", employeeList);

		List<ChartData> projData = proService.getProjectStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonString = objectMapper.writeValueAsString(projData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("projectStatusCount", jsonString);
		return "main/home";
	}
}
