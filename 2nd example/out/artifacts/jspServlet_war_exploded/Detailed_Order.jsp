<%@ page import="jspservlet.vo.Detail_Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/7/4
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My JSP 'Detailed_Order.jsp'</title>
</head>
<body>
<%int userID = (int)session.getAttribute("userID"); %>
<%int orderID = Integer.parseInt(request.getParameter("orderID")); %>
<%ArrayList<Detail_Order> detail_orderArrayList = (ArrayList<Detail_Order>)session.getAttribute("detailed_OrderFull");%>

<%for(int i = 0; i < detail_orderArrayList.size(); i++) {%>
    <%if (detail_orderArrayList.get(i).getDetailed_orderID() == orderID){%>
    <h3>Detailed OrderID<%=i+1%>: <%=detail_orderArrayList.get(i).getDetailed_orderID()%></h3>
    <h4>Numbers: <%=detail_orderArrayList.get(i).getNumber()%></h4>
    <h4>Price:  <%=detail_orderArrayList.get(i).getdPrice()%></h4>
    <h4>Status: <%=detail_orderArrayList.get(i).getStatus()%></h4>
    <h4>ItemID: <%=detail_orderArrayList.get(i).getProduct_itemID()%></h4>
    <br><br>
    <%}%>

<%}%>
<a href="#" onclick="javascript:history.back(-1);" class="to_Signup">back</a>
<h2><a href="./HTML/html1/main_manu2.jsp"><!-- Title for menuset 1 --><font color="#000000">MAIN MANU</font></a> </h2>
</body>
</html>
