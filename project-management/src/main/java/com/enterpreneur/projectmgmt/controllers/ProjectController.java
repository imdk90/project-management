package com.enterpreneur.projectmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterpreneur.projectmgmt.entity.Project;
import com.enterpreneur.projectmgmt.repository.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository projRepo;
	
	@GetMapping("/create")
	public String createProject(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		return "project/new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		projRepo.save(project);
		//
		return "redirect:/projects/create";
	}
	
	
	
}

