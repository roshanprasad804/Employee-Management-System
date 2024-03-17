import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { MatInputModule } from '@angular/material/input';

export interface Employee {
    id:number;
    name:string;
    email:string;
}

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule, MatInputModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  constructor( private employeeservice:EmployeeService) {

  }

  ngOnInit() {
    this.getEmployees();
  }

  employees!: Employee[];
  isAddClicked = false;

  getEmployees() {
    this.employeeservice.getEmployees().subscribe((data:any) => {
      this.employees = data;
      console.log('employees',this.employees);
      this.employees.map((val:any) => {
        val.name = val.firstName + ' ' + val.lastName;
      })
    });
  }

  addEmployee() {
    this.isAddClicked = true;
    // this.employeeservice.addEmployee()
  }

  deleteEmployee(employee: any) {
    const index = this.employees.indexOf(employee);
    if (index !== -1) {
      this.employees.splice(index, 1);
    }
  }
}
