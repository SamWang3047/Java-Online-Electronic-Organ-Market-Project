package jspservlet.servlet;

import jspservlet.dao.Detail_OrderDAO;
import jspservlet.dao.OrderDAO;
import jspservlet.dao.impl.Detail_OrderDAOImpl;
import jspservlet.dao.impl.OrderDAOImpl;
import jspservlet.vo.Detail_Order;
import jspservlet.vo.Order;
import jspservlet.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class Detailed_OrderServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {}

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        Order ord = new Order();
        Detail_Order de_o = new Detail_Order();


    }
}
