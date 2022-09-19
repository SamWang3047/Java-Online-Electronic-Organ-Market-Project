package jspservlet.servlet.UserServlet;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {}

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        User user = new User();

        int userID_Temp = Integer.parseInt(req.getParameter("userID"));
        user.setUserID(userID_Temp);
        UserDAO dao = new UserDAOImpl();
        int flag = 0;
        try{
            flag = dao.delUser(user);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(flag == 1){
            HttpSession session= req.getSession();
            session.setAttribute("uName", user.getuName());
            System.out.println("É¾³ý³É¹¦");
            res.sendRedirect("./Welcome_Delete.jsp");
        } else {
            res.sendRedirect("./Error_Regis.jsp");
        }
    }
}
