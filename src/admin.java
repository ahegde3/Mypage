

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin extends HttpServlet {
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
					String user=req.getParameter("nm");
					String sql="select * from USERS where username='"+user+"'";
					PrintWriter out = res.getWriter(); 
					 ResultSet rs=smt.executeQuery(sql);
					 while(rs.next())
					 {out.println("<html><body><table border='2'><caption>"+user+"<tr><td>name:</td><td>"+rs.getString("name")+"</td></tr>");
					  out.println("<tr><td>emailID:</td><td>"+rs.getString("email")+"</td></tr>");
					  out.println("<tr><td>phone:</td><td>"+rs.getString("phone")+"</td></tr>");
					  out.println("<tr><td>country:</td><td>"+rs.getString("country")+"</td></tr></table></body></html>");
					 }out.println("<form method='post' action='./Logout'><button action='./Logout'>Logout</buttont></form>");
					 rs.close();
					 smt.close();
					 conn.close();
					}catch (Exception e) { 
						System.out.print("admin.java:");
						e.printStackTrace(); 
				}
	}

}
