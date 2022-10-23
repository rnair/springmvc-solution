package com.springmvc.solution.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.solution.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
