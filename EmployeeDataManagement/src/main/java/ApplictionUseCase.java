
import com.usecase.dao.EmployeeDAO;
import com.usecase.dao.EmployeeDAOImpl;
import com.usecase.repository.EmployeeRepository;
import com.usecase.repository.EmployeeRepositoryImpl;
import com.usecase.service.EmployeeService;
import com.usecase.service.EmployeeServiceImpl;

public class ApplictionUseCase {
    public static void main(String[] args) {

    	  EmployeeDAO employeeDAO = new EmployeeDAOImpl();
          EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(employeeDAO);
          EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);

          // Get the counts
          long maleCount = employeeService.countMaleEmployees();
          long femaleCount = employeeService.countFemaleEmployees();


          // Output the male and Female Count in the Organization
          System.out.println("Number of Male Employees: " + maleCount);
          System.out.println("Number of Female Employees: " + femaleCount);
          System.out.println("All Department in the organization are:");
          // Display all the Department in the Organization
          employeeService.displayAllDepts();
          
          //Output Avg Age male and Female
          double maleAvgAge = employeeService.avgAgeOfMaleEmp();
          double femaleAvgAge = employeeService.avgAgeOfFemaleEmp();
          System.out.println("Avg age of Male Employees"+maleAvgAge);
          System.out.println("Avg age of Female Employees"+femaleAvgAge);
          //Highest paid Employee
          employeeService.highestPaidEmployee();
          employeeService.joinedAfter2015();
          employeeService.countEmpsInDept();
          employeeService.avgSalaryInEachDept();
          employeeService.youngestProductDevDept();
          employeeService.mostExperianced();
          employeeService.countsalaesDeptEmps();
          employeeService.avgMaleFemaleEmps();
          employeeService.displayEmployeesEachDept();
          employeeService.totalAvgSalary();
          employeeService.EmployeesSeparationList();
          employeeService.oldestEmplyeeDept();
    }
}
