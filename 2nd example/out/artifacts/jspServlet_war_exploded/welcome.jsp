<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'welcome.jsp' starting page</title>
  </head>
  
  <body>
    <%int userID = (int)session.getAttribute("userID"); %>
    welcome   <%= userID %>

   <br> <a href="/HTML/html1/main_manu2.jsp?userID=<%=userID%>" class="to_Signup"> Go Back to main page </a>
  </body>
</html>