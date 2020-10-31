package com.bp.projectmanagment.services;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.dto.EmployeeProject;
import com.bp.projectmanagment.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return empRepo.employeeProjects();
    }

}
