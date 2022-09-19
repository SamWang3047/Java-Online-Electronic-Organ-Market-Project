package jspservlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class
ProductSearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {}


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        String itemIDStr = req.getParameter("itemID");
        int userID = (int)req.getSession().getAttribute("userID");

        boolean Carod1 = itemIDStr.contains("car");
        boolean Carod2 = itemIDStr.contains("Car");

        boolean Huaxing1 = itemIDStr.contains("hu");
        boolean Huaxing2 = itemIDStr.contains("Hu");

        boolean Kamier1 = itemIDStr.contains("Cak");
        boolean Kamier2 = itemIDStr.contains("cak");

        boolean Kawai1 = itemIDStr.contains("kaw");
        boolean Kawai2 = itemIDStr.contains("Kaw");

        boolean Livid1 = itemIDStr.contains("li");
        boolean Livid2 = itemIDStr.contains("Li");

        boolean Meike1 = itemIDStr.contains("me");
        boolean Meike2 = itemIDStr.contains("Me");

        boolean Shengjie1 = itemIDStr.contains("she");
        boolean Shengjie2 = itemIDStr.contains("She");

        boolean Shoujuan1 = itemIDStr.contains("sho");
        boolean Shoujuan2 = itemIDStr.contains("Sho");

        boolean Yamaha1 = itemIDStr.contains("ya");
        boolean Yamaha2 = itemIDStr.contains("Ya");

        if ( !itemIDStr.equals("")) {
            if (Carod1 || Carod2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/carod22.jsp");
            }
            if (Huaxing1 || Huaxing2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/huaxing2.jsp");
            }
            if (Kamier1 || Kamier2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/kamier2.jsp");
            }
            if (Kawai1 || Kawai2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/kawai2.jsp");
            }
            if (Livid1 || Livid2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/livid2.jsp");
            }
            if (Meike1 || Meike2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/meike2.jsp");
            }
            if (Shengjie1 || Shengjie2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/shengjie2.jsp");
            }
            if (Shoujuan1|| Shoujuan2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/shoujuan2.jsp");
            }
            if (Yamaha1 || Yamaha2){
                HttpSession session = req.getSession();
                session.setAttribute("userID", userID);
                res.sendRedirect("./HTML/html2/yamaha2.jsp");
            }

        } else {
            res.sendRedirect("./error_Search.jsp");
        }

    }
}
