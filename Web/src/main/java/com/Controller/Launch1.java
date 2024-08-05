package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.EmployeeDao;
import com.Model.Employee;

@WebServlet("/add")
public class Launch1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =  req.getParameter("uid");
		String name = req.getParameter("uname");
		String salary = req.getParameter("usalary");
		
		Session s = ConnectionFactory.getSession();
		
		Employee e = new Employee();
		e.setId(Integer.valueOf(id));
		e.setName(name);
		e.setSalary(Double.valueOf(salary));
		
		EmployeeDao eDao = new EmployeeDao();
		eDao.addEmp(e, s);
		
		resp.sendRedirect("index.jsp");
	}
}
