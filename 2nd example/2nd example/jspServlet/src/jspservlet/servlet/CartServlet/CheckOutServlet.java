package jspservlet.servlet.CartServlet;

import jspservlet.dao.CartDAO;
import jspservlet.dao.Detail_OrderDAO;
import jspservlet.dao.OrderDAO;
import jspservlet.dao.impl.CartDAOImpl;
import jspservlet.dao.impl.Detail_OrderDAOImpl;
import jspservlet.dao.impl.OrderDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckOutServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        CartDAO cartDAO = new CartDAOImpl();


        int UserID= (int) req.getSession().getAttribute("userID");


        int flag=0;

        try{
            flag = cartDAO.checkOut(UserID);



        }catch (Exception e) {
            e.printStackTrace();
            flag=0;
        }

        if(flag==1){
            HttpSession session=req.getSession();
            session.setAttribute("userID",UserID);
            res.sendRedirect("./Success_Purchase.jsp");
        }
        else {
            res.sendRedirect("./error.jsp");
        }

    }

    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException, IOException{

    }
}