package com.bp.projectmanagment.dao;

import com.bp.projectmanagment.dto.EmployeeProject;
import com.bp.projectmanagment.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.firstname, e.lastname, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();

    public Employee findByEmail(String value);
}
