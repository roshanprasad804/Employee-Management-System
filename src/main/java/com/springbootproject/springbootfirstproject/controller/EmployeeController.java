package com.springbootproject.springbootfirstproject.controller;

import com.springbootproject.springbootfirstproject.dto.EmployeeDto;
import com.springbootproject.springbootfirstproject.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        log.info("Returned Added Object"+savedEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get employee by Id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees () {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails (@PathVariable("id") Long employeeId,
                                                              @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("{id}")
    public void deleteEmployee (@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
