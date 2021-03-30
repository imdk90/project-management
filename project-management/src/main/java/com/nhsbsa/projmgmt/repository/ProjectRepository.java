package com.nhsbsa.projmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nhsbsa.projmgmt.dto.ChartData;
import com.nhsbsa.projmgmt.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	public List<Project> findAll();

	@Query(nativeQuery = true, value = "select status as label, count(*) as value " + "from project "
			+ "group by status")
	public List<ChartData> getProjectStatus();
	
	public Project findById(long id);
}
