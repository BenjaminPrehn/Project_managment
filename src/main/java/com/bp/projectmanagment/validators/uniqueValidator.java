package com.bp.projectmanagment.validators;

import com.bp.projectmanagment.dao.EmployeeRepository;
import com.bp.projectmanagment.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class uniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("Entered validation method..");

        Employee emp = empRepo.findByEmail(value);

        if(emp != null)
            return false;
         else
             return true;
    }
}
