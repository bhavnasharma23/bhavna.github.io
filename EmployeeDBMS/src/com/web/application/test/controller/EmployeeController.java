package com.web.application.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.application.test.model.Employee;
import com.web.application.test.repository.EmployeeRepository;

/**
 * Servlet implementation class EmployeeController
 */

@SuppressWarnings("serial")
public class EmployeeController extends HttpServlet {
	private EmployeeRepository employeeRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		employeeRepository = new EmployeeRepository();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("edit"))
		{
		Employee emp = new Employee();
		emp.setUserName(request.getParameter("userName"));
		emp.setFirstName(request.getParameter("firstName"));
		emp.setLastName(request.getParameter("lastName"));
		emp.setEmailAddress(request.getParameter("emailAddress"));
		emp.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
		emp.setLocation(request.getParameter("location"));
		
		request.setAttribute("updateEmployee", emp);
	
		RequestDispatcher view = request.getRequestDispatcher("update.jsp");
		view.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			String userName = request.getParameter("userName");
		    employeeRepository.deleteEmployee(userName);
		    request.setAttribute("list", employeeRepository.getAll());
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		    
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageName = request.getParameter("sectionName");
		String forward = "";		
		
		if (employeeRepository != null) {
			if (pageName.equals("update")) {
				employeeRepository.updateEmployee(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("emailAddress"),Integer.parseInt(request.getParameter("phoneNumber")),request.getParameter("location"),request.getParameter("userName"));
					forward = "index.jsp";
					RequestDispatcher view = request
							.getRequestDispatcher(forward);
					view.forward(request, response);
					return;
				}
				employeeRepository.save(request.getParameter("userName"),
						request.getParameter("password"),
						request.getParameter("firstName"),
						request.getParameter("lastName"),
						request.getParameter("emailAddress"),
						Integer.parseInt(request.getParameter("phoneno")),
						request.getParameter("location"));
				forward = "index.jsp";
		}
		request.setAttribute("list", employeeRepository.getAll());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
