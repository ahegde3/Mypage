

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			Connection conn=Database.get();

			 if(conn==null)
            {PrintWriter out = res.getWriter(); 
			out.println("<html><body><b>Null returned"
					+ "</b></body></html>");
			return ;
			 }
			Statement smt=conn.createStatement();
			String name=req.getParameter("name");
			String user=req.getParameter("user");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			String pass=req.getParameter("pass");
			if(!new PasswordValidator().validate(pass)){ 
				 req.setAttribute("errorMessage", "Password is required:at least six characters, one number, one lowercase and one uppercase letter");
				 req.getRequestDispatcher("./registration.jsp").forward(req,res);
				 smt.close();
		            conn.close();
		            PrintWriter out = res.getWriter(); 
			}
				pass=new CryptWithMD5().cryptWithMD5(pass);
			  System.out.println(pass);
			String country=req.getParameter("country");
			String sql="insert into USERS values('"+user+"','"+name+"','"+pass+"','"+email+"',"+phone+",'"+country+"')";
			smt.executeUpdate(sql);

            smt.close();
            conn.close();
            req.setAttribute("errorMessage", "Successfully registered");
			 req.getRequestDispatcher("./Logout.jsp").forward(req,res);
			
		}catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}

}
