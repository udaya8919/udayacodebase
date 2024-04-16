package com.usecase.repository;



import java.util.List;

import com.usecase.dao.EmployeeDAO;
import com.usecase.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	private EmployeeDAO employeeDAO;
	List<Employee> emps;
	 public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public EmployeeRepositoryImpl(EmployeeDAO employeeDAO) {
		 this.employeeDAO=employeeDAO;
		 this.emps = employeeDAO.getAllEmployees();
	 }
	 public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countEmployeesByGender(String gender) {
		return employeeDAO.CountEmployeeByGender(gender);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return getEmps();
	}
	

}
