<%@ page import="jspservlet.vo.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Dream ePiano Online Market</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/eCommerceStyle.css" rel="stylesheet" type="text/css">
    <!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
    <script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>
<%int userID = (int)session.getAttribute("userID"); %>
<%ArrayList<Product> allProducts = (ArrayList<Product>)session.getAttribute("allProducts");%>
<%ArrayList<Product> extraProducts = new ArrayList<>();%>
<%
    for (int i = 0; i < allProducts.size(); i++) {
        if (allProducts.get(i).getItemID() > 10038){
            Product pro = allProducts.get(i);
            extraProducts.add(pro);
        }
    }
%>
<%session.setAttribute("extraProducts",extraProducts);%>

<div id="mainWrapper">
    <header>
        <!-- This is the header content. It contains Logo and links -->
        <div id="logo">
            <img src="../file/logoImage.png" alt="sample logo" height="100" width="100">
            <!-- Company Logo text -->
        </div>
        <div id="headerLinks">
            <form method="get" action="/GetAllItem" style="">
                Welcome! user:<%=userID%><a href="../../Success_Log_Out.jsp" title="Click to Log out">Log out &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <input align="center" type = "SUBMIT" value = "Cart" onclick = "window.location.href = 'Cart_new.jsp'" style="background-color:white;border: none;color:rgba(146,146,146,1.00);cursor:pointer;">
            </form></div>

    </header>
    <section id="offer">
        <!-- The offer section displays a banner text for promotions -->
        <h2>Welcome to</h2>
        <p>Dream ePiano Online Market</p>
    </section>
    <div id="content">
        <section class="sidebar">
            <!-- This adds a sidebar with 1 searchbox,2 menusets, each with 4 links -->

            <form method="post" action="/proSearch">
                <label><input type="text" name="itemID" placeholder="Please enter the item keys"/></label>
                <input type="SUBMIT"  id="search" value="search">
                </form>

            <div id="menubar">
                <nav class="menu">
                    <h2><a href="main_manu2.jsp"><!-- Title for menuset 1 --><font color="#000000">MAIN MENU</font></a> </h2>
                    <hr>
                    <ul>
                        <!-- List of links under menuset 1 -->
                        <li><a href="dianziqin2.jsp" title="Link">Keyboard</a></li>
                        <li><a href="shoufengqin2.jsp" title="Link">Accordion</a></li>
                        <li><a href="gangqin2.jsp" title="Link">Piano</a></li>
                    </ul>
                </nav>

                <nav class="menu">
                    <h2><!-- Title for menuset 1 --><font color="#000000">USER INFORMATION</font> </h2>
                    <hr>
                    <ul>
                        <!-- List of links under menuset 1 -->
                        <li><a href="../../User_Update.jsp" title="Link">User Information Update</a></li>
                        <li><a href="../../User_Delete.jsp" title="Link">Delete Your Account</a></li>

                    </ul>
                </nav>

                <nav class="menu">
                    <h2><!-- Title for menuset 1 --><font color="#000000">USER ORDER</font> </h2>
                    <hr>
                    <ul>
                        <!-- List of links under menuset 1 -->

                        <li><form method="post" action="/order">
                            <input align="center" type = "SUBMIT" value = "Order"
                                   onclick = "window.location.href = 'Order.jsp'"
                                   style="padding-left: 0; background-color:rgba(246,246,246,1.00);border: none;
                                   color:rgba(146,146,146,1.00);cursor:pointer;">
                    </form></li>

                    </ul>
                </nav>
            </div>

        </section>
        <section class="mainContent">
            <div class="productRow"><!-- Each product row contains info of 3 elements -->
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="../file/yamaha.jpg" height="180"></div>
                    <p class="price">Yamaha</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/yamaha2.jsp'">
                </article>
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="../file/huaxing.jpg" height="180"></div>
                    <p class="price">Huaxing</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/huaxing2.jsp'">
                </article>
                <article class="productInfo"> <!-- Each individual product description -->
                    <div><img alt="sample" src="../file/Or1.jpg" height="180"></div>
                    <p class="price">Cake Organ</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/kamier2.jsp'">
                </article>
            </div>
            <div class="productRow">
                <!-- Each product row contains info of 3 elements -->
                <article class="productInfo"> <!-- Each individual product description -->
                    <div><img alt="sample" src="../file/kawai.jpg" height="180"></div>
                    <p class="price">Kawai</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/kawai2.jsp'">
                </article>
                <article class="productInfo"> <!-- Each individual product description -->
                    <div><img alt="sample" src="../file/livid.jpg" height="180"></div>
                    <p class="price">Livid</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/livid2.jsp'">
                </article>
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="../file/meike.jpg" height="180"></div>
                    <p class="price">Meike</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/meike2.jsp'">
                </article>
            </div>
            <div class="productRow">
                <article class="productInfo"> <!-- Each individual product description -->
                    <div><img alt="sample" src="../file/shengjie.jpg" height="180"></div>
                    <p class="price">Shengjie</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/shengjie2.jsp'">
                </article>
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="../file/shoujuan.jpg" height="180"></div>
                    <p class="price">Shoujuan</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/shoujuan2.jsp'">
                </article>
                <article class="productInfo"><!-- Each individual product description -->
                    <div><img alt="sample" src="../file/carod.jpg" height="180"></div>
                    <p class="price">Carod</p>
                    <input type="button" name="button" value="Buy" class="buyButton" onclick="location.href='../html2/carod22.jsp'">
                </article>
            </div>

            <%
                for (int i = 0; i < extraProducts.size(); i++) {

                    out.print("<div class=\"productRow\">");
                    out.print("<br>");
                    out.print("<br>");
                    out.print("<br>");
                    out.print("<br>");
                    out.print("<br>");
                    out.print("<br>");
                    out.print("<article class=\"productInfo\">");
                    out.print("<p class=\"price\">"+extraProducts.get(i).getiName()+"</p>");
                    out.print("<input type=\"button\" name=\"button\" value=\"Buy\" class=\"buyButton\" onclick=\"location.href='../../ExtraProducts.jsp'\">");
                    out.print("</article>");
                    out.print("</div>");
                }

            %>

        </section>
    </div>
    <footer>
        <!-- This is the footer with default 3 divs -->
        <div style="margin: 0 auto;text-align: center;">
            <img src="../file/br.jpg" height="85" width="300" > <img src="../file/br2.jpg" height="91.443"width="300"><img src="../file/br3.jpg" height="106.39" width="300">
        </div>
        <div>
            <p><b>About Us: Group 62</b></p >
            <p><b>Tel: +86 18037195169 </b></p >
            <p><b>Email: w304714766@gmail.com</b></p >
            <p><b>Copyright © D&P Corporation of China. All rights reserved.</b></p >
        </div>
        <div>
            <p><b>Location: Beijing University of Posts and Telecommunications, South 3rd street,Nan Feng Road, Changping District, Beijing.</b></p >

        </div>
        <div class="footerlinks">
            <p><b><a href="../../PrivacyAgreement.jsp" title="Link">Privacy Agreements</a></b></p >
            <p><b><a href="../../UserAgreement.jsp" title="Link">User Agreements</a></b></p >
        </div>
    </footer>
</div>
</body>
</html>
