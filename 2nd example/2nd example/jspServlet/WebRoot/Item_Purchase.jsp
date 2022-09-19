<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/7/2
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item_Purchase.jsp</title>
</head>
<body>
    <%int temp_userID = (int)session.getAttribute("userID");%>
    <p> <%=temp_userID%><p>
                <form method="post" action="/purchase">
    <label><input type="text" name="itemID" placeholder="Please enter itemID"/></label>
    <label><input type="text" name="number_Purchase" placeholder="Please enter number you want buy." /></label>

                <input type="SUBMIT" name="purchase" value="Purchase"/>        
            </form>
    <a href="2Main_Page.jsp" class="to_Signup"> Go Back to main page </a>
</body>
</html>
