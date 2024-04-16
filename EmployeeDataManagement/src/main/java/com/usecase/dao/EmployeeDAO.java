package com.usecase.dao;

import java.util.List;

import com.usecase.model.Employee;

public interface EmployeeDAO {
	   void addEmployee(Employee employee);
	   int CountEmployeeByGender(String gender);
	   List<Employee> getAllEmployees();
}
