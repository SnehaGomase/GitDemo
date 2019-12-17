package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.model.Employee;
import com.model.HiberUtil;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	int did=Integer.parseInt(req.getParameter("reid"));
	Session session=HiberUtil.getSessionFactory().openSession();
	Employee em=session.load(Employee.class, did);
	
	req.setAttribute("EE", em);
	
	RequestDispatcher rd= req.getRequestDispatcher("update.jsp");
	rd.forward(req, resp);
}
}
