package com.usecase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.usecase.jdbc.utill.JDBCConnectionFactory;
import com.usecase.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int CountEmployeeByGender(String gender) {
		int count = 0;
        String sql = "SELECT COUNT(*) FROM employee WHERE emp_gender = ?";
        try (PreparedStatement statement = JDBCConnectionFactory.getConnection().prepareStatement(sql)) {
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        return count;
	}

	@Override
	public List<Employee> getAllEmployees() {
		  List<Employee> employees = new ArrayList<>();
	        try (Connection connection = JDBCConnectionFactory.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {

	            while (resultSet.next()) {
	                int empId = resultSet.getInt("emp_id");
	                String name = resultSet.getString("emp_name");
	                int age = resultSet.getInt("emp_age");
	                String gender = resultSet.getString("emp_gender");
	                String department = resultSet.getString("emp_dept");
	                int yearOfJoining = resultSet.getInt("emp_year_of_joining");
	                double salary = resultSet.getDouble("emp_salary");

	                Employee employee = new Employee(empId, name, age, gender, department, yearOfJoining, salary);
	                employees.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception properly in your application
	        }
	        return employees;
	}


}
