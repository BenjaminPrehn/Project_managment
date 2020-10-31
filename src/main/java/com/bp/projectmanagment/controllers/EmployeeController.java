package com.bp.projectmanagment.controllers;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.entities.Employee;
import com.bp.projectmanagment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee",anEmployee);
        return"employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empRepo.save(employee);

        return"redirect:/employees/";
    }

    @GetMapping("/")
    public String displayEmployees(Model model){
       List<Employee> employees = empRepo.getAll();
       model.addAttribute("employees", employees);
       return"employees/list-employees";
    }
}
