package com.usecase.service;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.usecase.model.Employee;
import com.usecase.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	List<Employee> emps;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public long countMaleEmployees() {
		return employeeRepository.getAllEmployees().stream().filter(employee -> "Male".equals(employee.getGender()))
				.count();
	}

	@Override
	public long countFemaleEmployees() {
		return employeeRepository.getAllEmployees().stream().filter(employee -> "Female".equals(employee.getGender()))
				.count();
	}

	@Override
	public List<Employee> getallEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}

	// Print name of the Department in the Orgnization
	@Override
	public void displayAllDepts() {
		List<Employee> empList = employeeRepository.getAllEmployees();
		empList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList())
				.forEach(System.out::println);

	}

	@Override
	public double avgAgeOfMaleEmp() {
		double avgAgeMale = employeeRepository.getAllEmployees().stream()
				.filter(employee -> employee.getGender().equalsIgnoreCase("Male")).mapToInt(Employee::getAge).average()
				.orElse(0.0);

		return avgAgeMale;
	}

	@Override
	public double avgAgeOfFemaleEmp() {
		double avgAgeFemale = employeeRepository.getAllEmployees().stream()
				.filter(employee -> employee.getGender().equalsIgnoreCase("Female")).mapToInt(Employee::getAge)
				.average().orElse(0.0);

		return avgAgeFemale;
	}

	@Override
	public void highestPaidEmployee() {
		Optional<Employee> emp = employeeRepository.getAllEmployees().stream().max(Comparator.comparingDouble(Employee::getSalary));
		
		if (emp.isPresent()) {
			Employee highestPaidEmp = emp.get();
			System.out.println("Highest paid Emp name"+ highestPaidEmp.getName());
			System.out.println("Highest paid Emp salary"+ highestPaidEmp.getSalary());
		}
	}

	@Override
	public void joinedAfter2015() {
		List<String> employeesJoinedAfter2015 = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .toList();

	        // Print the names of employees who joined after 2015
	        System.out.println("Employees who joined after 2015:");
	        employeesJoinedAfter2015.forEach(System.out::println);
		
	}

	@Override
	public void countEmpsInDept() {
		 Map<String, Long> departmentCounts = employeeRepository.getAllEmployees().stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

	        // Print the number of employees in each department
	        System.out.println("Number of employees in each department:");
	        departmentCounts.forEach((department, count) -> System.out.println(department + ": " + count));
		
	}

	@Override
	public void avgSalaryInEachDept() {
		Map<String, Double> departmentAvgSalary = employeeRepository.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        // Print the average salary of employees in each department
        System.out.println("Average salary of employees in each department:");
        departmentAvgSalary.forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));
		
	}

	@Override
	public void youngestProductDevDept() {
		 // Department to search for
        String departmentToSearch = "Product Development";

        // Find the youngest male employee in department X
        Optional<Employee> youngestMaleEmployee = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(departmentToSearch))
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .min(Comparator.comparingInt(Employee::getAge));

        // Print the details of the youngest male employee in department X
        if (youngestMaleEmployee.isPresent()) {
            Employee youngestMale = youngestMaleEmployee.get();
            System.out.println("Details of the youngest male employee in department " + departmentToSearch + ":");
            System.out.println("Name: " + youngestMale.getName());
            System.out.println("Age: " + youngestMale.getAge());
            System.out.println("Gender: " + youngestMale.getGender());
            System.out.println("Department: " + youngestMale.getDepartment());
        } else {
            System.out.println("No male employees found in department " + departmentToSearch);
        }
		
	}

	@Override
	public void mostExperianced() {
		// Find the employee with the most years of experience
        Optional<Employee> mostExperiencedEmployee = employeeRepository.getAllEmployees().stream()
                .max(Comparator.comparingInt(employee -> Year.now().getValue() - employee.getYearOfJoining()));

        // Print the details of the most experienced employee
        if (mostExperiencedEmployee.isPresent()) {
            Employee mostExperienced = mostExperiencedEmployee.get();
            System.out.println("Most experienced employee:");
            System.out.println("Name: " + mostExperienced.getName());
            System.out.println("Years of experience: " +
                    (Year.now().getValue() - mostExperienced.getYearOfJoining()));
        } else {
            System.out.println("No employees found.");
        }
		
	}

	@Override
	public void countsalaesDeptEmps() {
		 // Department to search for
        String departmentToSearch = "Sales And Marketing";

        // Count the number of male and female employees in the sales and marketing team
        long maleEmployeesCount = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(departmentToSearch))
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .count();

        long femaleEmployeesCount = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(departmentToSearch))
                .filter(employee -> employee.getGender().equalsIgnoreCase("Female"))
                .count();

        // Print the count of male and female employees in the sales and marketing team
        System.out.println("Number of male employees in " + departmentToSearch + ": " + maleEmployeesCount);
        System.out.println("Number of female employees in " + departmentToSearch + ": " + femaleEmployeesCount);
		
	}

	@Override
	public void avgMaleFemaleEmps() {
		  // Calculate the average salary of male employees
        double avgSalaryMale = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // Calculate the average salary of female employees
        double avgSalaryFemale = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("Female"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // Print the average salary of male and female employees
        System.out.println("Average salary of male employees: " + avgSalaryMale);
        System.out.println("Average salary of female employees: " + avgSalaryFemale);
		
	}

	@Override
	public void displayEmployeesEachDept() {
		 Map<String, List<String>> employeesByDepartment = employeeRepository.getAllEmployees().stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment,
	                        Collectors.mapping(Employee::getName, Collectors.toList())));

	        // Print the names of employees in each department
	        employeesByDepartment.forEach((department, names) -> {
	            System.out.println("Employees in " + department + " department:");
	            names.forEach(System.out::println);
	            System.out.println(); // Add an empty line for clarity
	        });
		
	}

	@Override
	public void totalAvgSalary() {
		 // Calculate the total salary of the organization
        double totalSalary = employeeRepository.getAllEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        // Calculate the average salary of the organization
        OptionalDouble averageSalary = employeeRepository.getAllEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .average();

        // Print the total salary and average salary of the organization
        System.out.println("Total salary of the organization: " + totalSalary);
        if (averageSalary.isPresent()) {
            System.out.println("Average salary of the organization: " + averageSalary.getAsDouble());
        } else {
            System.out.println("No employees found.");
        }
		
	}

	@Override
	public void EmployeesSeparationList() {
		 // Separate the employees who are 25 or younger from those who are older than 25
        List<Employee> youngerThan25 = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getAge() <= 25)
                .collect(Collectors.toList());

        List<Employee> olderThan25 = employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getAge() > 25)
                .collect(Collectors.toList());

        // Print the names of employees who are 25 or younger
        System.out.println("Employees who are 25 or younger:");
        youngerThan25.forEach(employee -> System.out.println(employee.getName()));

        // Print the names of employees who are older than 25
        System.out.println("\nEmployees who are older than 25:");
        olderThan25.forEach(employee -> System.out.println(employee.getName()));
		
	}

	@Override
	public void oldestEmplyeeDept() {
		   // Find the oldest employee in the organization
        Optional<Employee> oldestEmployee = employeeRepository.getAllEmployees().stream()
                .max(Comparator.comparingInt(Employee::getAge));

        // Print the details of the oldest employee
        if (oldestEmployee.isPresent()) {
            Employee oldest = oldestEmployee.get();
            System.out.println("Oldest employee:");
            System.out.println("Name: " + oldest.getName());
            System.out.println("Age: " + oldest.getAge());
            System.out.println("Department: " + oldest.getDepartment());
        } else {
            System.out.println("No employees found.");
        }
		
	}

}
