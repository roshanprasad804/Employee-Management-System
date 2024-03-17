import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  constructor( private employeeservice:EmployeeService) {

  }

  ngOnInit() {
    this.getEmployees();
  }

  employees: any[] = [
    { id: 1, name: 'John Doe', department: 'IT' },
    { id: 2, name: 'Jane Smith', department: 'HR' },
    { id: 3, name: 'Alice Johnson', department: 'Finance' }
  ];

  getEmployees() {
    this.employeeservice.getEmployees().subscribe((data:any) => {
      console.log('data',data);
      // this.employees.map = data;
    });
  }

  addEmployee() {
    
  }

  deleteEmployee(employee: any) {
    const index = this.employees.indexOf(employee);
    if (index !== -1) {
      this.employees.splice(index, 1);
    }
  }
}
