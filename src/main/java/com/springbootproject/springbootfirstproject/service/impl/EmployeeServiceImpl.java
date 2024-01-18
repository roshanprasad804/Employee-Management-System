package com.springbootproject.springbootfirstproject.service.impl;

import com.springbootproject.springbootfirstproject.dto.EmployeeDto;
import com.springbootproject.springbootfirstproject.entity.Employee;
import com.springbootproject.springbootfirstproject.mapper.EmployeeMapper;
import com.springbootproject.springbootfirstproject.repository.EmployeeRepository;
import com.springbootproject.springbootfirstproject.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("saved entity",savedEmployee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
