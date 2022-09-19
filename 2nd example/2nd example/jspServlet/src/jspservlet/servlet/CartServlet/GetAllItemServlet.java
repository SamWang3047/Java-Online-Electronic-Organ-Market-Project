package jspservlet.servlet.CartServlet;


import jspservlet.dao.CartDAO;
import jspservlet.dao.impl.CartDAOImpl;
import jspservlet.vo.Cart;
import jspservlet.vo.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class GetAllItemServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{
        CartDAO cartDAO = new CartDAOImpl();
        List<Cart> list = new ArrayList<Cart>();
        List<Product> allProducts = new ArrayList<>();
        double price=0;

        int UserID= (int) req.getSession().getAttribute("userID");

        int flag=0;

        try{
            double[] temp = new double[2];
            temp = cartDAO.allPrice(UserID);
            list = cartDAO.getAllItems(UserID);//购物车数组
            price = temp[1];//总价
            allProducts = cartDAO.getALlProducts();
            flag = (int) temp[0];

        }catch (Exception e) {
            e.printStackTrace();
            flag=0;
        }

        if(flag==1){
            HttpSession session=req.getSession();
            session.setAttribute("list",list);
            session.setAttribute("price",price);
            session.setAttribute("userID",UserID);
            session.setAttribute("allProducts",allProducts);
            res.sendRedirect("./Cart_new.jsp");
        }
        else {
            res.sendRedirect("./error.jsp");
        }

    }

    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException, IOException{

    }
}
