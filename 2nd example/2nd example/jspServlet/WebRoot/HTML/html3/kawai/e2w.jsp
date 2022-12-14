<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Dream ePiano Online Market</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../css/product.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
<style>
	a{
		text-decoration: none;
	}
</style>
</head>

<body>
<div id="mainWrapper">
  <header> 
    <!-- This is the header content. It contains Logo and links -->
    <div id="logo">
      <img src="../../file/logoImage.png" alt="sample logo" height="100" width="100">
      <!-- Company Logo text -->
    </div>
    <div id="headerLinks"><a href="../../../User_Login.jsp" title="Login/Register">Login/Register</a><a href="#" title="Cart">Cart</a></div>
  </header>
  <div id="content">
    <section class="sidebar"> 
      <!-- This adds a sidebar with 1 searchbox,2 menusets, each with 4 links -->
      <input type="text"  id="search" value="search">
      <div id="menubar">
        <nav class="menu">
          <h2><a href="../../html1/main_manu.jsp"><!-- Title for menuset 1 --><font color="#000000">MAIN MANU</font></a> </h2>
          <hr>
          <ul>
            <!-- List of links under menuset 1 -->
            <li><a href="../../html1/dianziqin.jsp" title="Link">Keyboard</a></li>
            <li><a href="../../html1/shoufengqin.jsp" title="Link">Accordion</a></li>
            <li><a href="../../html1/gangqin.jsp" title="Link">Piano</a></li>
          </ul>
        </nav>
      </div>
    </section>
    <section class="mainContent">
      <div class="productRow"><!-- Each product row contains info of 3 elements -->
        <article class="productInfo"><!-- Each individual product description -->
          <div><img alt="sample" src="../../file/kawai1.jpg"></div>
          <p class="price"><b>ES2 white</b> </p>
          <p class="price"><b>??3012</b> </p>

			<input type="button" name="button" value="Buy" class="buyButton">
        </article>
      </div>
    </section>
  </div>
  <footer>
    <!-- This is the footer with default 3 divs -->
    <div style="margin: 0 auto;text-align: center;">
      <img src="../../file/br.jpg" height="85" width="300" > <img src="../../file/br2.jpg" height="91.443"width="300"><img src="../../file/br3.jpg" height="106.39" width="300">
    </div>
    <div>
      <p><b>About Us: Group 62</b></p >
      <p><b>Tel: +86 18037195169 </b></p >
      <p><b>Email: w304714766@gmail.com</b></p >
      <p><b>Copyright ?? D&P Corporation of China. All rights reserved.</b></p >
    </div>
    <div>
      <p><b>Location: Beijing University of Posts and Telecommunications, South 3rd street,Nan Feng Road, Changping District, Beijing.</b></p >

    </div>
    <div class="footerlinks">
      <p><b><a href="../../../PrivacyAgreement.jsp" title="Link">Privacy Agreements</a></b></p >
      <p><b><a href="../../../UserAgreement.jsp" title="Link">User Agreements</a></b></p >
    </div>
  </footer>
</div>
</body>
</html>
