package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.EmployeeDao;
import com.Model.Employee;

@WebServlet("/read")
public class Launch4 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String count = req.getParameter("count");
		
		Session s = ConnectionFactory.getSession();
		EmployeeDao eDao = new EmployeeDao();
		List<Employee> al = eDao.readAll(s,Integer.valueOf(count));
		
		HttpSession session = req.getSession();
		session.setAttribute("c", count);
		session.setAttribute("al", al);
		
		resp.sendRedirect("index.jsp");
		
	}
}
