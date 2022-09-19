package jspservlet.servlet;

import jspservlet.dao.Detail_OrderDAO;
import jspservlet.dao.OrderDAO;
import jspservlet.dao.ProductDAO;
import jspservlet.dao.impl.Detail_OrderDAOImpl;
import jspservlet.dao.impl.OrderDAOImpl;
import jspservlet.dao.impl.ProductDAOImpl;
import jspservlet.vo.Detail_Order;
import jspservlet.vo.Order;
import jspservlet.vo.Product;
import jspservlet.vo.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PurchaseServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{}


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{

        Product pro = new Product();
        Order ord = new Order();
        Detail_Order de_Ord = new Detail_Order();
        User user = new User();

        String remainStr = req.getParameter("number_Purchase");
        try{
            Integer.valueOf(remainStr);
            if( Integer.parseInt(remainStr) <= 0){
                HttpSession session=req.getSession();
                session.setAttribute("userID", user.getUserID());
                res.sendRedirect("./Error_Purchase.jsp");
            } else{
                int userID = (int)req.getSession().getAttribute("userID");
                int itemID = (int)req.getSession().getAttribute("itemID");

                user.setUserID(userID);
                System.out.println(userID);

                pro.setNumber_Purchase(Integer.parseInt(remainStr));//设定库存数量
                pro.setItemID(itemID);

                ProductDAO dao = new ProductDAOImpl();
                OrderDAO dao2 = new OrderDAOImpl();
                Detail_OrderDAO dao3 = new Detail_OrderDAOImpl();
                Double purchase_Info [] = new Double[0];
                int addNewOrder_Info [] = new int [0];
                int flag3 =0;
                try{
                    purchase_Info = dao.Purchase(pro);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                ord.setAddress(req.getParameter("address"));
                ord.setUser_userID(userID);
                ord.setoPrice(purchase_Info[1]);
                try{
                    addNewOrder_Info = dao2.AddNewOrder(ord,user);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                de_Ord.setNumber(purchase_Info[2].intValue());
                de_Ord.setdPrice(purchase_Info[1]);
                de_Ord.setOrder_orderID(addNewOrder_Info[1]);
                de_Ord.setProduct_itemID(itemID);
                try{
                    flag3 = dao3.AddNewDetail_Order(de_Ord,ord);
                }catch (Exception e) {
                    e.printStackTrace();
                }

       /*ArrayList order_Detail = new ArrayList<String>();//设置一个传递订单细节的arraylist，传递顺序：price，address，status，oDate
        order_Detail.add(purchase_Info[1]);*/

                if(purchase_Info[0] == 1 && addNewOrder_Info[0]==1 && flag3 == 1){
                    HttpSession session=req.getSession();
                    session.setAttribute("userID", user.getUserID());
                    res.sendRedirect("./Success_Purchase.jsp");
                } else if(addNewOrder_Info[0]==1 && flag3 == 1){
                    res.sendRedirect("./Error_RunOutOfStock.jsp");
                }else{
                    res.sendRedirect("./error.jsp");
                }

            }
        } catch(Exception e){
            res.sendRedirect("./Error_Purchase.jsp");
        }




    }


}
