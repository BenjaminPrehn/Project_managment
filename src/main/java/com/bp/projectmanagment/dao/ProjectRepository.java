package com.bp.projectmanagment.dao;

import com.bp.projectmanagment.dto.ChartData;
import com.bp.projectmanagment.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " +
            "GROUP by stage")
    public List<ChartData> getProjectStatus();

}
