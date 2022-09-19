<%@ page import="jspservlet.vo.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/10/17
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order_New</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/HTML/css/order.css" rel="stylesheet" type="text/css">
</head>
<body>

<%int userID = (int)session.getAttribute("userID"); %>
<%ArrayList<Order> orderArrayList = (ArrayList<Order>)session.getAttribute("order_Full");%>

<div class="headerLinks">
    Welcome! user: <%=userID%>
</div>

<div class="car">

    <div class="good">
        <table><tr><td width=25%>OrderID</td><td width=25%>Total Price</td><td width=25%>Address</td><td width=25%>Date</td></tr></table>
    </div>
    <%for(int i = 0; i < orderArrayList.size(); i++) {%>
    <div class="goods">
        <table><tr><td width=25%> <a href="DetailedOrder_new.jsp?orderID=<%=orderArrayList.get(i).getOrderID()%>" class="to_Signup"> <%=orderArrayList.get(i).getOrderID()%> </a></td>
            <td width=25%><%=orderArrayList.get(i).getoPrice()%></td>
            <td width=25%><%=orderArrayList.get(i).getAddress()%></td>
            <td width=25%><%=orderArrayList.get(i).getDate()%></td>
        </tr></table>
    </div>

    <%}%>

    <div class="buttomlinks">
        <a href="${pageContext.request.contextPath}/HTML/html1/main_manu2.jsp?userID=<%=userID%>" class="to_Signup"> Go Back to main page </a>
    </div>
</div>

</body>
</html>
