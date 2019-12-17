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

@WebServlet(urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		Session session=HiberUtil.getSessionFactory().openSession();
		Employee e=new Employee();
		e.setEname(req.getParameter("ename"));
        e.setEaddr(req.getParameter("eaddr"));
        e.setUsername(req.getParameter("username"));
        e.setPassword(req.getParameter("password"));
        session.save(e);
        session.beginTransaction().commit();
        
        RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
        
        
		
	}
}