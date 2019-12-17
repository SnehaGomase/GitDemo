package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Employee;
import com.model.HiberUtil;

@WebServlet(urlPatterns = "/delet")
public class DeletServlet extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	int did=Integer.parseInt(req.getParameter("reid"));
	Session session=HiberUtil.getSessionFactory().openSession();
	Employee em=session.load(Employee.class, did);
	session.delete(em);
	session.beginTransaction().commit();
	
	
		
		  Session session2=HiberUtil.getSessionFactory().openSession(); 
		  Query<Employee> q=session2.createQuery("from Employee"); 
		  List<Employee>list=q.getResultList(); req.setAttribute("LIST", list);
		  
		  RequestDispatcher rd=req.getRequestDispatcher("success.jsp"); rd.forward(req,
		  resp);
		 
			
}
}
