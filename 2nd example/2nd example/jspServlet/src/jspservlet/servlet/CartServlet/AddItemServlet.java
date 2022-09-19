package jspservlet.servlet.CartServlet;

import jspservlet.dao.CartDAO;
import jspservlet.dao.impl.CartDAOImpl;
import jspservlet.vo.Cart;
import jspservlet.vo.Product;
import jspservlet.vo.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{

        CartDAO cartDAO = new CartDAOImpl();
        HttpSession session = req.getSession();
        User user = new User();
        Cart cart = new Cart();
        Product pro = new Product();


        int userid = (int)req.getSession().getAttribute("userID");//从jsp获取用户信息

        int productid =(int)req.getSession().getAttribute("itemID");//获取商品信息

        Double price = (Double)req.getSession().getAttribute("iPrice");//获取商品价格
        try {
            Integer.valueOf(req.getParameter("num"));
            int num = Integer.parseInt(req.getParameter("num"));//加入数量

            if (num <= 0) {
                session = req.getSession();
                session.setAttribute("userID", user.getUserID());
                res.sendRedirect("./Error_Purchase.jsp");
            } else {
                int flag = 0;

                //如果没有登录不能加入购物车
                if (userid == 0) {
                    res.sendRedirect("./error.jsp");
                    return;
                }

                cart.setProduct_itemID(productid);
                cart.setcPrice(price);
                cart.setcNumber(num);


                try {
                    cart = cartDAO.find(userid, productid);//是否已经存在
                    if (cart == null) {
                        Cart cart1 = new Cart(price, num, productid, userid);
                        cartDAO.addItem(userid, cart1);
                    } else {
                        num += cart.getcNumber();
                        cartDAO.changeNum(userid, productid, num);

                    }
                    flag = 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (flag == 1) {

                    session.setAttribute("userID", userid);
                    res.sendRedirect("./Add_CartItem_Success.jsp");
                } else {
                    res.sendRedirect("./error.jsp");
                }
            }

        }catch (Exception e) {
            res.sendRedirect("./Error_Purchase.jsp");
            }

    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws ServletException, IOException{

    }
}
