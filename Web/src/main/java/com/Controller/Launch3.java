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
@WebServlet("/delete")
public class Launch3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =  req.getParameter("uid");
		
		Employee e = new Employee();
		e.setId(Integer.valueOf(id));
		
		Session s = ConnectionFactory.getSession();
		
		EmployeeDao eDao = new EmployeeDao();
		eDao.deleteEmp(e, s);
		
		resp.sendRedirect("index.jsp");
		
	}
}
