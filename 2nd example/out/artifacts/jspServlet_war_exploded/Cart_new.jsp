<%@ page import="jspservlet.vo.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jspservlet.vo.Product" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/10/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart_New</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/HTML/css/car.css" rel="stylesheet" type="text/css">
</head>
<body>

<%int userID = (int)session.getAttribute("userID"); %>
<%double Sum = 0; %>
<%ArrayList<Cart> cartArrayList = (ArrayList<Cart>)session.getAttribute("list");%>
<%ArrayList<Product> allProducts = (ArrayList<Product>)session.getAttribute("allProducts");%>
<%ArrayList <String> productNameTemp = new ArrayList<>();%>

<div class="headerLinks">
    Welcome! user: <a href="Success_Log_Out.jsp" title="Click to Log out">Log out &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>

<%if(cartArrayList.size() == 0){%>
<p class="change_link" style="text-align: center">
                    <span class="text">Your cart is empty!</span>
                    <span class="text">Back to main page shopping!</span>

                </p >
<%}%>

Welcome,user <%= userID %>. Here is your cart:
<div class="car">

    <div class="good">
        <table><tr><td width=30%>Product</td><td width=20%>Price</td><td width=20%>Num</td><td width=30%>Operation</td></tr></table>
    </div>
<%
    for (int i = 0; i < cartArrayList.size(); i++) {

        for (int j = 0; j < allProducts.size() ; j++) {
            if(cartArrayList.get(i).getProduct_itemID() == allProducts.get(j).getItemID() ){
                productNameTemp.add(allProducts.get(j).getiName());
            }
        }
    }
%>
<%for (int i = 0; i < cartArrayList.size(); i++) {%>

    <div class="goods">
        <table><tr><td width=30%><%=productNameTemp.get(i)%></td>
            <td width=20%><%=cartArrayList.get(i).getcPrice()%></td>
            <td width=20%><%=cartArrayList.get(i).getcNumber()%></td>

<%--            <form method="get" action="/DeleteItemServlet">--%>

<%--                <input name="itemID" type="hidden" value="cartArrayList.get(i).getProduct_itemID()">--%>

<%--            <td width=30%><a><button class="btn1">DELETE</button></a></td>--%>

<%--            </form>--%>

        </table>
    </div>

    <h5> Price: <%=cartArrayList.get(i).getcPrice()%></h5>
    <% Sum +=  cartArrayList.get(i).getcPrice();%>
    <br><br>

<%} %>
    <div class="goods2">
        <table><tr><td width=495
        ></td><td width=30%>Sum：<%=Sum%></td></tr></table>
    </div>
    <form method="get" action="/CheckOut">

        <div class="goods1">
        <table><tr><td width=495
        ></td><td width=50%><button class="btn2">Check Out</button></td></tr></table>
         </div>
                       
    </form>

    <div class="buttomlinks">
        <a href="${pageContext.request.contextPath}/HTML/html1/main_manu2.jsp?userID=<%=userID%>" class="to_Signup"> Go Back to main page </a>
    </div>

</div>
</body>
</html>
