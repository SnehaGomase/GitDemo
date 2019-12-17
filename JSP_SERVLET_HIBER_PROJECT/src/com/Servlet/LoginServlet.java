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

@WebServlet(urlPatterns = "/log")
public class LoginServlet extends HttpServlet
{@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String uname=req.getParameter("username");
	 String pass=req.getParameter("password");
	 
	 if(uname.equals("admin")&&pass.equals("admin123"))
	 {
	 Session session=HiberUtil.getSessionFactory().openSession();
	 
	 Query q=session.createQuery("from Employee");
	 
	 List<Employee>list=q.getResultList();
	 
	 req.setAttribute("LIST", list);
	 }
	 else
	 {
		Session session1=HiberUtil.getSessionFactory().openSession();
		
		Query q1=session1.createQuery("from Employee where username=? and password=?");
		q1.setParameter(0, uname);
		q1.setParameter(1, pass);
		
		List<Employee>list=q1.getResultList();
		req.setAttribute("LIST", list);
	 }
	 
	 RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
	 rd.forward(req, resp);
	 
}
	
}
