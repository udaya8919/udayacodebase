

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.usecase.dao.EmployeeDAO;
import com.usecase.dao.EmployeeDAOImpl;
import com.usecase.model.Employee;
import com.usecase.repository.EmployeeRepository;
import com.usecase.repository.EmployeeRepositoryImpl;
import com.usecase.service.EmployeeService;
import com.usecase.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //http://localhost:8080/EmployeeDataManagement/EmployeeServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(employeeDAO);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
        List<Employee> employees = employeeService.getallEmployees();

        // Set employee data as request attribute
        request.setAttribute("employees", employees);

        // Forward request to JSP for rendering
        request.getRequestDispatcher("/WEB-INF/jsp/Employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
