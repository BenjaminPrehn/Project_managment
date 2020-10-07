package com.bp.projectmanagment.controllers;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee = new Employee();
        model.addAttribute("employee",aEmployee);
        return"/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empRepo.save(employee);

        return"redirect:/employee/new";
    }
}
