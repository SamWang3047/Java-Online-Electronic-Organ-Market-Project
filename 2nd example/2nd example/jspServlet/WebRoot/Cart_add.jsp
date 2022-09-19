<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>

<%int temp_userID = (int)session.getAttribute("userID");%>
<p> <%=temp_userID%><p>

<form method="get" action="/AddItem">

    <label><input type="text" name="Product_itemID" placeholder="Please enter Product_itemID"/></label>
    <br>
    <label><input type="text" name="price" placeholder="Please enter price." /></label>
    <br>
    <label><input type="text" name="num" placeholder="Please enter num." /></label>
    <br>
    <input type="SUBMIT" name="AddItem" value="Add"/>        
    <a href="2Main_Page.jsp" class="to_Signup"> Go Back to main page </a>


</form>



</body>
</html>