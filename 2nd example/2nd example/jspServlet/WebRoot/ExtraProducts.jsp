<%@ page import="jspservlet.vo.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: The Deicide
  Date: 2020/10/21
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Dream ePiano Online Market</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="HTML/css/product.css" rel="stylesheet" type="text/css">
    <!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
    <script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>

<body>
<%int userID = (int)session.getAttribute("userID"); %>
<%ArrayList<Product> extraProducts = (ArrayList<Product>)session.getAttribute("extraProducts");%>
<%double iPrice = extraProducts.get(0).getiPrice();%>
<%int itemID = extraProducts.get(0).getItemID();%>
<%String iName = extraProducts.get(0).getiName();%>
<%session.setAttribute("itemID",itemID);%>
<%session.setAttribute("iPrice",iPrice);%>


<div id="mainWrapper">
    <header>
        <!-- This is the header content. It contains Logo and links -->
        <div id="logo"> <!-- <img src="logoImage.png" alt="sample logo"> -->
            <!-- Company Logo text -->
            LOGO </div>
        <div id="headerLinks">
            <form method="get" action="/GetAllItem" style="">
                Welcome! user:<%=userID%><a href="Success_Log_Out.jsp" title="Click to Log out">Log out &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <input align="center" type = "SUBMIT" value = "Cart" onclick = "window.location.href = 'Cart_new.jsp'" style="background-color:white;border: none;color:rgba(146,146,146,1.00);cursor:pointer;">
            </form></div>
    </header>
    <div id="content">
        <section class="sidebar">
            <!-- This adds a sidebar with 1 searchbox,2 menusets, each with 4 links -->
            <input type="text"  id="search" value="search">
            <div id="menubar">
                <nav class="menu">
                    <h2><a href="HTML/html1/main_manu2.jsp"><!-- Title for menuset 1 --><font color="#000000">MAIN MANU</font></a> </h2>
                    <hr>
                    <ul>
                        <!-- List of links under menuset 1 -->
                        <li><a href="HTML/html1/dianziqin2.jsp" title="Link">Keyboard</a></li>
                        <li><a href="HTML/html1/shoufengqin2.jsp" title="Link">Accordion</a></li>
                        <li><a href="HTML/html1/gangqin2.jsp" title="Link">Piano</a></li>
                    </ul>
                </nav>
            </div>
        </section>
        <section class="mainContent">
            <div class="productRow"><!-- Each product row contains info of 3 elements -->
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="HTML/file/carod.jpg"></div>
                    <p class="price"><b><%=iName%></b> </p>
                    <p class="price"><b><%=iPrice%></b> </p>

                    <form method="post" action="/purchase">
                        <label><input type="text" name="number_Purchase" placeholder="Number you want buy." /></label>
                                    <input type="SUBMIT" name="purchase" value="Purchase" class="buyButton"/>        
                    </form>

                    <form method="get" action="/AddItem">
                        <label><input type="text" name="num" placeholder="Number to add cart" /></label>
                                    <input type="SUBMIT" name="AddItem" value="Add Cart" class="buyButton"/>        
                    </form>
                </article>
            </div>
        </section>
    </div>
</div>
</body>
</html>

