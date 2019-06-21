

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Home extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  res.setContentType("text/html");  
		  HttpSession session=req.getSession(false);  
	        if(session!=null){  
	        String name=(String)session.getAttribute("name");  
	        System.out.println(name);
	        if(name==null ) res.sendRedirect("./index.jsp");  
	        else
	        //req.getRequestDispatcher("./home.html").forward(req,res);
	        res.sendRedirect("./home.html");
	        }  
	        else{  
	        	res.sendRedirect("./index.jsp");  
	        	 //req.getRequestDispatcher("./index.jsp").forward(req,res);
	        }  
	    	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}
}
