package com.bp.projectmanagment.services;

import com.bp.projectmanagment.dao.ProjectRepository;
import com.bp.projectmanagment.dto.ChartData;
import com.bp.projectmanagment.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;


    public Project save(Project project){
        return proRepo.save(project);
    }

    public List<Project> getAll(){
        return proRepo.findAll();
    }

    public List<ChartData> getProjectStatus(){
        return proRepo.getProjectStatus();
    }
}
