package jspservlet.servlet.UserServlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.Product;
import jspservlet.vo.User;

public class LoginServlet extends HttpServlet {

	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
//		 User user = new User();
//		 user.setUsername(req.getParameter("username"));
//		 user.setPassword(req.getParameter("password"));
//		 
//		 UserDAO dao = new UserDAOImpl();   
//	     int flag = 0;
//	     try {
//				flag = dao.queryByUsername(user);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		} 
//		 if(flag == 1){   
//			 HttpSession session=req.getSession();   
//	         session.setAttribute("username", user.getUsername());   
//	         res.sendRedirect("./welcome.jsp");
//	        } else {   
//	         res.sendRedirect("./error.jsp");
//	        }
	 }
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 User user = new User();

		 List<Product> allProducts = new ArrayList<>();

		 String a1 =req.getParameter("userID");
		 int a = Integer.parseInt(a1);

		 user.setUserID(a);
		 user.setuPassword(req.getParameter("uPassword"));

		 
		 UserDAO dao = new UserDAOImpl();   
	     int flag = 0;
	     try {
				flag = dao.queryByUsername(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		 try {
			 allProducts = dao.getALlProducts();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }

		 if(flag == 1){
			 HttpSession session=req.getSession();
	         session.setAttribute("userID", user.getUserID());
			 session.setAttribute("allProducts",allProducts);
	         res.sendRedirect("./HTML/html1/main_manu2.jsp");
	        } else {
	         res.sendRedirect("./Login_Error.jsp");
	        }
	 }
}
	 