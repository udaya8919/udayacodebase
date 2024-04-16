package com.usecase.repository;

import java.util.List;

import com.usecase.model.Employee;

public interface EmployeeRepository {
	 void addEmployee(Employee employee);
	  List<Employee> getAllEmployees();
	  int countEmployeesByGender(String gender);
}
