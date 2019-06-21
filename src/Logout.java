

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.Cookie;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;


public class Logout extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  res.setContentType("text/html");  
	        PrintWriter out=res.getWriter();  
	        
	        
	        HttpSession session=req.getSession(false);  
	        if(session==null) {  
	        	                 res.sendRedirect("./index.jsp"); 
	                             return;
	                           }
	        System.out.println((String)session.getAttribute("name"));
	        session.setAttribute("name"," "); 
            session.invalidate();  
            req.setAttribute("errorMessage", "Successfully LoggedOut");
			 req.getRequestDispatcher("./Logout.jsp").forward(req,res);
	       // res.sendRedirect("./Logout.html"); 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}
}