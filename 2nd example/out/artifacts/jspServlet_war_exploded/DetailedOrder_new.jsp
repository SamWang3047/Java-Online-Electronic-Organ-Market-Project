<%@ page import="jspservlet.vo.Detail_Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jspservlet.vo.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/10/17
  Time: 23:06
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
<%int orderID = Integer.parseInt(request.getParameter("orderID")); %>
<%ArrayList<Detail_Order> detail_orderArrayList = (ArrayList<Detail_Order>)session.getAttribute("detailed_OrderFull");%>
<%ArrayList<Product> allProducts = (ArrayList<Product>)session.getAttribute("allProducts");%>
<%ArrayList <String> productNameTemp = new ArrayList<>();%>

<%
    for (int i = 0; i < detail_orderArrayList.size(); i++) {

        for (int j = 0; j < allProducts.size() ; j++) {
            if(detail_orderArrayList.get(i).getProduct_itemID() == allProducts.get(j).getItemID() ){
                productNameTemp.add(allProducts.get(j).getiName());
            }
        }
    }
%>

<div class="headerLinks">
    Welcome! user: <%=userID%>
</div>

<div class="car">

    <div class="good">
        <table><tr><td width=16.7%>Detailed OrderID</td><td width=16.7%>Item Name</td><td width=16.7%>Numbers</td><td width=16.7%>Price</td><td width=16.7%>Status</td><td width=16.7%>ItemID</td></tr></table>
    </div>
    <%for(int i = 0; i < detail_orderArrayList.size(); i++) {%>

    <%if (detail_orderArrayList.get(i).getOrder_orderID() == orderID){%>
        <div class="goods">
            <table><tr>
                    <td width=16.7%> <%=detail_orderArrayList.get(i).getDetailed_orderID()%></td>
                     <td width=16.7%><%=productNameTemp.get(i)%></td>
                    <td width=16.7%><%=detail_orderArrayList.get(i).getNumber()%></td>
                    <td width=16.7%><%=detail_orderArrayList.get(i).getdPrice()%></td>
                    <td width=16.7%><%=detail_orderArrayList.get(i).getStatus()%></td>
                   <td width=16.7%><%=detail_orderArrayList.get(i).getProduct_itemID()%></td>
    </tr></table>
    </div>
    <%}%>

    <%}%>

    <div class="buttomlinks">
        <a href="#" onclick="javascript:history.back(-1);" class="to_Signup">back</a>
        <br>
        <a href="${pageContext.request.contextPath}/HTML/html1/main_manu2.jsp?userID=<%=userID%>" class="to_Signup"> Go Back to main page </a>
    </div>
</div>

</body>
</html>