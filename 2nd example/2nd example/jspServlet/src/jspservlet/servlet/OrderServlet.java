package jspservlet.servlet;

import jspservlet.dao.Detail_OrderDAO;
import jspservlet.dao.OrderDAO;
import jspservlet.dao.impl.Detail_OrderDAOImpl;
import jspservlet.dao.impl.OrderDAOImpl;
import jspservlet.vo.Detail_Order;
import jspservlet.vo.Order;
import jspservlet.vo.Product;
import jspservlet.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {}


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{

        User user = new User();
        Order ord = new Order();
        Detail_Order de_o = new Detail_Order();
        List<Product> allProducts = new ArrayList<>();

        int userID = (int)req.getSession().getAttribute("userID");

        OrderDAO dao1 = new OrderDAOImpl();
        Detail_OrderDAO dao2 =new Detail_OrderDAOImpl();

        ArrayList orderFull_temp = new ArrayList<Order>();

        ArrayList <Order> orderFull_temp2 = new ArrayList<Order>();
        ArrayList detailed_OrderFull_temp = new ArrayList<Detail_Order>();


        boolean flag1 = false;
        boolean flag2 = false;

        user.setUserID(userID);
        try{
            ArrayList order_Full1;
            order_Full1 = dao1.queryByUserID(ord,user);
            for (int i = 0; i < order_Full1.size(); i++) {
                orderFull_temp.add(order_Full1.get(i));
                flag1 = !orderFull_temp.isEmpty();
        }

        }catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < orderFull_temp.size(); i++) {
            orderFull_temp2.add((Order)orderFull_temp.get(i));
        }
       // System.out.println(orderFull_temp2.size());

        //int[][] a = new int [orderFull_temp2.get(i).getOrderID()][];
       for (int i = 0; i < orderFull_temp2.size(); i++) {
           ArrayList detailed_Order_Full1;

            ord.setOrderID(orderFull_temp2.get(i).getOrderID());
            try{
                //dao2.queryByItemID(de_o,ord);
                //System.out.println(dao2.queryByItemID(de_o,ord).get(i));
                detailed_Order_Full1 = dao2.queryByItemID(de_o,ord);
                for (int j = 0; j <detailed_Order_Full1.size(); j++) {
                    detailed_OrderFull_temp.add(detailed_Order_Full1.get(j));
                }
                    flag2 = !detailed_OrderFull_temp.isEmpty();

                allProducts = dao2.getALlProducts();
            }catch (Exception e) {
                 e.printStackTrace();
            }
        }

       if(flag1&&flag2){
            HttpSession session=req.getSession();
            session.setAttribute("userID", user.getUserID());
            session.setAttribute("order_Full",orderFull_temp);
            session.setAttribute("detailed_OrderFull",detailed_OrderFull_temp);
            session.setAttribute("allProducts",allProducts);
            res.sendRedirect("./Order_new.jsp");
        } else {
            res.sendRedirect("./error.jsp");
        }
    }
}
