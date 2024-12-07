package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeManager;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		int eid =Integer.parseInt(request.getParameter("T1"));
		String ename= request.getParameter("T2");
		double esalary = Double.parseDouble(request.getParameter("T3"));
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		try {
			Employee E= new Employee();
			E.setEid(eid);
			E.setEname(ename);
			E.setSalary(esalary);
			
			EmployeeManager EM = new EmployeeManager();
			String ack = EM.addEmployee(E);
			PW.print(ack);
		}
		catch(Exception e) {
			PW.print(e.getMessage());
		}
		RequestDispatcher RD= request.getRequestDispatcher("index.html");
		RD.include(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
