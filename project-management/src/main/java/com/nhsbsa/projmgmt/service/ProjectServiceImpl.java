package com.nhsbsa.projmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhsbsa.projmgmt.dto.ChartData;
import com.nhsbsa.projmgmt.entity.Project;
import com.nhsbsa.projmgmt.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository proRepo;

	@Override
	public Project save(Project project) {
		return proRepo.save(project);
	}

	@Override
	public List<Project> getAll() {
		return proRepo.findAll();
	}

	@Override
	public Project findByProjectId(long theId) {
		return proRepo.findById(theId);
	}

	@Override
	public void delete(Project thePro) {
		proRepo.delete(thePro);
	}

	@Override
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}

}
