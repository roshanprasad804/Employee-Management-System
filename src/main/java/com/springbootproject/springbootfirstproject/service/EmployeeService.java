package com.springbootproject.springbootfirstproject.service;

import com.springbootproject.springbootfirstproject.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
