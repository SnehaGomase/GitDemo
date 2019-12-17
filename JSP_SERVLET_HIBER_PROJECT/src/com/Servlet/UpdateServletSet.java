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

@WebServlet(urlPatterns = "/update1")

public class UpdateServletSet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	 Employee emp=new Employee();
	 emp.setReid(Integer.parseInt(req.getParameter("reid")));
	 emp.setEname(req.getParameter("ename"));
	 emp.setEaddr(req.getParameter("eaddr"));
	 emp.setUsername(req.getParameter("username"));
	 emp.setPassword(req.getParameter("password"));
	 Session session=HiberUtil.getSessionFactory().openSession();
	 session.update(emp);
	 session.beginTransaction().commit();
	 
	Query q=session.createQuery("from Employee");
	List<Employee> list=q.getResultList();
	req.setAttribute("LIST", list);

	RequestDispatcher re=req.getRequestDispatcher("success.jsp");
	re.forward(req, resp); 
}
}