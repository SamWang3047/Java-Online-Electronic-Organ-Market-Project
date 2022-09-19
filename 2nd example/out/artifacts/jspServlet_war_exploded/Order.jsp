<%@ page import="java.util.ArrayList" %>
<%@ page import="jspservlet.vo.Order" %>
<%@ page import="jspservlet.vo.Detail_Order" %><%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/7/3
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'Order.jsp' starting page</title>
</head>

<body>
<%int userID = (int)session.getAttribute("userID"); %>
<%ArrayList<Order> orderArrayList = (ArrayList<Order>)session.getAttribute("order_Full");%>
Welcome,user <%= userID %>. Here is your order:
<br><br>Please click order numbers for more details.

<form method="post" action="/Order_Delete">
    <label><input type="text" name="orderID" placeholder="The order you want to delete" /></label>
                <input type="SUBMIT" name="Order_Delete" value="Delete" class="buyButton"/>        
</form>

    <%for(int i = 0; i < orderArrayList.size(); i++) {%>
    <div>

        <h3>OrderID<%=i+1%>: <a href="Detailed_Order.jsp?orderID=<%=orderArrayList.get(i).getOrderID()%>" class="to_Signup"><%=orderArrayList.get(i).getOrderID()%></a></h3>
        <h5>Total Price: <%=orderArrayList.get(i).getoPrice()%></h5>
        <h5>Address:  <%=orderArrayList.get(i).getAddress()%></h5>
        <h5>Order Date: <%=orderArrayList.get(i).getDate()%></h5>
        <br><br>
    </div>
    <%}%>

<h2><a href="./HTML/html1/main_manu2.jsp"><!-- Title for menuset 1 --><font color="#000000">MAIN MANU</font></a> </h2>
</body>
</html>