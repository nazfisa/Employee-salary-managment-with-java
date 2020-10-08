package com.Servlet;




import com.dao.EmployeeDao;
import com.domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String address = request.getParameter("address");
		String mobileNo = request.getParameter("mobileNo");
		String bankAccount = request.getParameter("bankAccount");
		
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setGrade(grade);
		e.setAddress(address);
		e.setMobileNo(mobileNo);
		e.setBankAccount(bankAccount);
		 
		int status = EmployeeDao.update(e);
		if(status>0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.println("Sorry! Unable to update record");
		}
		
	}
	
}
