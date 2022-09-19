package jspservlet.servlet.CartServlet;

import jspservlet.dao.CartDAO;
import jspservlet.dao.impl.CartDAOImpl;
import jspservlet.vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeNumServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
        Cart cart=new Cart();
        cart.setCartID(Integer.parseInt(req.getParameter("cartID")));
        cart.setProduct_itemID(Integer.parseInt(req.getParameter("Product_itemID")));
        int num = Integer.parseInt(req.getParameter("num"));  //修改成几个


        CartDAO dao = new CartDAOImpl();
        int flag=0;
        try {
            flag = dao.changeNum(cart.getUser_userID(),cart.getProduct_itemID(),num);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(flag == 1){
            HttpSession session=req.getSession();
            session.setAttribute("num", cart.getcNumber());
            session.setAttribute("userID",cart.getUser_userID());

            res.sendRedirect("./welcome.jsp");//购物车添加成功页面
        } else {
            res.sendRedirect("./error.jsp");//购物车添加失败页面
        }

    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException{ }

}
