package com.bp.projectmanagment.controllers;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.dao.ProjectRepository;
import com.bp.projectmanagment.entities.Employee;
import com.bp.projectmanagment.entities.Project;
import com.bp.projectmanagment.services.EmployeeService;
import com.bp.projectmanagment.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService proRepo;

    @Autowired
    EmployeeService empRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Project aProject = new Project();
        List<Employee> employees = empRepo.getAll();
        model.addAttribute("project" , aProject);
        model.addAttribute("allEmployees" , employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        // this should handle saving to the database
        proRepo.save(project);

        // Use a redirect to prevent duplicate submissions
        return"redirect:/projects/";
    }

    @GetMapping("/")
    public String displayProjects(Model model){
        List<Project> projects = proRepo.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

}
