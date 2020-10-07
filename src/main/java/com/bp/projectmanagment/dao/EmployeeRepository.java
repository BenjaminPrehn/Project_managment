package com.bp.projectmanagment.dao;

import com.bp.projectmanagment.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
