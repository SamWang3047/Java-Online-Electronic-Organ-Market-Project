<%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/7/2
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page 2</title>
</head>

<p align="center"><font color = "red" size = "+6" > Main </font></p>

<p align="center"><font color = "red" size = "+6" > Page </font></p>



<body>
<%int username = (int)session.getAttribute("userID"); %>

<p> <%=username%><p>

    <input align="center" type = "button" value = "Register" onclick = "window.location.href = 'User_Register.jsp'">
    <input align="center" type = "button" value = "Login" onclick = "window.location.href = 'User_Login.jsp'">
    <input align="center" type = "button" value = "UserUpdate" onclick = "window.location.href = 'User_Update.jsp'">
    <input align="center" type = "button" value = "UserDelete" onclick = "window.location.href = 'User_Delete.jsp'">
    <br><br>
    <input align="center" type = "SUBMIT" value = "Purchase" onclick = "window.location.href = 'Item_Purchase.jsp'">

    <form method="post" action="/order">
    <input align="center" type = "SUBMIT" value = "Order" onclick = "window.location.href = 'Order.jsp'">
    </form>

    <input align="center" type = "SUBMIT" value = "AddItem" onclick = "window.location.href = 'Cart_add.jsp'">

    <br>
    <form method="get" action="/GetAllItem">
        <input align="center" type = "SUBMIT" value = "GetAllItem" onclick = "window.location.href = 'Cart_list1.jsp'">
    </form>


</body>
</html>
