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

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{}


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{

        User user = new User();
        user.setuName(req.getParameter("uName"));
        user.setTel(req.getParameter("tel"));
        user.setuPassword(req.getParameter("uPassword"));
        user.setuDate(req.getParameter("uDate"));
        user.setGender(req.getParameter("gender"));
        user.setAddress(req.getParameter("address"));

        UserDAO dao = new UserDAOImpl();
        int flag[] = new int[0];
            try{
                flag = dao.addUser(user);
            }catch (Exception e) {
                e.printStackTrace();
            }

        if(flag[0] == 1){
            HttpSession session=req.getSession();
            session.setAttribute("uName", user.getuName());
            session.setAttribute("userID", flag[1]);
            res.sendRedirect("./Welcome_Regis.jsp");
        } else {
            res.sendRedirect("./Error_Regis.jsp");
        }
    }

}
