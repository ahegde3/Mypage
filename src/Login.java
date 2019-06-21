

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			Connection conn=Database.get();
			
			 if(conn==null)
             {PrintWriter out = res.getWriter(); 
 			out.println("<html><body><b>Null returned"
					+ "</b></body></html>");
 			return ;
 			 }
			Statement smt=conn.createStatement();
			
			
			 String user=req.getParameter("user");
			 String pass=new CryptWithMD5().cryptWithMD5(req.getParameter("pass"));
			 System.out.println("Username"+user+" password"+pass);
			 String sql="select name,pass from USERS where username='"+user+"'";
			 String name=null;
			 ResultSet rs=smt.executeQuery(sql);
			 String result=null;
			 while(rs.next()) {result=rs.getString("pass"); name=rs.getString("name");}
			 if(result.equals(pass)){
				 HttpSession session=req.getSession();  
			      session.setAttribute("name",name);  
				 if(user.equals("admin")){
					 sql="select username from USERS";
					 rs=smt.executeQuery(sql);
					 String state=" ";
					 while(rs.next())
					 { state+="<option>"+rs.getString("username")+"</option>";}
					 PrintWriter out = res.getWriter(); 
					 out.println("<html><body><h1>Administrator zone</h1><form action='./adminView' method='post'>Users<select name='nm'>"+state+ "</select><br><input type='submit'></form></body></html>");
					 out.println("<form method='post' action='./Logout'><button action='./Logout'>Logout</buttont></form>");
				 }else{
					 //RequestDispatcher rd=req.getRequestDispatcher("./Home");
					 res.sendRedirect("./Home");
					 //rd.forward(req, res); 
				 } }
			 else {System.out.println("wrong password");
			 req.setAttribute("errorMessage", "Wrong username or Pass");
			 req.getRequestDispatcher("./index.jsp").forward(req,res);
			  //rd.include (req,res);
			 }rs.close();
			 smt.close(); 
			 conn.close(); 
			 
		}catch (Exception e) { 
			System.out.print("Login.java:");
			e.printStackTrace(); 
		} 
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}

}
