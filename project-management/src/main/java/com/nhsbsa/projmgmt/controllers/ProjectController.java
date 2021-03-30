package com.nhsbsa.projmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhsbsa.projmgmt.entity.Project;
import com.nhsbsa.projmgmt.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projService;

	@GetMapping
	public String displayProject(Model model) {
		Iterable<Project> projects = projService.getAll();
		model.addAttribute("projects", projects);
		return "project/list-project";
	}

	@GetMapping("/create")
	public String createProject(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		return "project/new-project";
	}

	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		projService.save(project);
		return "redirect:/projects/create";
	}

	@GetMapping("/update")
	public String displyaEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {
		Project thePro = projService.findByProjectId(theId);
		model.addAttribute("project", thePro);
		return "project/new-project";
	}

	@GetMapping("/delete")
	public String deletEmployee(@RequestParam("id") long theId, Model model) {
		Project project = projService.findByProjectId(theId);
		projService.delete(project);
		return "redirect:/projects";
	}
}
