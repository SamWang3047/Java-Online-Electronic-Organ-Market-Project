package jspservlet.servlet;

import jspservlet.dao.OrderDAO;
import jspservlet.dao.impl.OrderDAOImpl;
import jspservlet.vo.Order;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Order_DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {}

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        Order ord = new Order();

        int orderID_Temp = Integer.parseInt(req.getParameter("orderID"));
        ord.setOrderID(orderID_Temp);
        OrderDAO dao = new OrderDAOImpl();
        int flag = 0;
        try{
            flag = dao.DeleteOrder(ord);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(flag == 1){
            HttpSession session= req.getSession();
            //session.setAttribute("uName", ord.getuName());
            System.out.println("É¾³ý³É¹¦");
            res.sendRedirect("./Welcome_Delete.jsp");
        } else {
            res.sendRedirect("./Error_Regis.jsp");
        }
    }
}
