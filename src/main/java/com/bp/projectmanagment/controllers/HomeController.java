package com.bp.projectmanagment.controllers;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.dao.ProjectRepository;
import com.bp.projectmanagment.dto.ChartData;
import com.bp.projectmanagment.dto.EmployeeProject;
import com.bp.projectmanagment.entities.Employee;
import com.bp.projectmanagment.entities.Project;
import com.bp.projectmanagment.services.EmployeeService;
import com.bp.projectmanagment.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ProjectService proRepo;
    @Autowired
    EmployeeService empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", ver);

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = proRepo.getAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Convert projectData object into a json structure for us in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
        model.addAttribute("projectStatusCnt", jsonString);

        List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
        return"main/home";
    }
}
