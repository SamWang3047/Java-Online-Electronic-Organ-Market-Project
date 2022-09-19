<%@ page import="java.util.ArrayList" %>
<%@ page import="jspservlet.vo.Cart" %>
<%--
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
    <title>My JSP 'Cart_list.jsp' starting page</title>
</head>

<body>
<%int userID = (int)session.getAttribute("userID"); %>
<%ArrayList<Cart> cartArrayList = (ArrayList<Cart>)session.getAttribute("list");%>

<%if(cartArrayList.size() == 0){%>
<p class="change_link" style="text-align: center">
                    <span class="text">Your cart is empty!</span>
                    <span class="text">Back to main page shopping!</span>

                </p >
<%}%>

Welcome,user <%= userID %>. Here is your cart:

<%for (int i = 0; i < cartArrayList.size(); i++) {%>
<div>
    <h3>CartNo.<%=i+1%>: <%=cartArrayList.get(i).getCartID()%></h3>
    <h5>Product ID:  <%=cartArrayList.get(i).getProduct_itemID()%></h5>
    <h5>Price: <%=cartArrayList.get(i).getcPrice()%></h5>
    <h5>Number: <%=cartArrayList.get(i).getcNumber()%></h5>
    <h5>Total price: <%=cartArrayList.get(i).getcNumber()*cartArrayList.get(i).getcPrice()%></h5>
    <br><br>
</div>
<%}%>
<form method="get" action="/CheckOut">
                <input type="SUBMIT" name="purchase" value="CheckOut" class="buyButton"/>        
</form>
<a href="/HTML/html1/main_manu2.jsp?userID=<%=userID%>" class="to_Signup"> Go Back to main page </a>

</body>
</html>
