package com.springbootproject.springbootfirstproject.repository;

import com.springbootproject.springbootfirstproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
