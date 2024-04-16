package com.usecase.service;

import java.util.List;

import com.usecase.model.Employee;

public interface EmployeeService {
	  void addEmployee(Employee employee);
	  List<Employee> getallEmployees();
	  long countMaleEmployees();
	  long countFemaleEmployees();
	  void displayAllDepts();
	  double avgAgeOfMaleEmp();
	  double avgAgeOfFemaleEmp();
	  void highestPaidEmployee();
	  void joinedAfter2015();
	  void countEmpsInDept();
	  void avgSalaryInEachDept();
	  void youngestProductDevDept();
	  void mostExperianced();
	  void countsalaesDeptEmps();
	  void avgMaleFemaleEmps();
	  void displayEmployeesEachDept();
	  void totalAvgSalary();
	  void EmployeesSeparationList();
	  void oldestEmplyeeDept();
}
