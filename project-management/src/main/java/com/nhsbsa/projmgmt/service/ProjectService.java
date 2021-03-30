package com.nhsbsa.projmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.dto.ChartData;
import com.nhsbsa.projmgmt.entity.Project;

@Service
public interface ProjectService {
	public Project save(Project project);

	public List<Project> getAll();

	// public List<EmployeeProject> employeeProjects() ;
	public Project findByProjectId(long theId);

	public void delete(Project thePro);
	
	public List<ChartData> getProjectStatus();

}
