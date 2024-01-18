package com.springbootproject.springbootfirstproject.mapper;

import com.springbootproject.springbootfirstproject.dto.EmployeeDto;
import com.springbootproject.springbootfirstproject.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto (Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee (EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
