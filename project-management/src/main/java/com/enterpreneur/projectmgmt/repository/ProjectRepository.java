package com.enterpreneur.projectmgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.enterpreneur.projectmgmt.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
}
