package com.Servlet;




import com.dao.BasicSalaryDao;
import com.dao.EmployeeDao;
import com.domain.BasicSalary;
import com.domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	public static double salary(int rank){
		BasicSalaryDao basicSalary = new BasicSalaryDao();
		int BS =  basicSalary.getBasicSalary();

<<<<<<< HEAD
			return BS+BS*0.20+BS*0.15+(6-rank)*5000;
=======
			return BS+BS*0.2+BS*0.15+(6-rank)*5000;
>>>>>>> 03857aaaff63bd710e7583337daf3ba399a0160e
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Add New User</a>");
		out.println("<h2>User List</h2>");
		List<Employee> list= EmployeeDao.getAll();
		out.println("<table border='1'>");
		out.println("<tr><th>Employee Name</th><th>Rank</th><th>Address</th><th>Phone</th><th>Bank Account</th><th>Salary</th><th colspan='2'>Action</th></tr>");
		for(Employee u : list) {
			out.println("<tr><td>"+u.getName()+"</td><td>"+u.getGrade()+"</td><td>"+u.getAddress()+"</td><td>"+u.getMobileNo()+"</td><td>"+u.getBankAccount()+"</td><td>"+salary(u.getGrade())+"</td><td><a href='EditServlet?id="+u.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>Delete</a></td></tr>");
				
		}
		out.println("</table>");
		out.close();
	}
}
