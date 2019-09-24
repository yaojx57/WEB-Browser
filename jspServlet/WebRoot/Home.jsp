<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->

<head>
  <!-- =====  BASIC PAGE NEEDS  ===== -->
  <meta charset="utf-8">
  <title>Home</title>
  <!-- =====  SEO MATE  ===== -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="description" content="Eletric guide dog">
  <meta name="keywords" content="Eletric guide dog">
	<!--meta name="description" content="meta keywords +网页关键字
         description +网页描述文字
     用于让一些搜索引擎搜索到该网页"-->
  <meta name="distribution" content="global">
  <meta name="revisit-after" content="2 Days">
  <meta name="robots" content="ALL">
  <meta name="rating" content="8 YEARS">
  <meta name="Language" content="en-us">
  <meta name="GOOGLEBOT" content="NOARCHIVE">
  <!-- =====  MOBILE SPECIFICATION  ===== -->
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="viewport" content="width=device-width">
  <!-- =====  CSS  ===== -->
  <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
  <link rel="stylesheet" type="text/css" href="css/magnific-popup.css">
  <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
  <style type="text/css">
  @import url("css/style.css");
  </style>
  <link href="cpts_1755_cze/css/style.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/bootstrap.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/ionicons.min.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/jquery-ui.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/magnific-popup.css" rel="stylesheet" type="text/css">
  <link href="cpts_1755_cze/css/owl.carousel.css" rel="stylesheet" type="text/css">
</head>

<body>
    <!-- =====  HEADER START  ===== -->
    <header id="header">
      <div class="header">
        <div class="container">
          <nav class="navbar">
            <div class="navbar-header mtb_20"> <img alt="DOG" src="images/logo.png" width="200"> </div>
			  <div class="collapse navbar-collapse js-navbar-collapse pull-right">
           		<ul id="menu" class="nav navbar-nav" style="text-align: center;list-style: none">           
				    <li> <form action="Home.jsp"  ><input type="submit" value="HOME" class="titlelist"></form></li>
				 
				    <li> <form action="./ListMyAccount"  method="post" ><input type="submit" value="MY ACCOUNT" class="titlelist"></form></li>
	
	                <li><form action="./ListShoppingCart" method="post" > <input type="submit" value="SHOPPING CART" class="titlelist"></form></li>
	
	                <li> <form action="./ListProduct" method="post" ><input type="submit" value="PRODUCT" class="titlelist"></form></li>
	
	                <li><a href="About.jsp" class="titlelist" style="display: table-cell;vertical-align: middle;text-align: center">ABOUT US</a></li>
	            </ul>
              </div>
            <!-- /.nav-collapse -->
          </nav>
        </div>
      </div>
      <div class="header-bottom">
        <div class="container">
          <div class="row">
            <div class="col-sm-4 col-md-4 col-lg-3">
              <div class="category">
                <div class="menu-bar" data-target="#category-menu,#category-menu-responsive" data-toggle="collapse" aria-expanded="true" role="button">
                  <h4 class="category_text">Top category</h4>
                  <span class="i-bar"><i class="fa fa-bars"></i></span></div>
              </div>
              <div id="category-menu-responsive" class="navbar collapse " aria-expanded="true" style="" role="button">
              </div>
            </div>
            <div class="col-sm-8 col-md-8 col-lg-9"> </div>
          </div>
        </div>
      </div>
    </header>
    <!-- =====  HEADER END  ===== -->
    <!-- =====  CONTAINER START  ===== -->
    <div class="container">
      <div class="row ">
        <div id="column-left" class="col-sm-4 col-md-4 col-lg-3 ">
          <div id="category-menu" class="navbar collapse mb_40 hidden-sm-down in" aria-expanded="true" style="" role="button">
            <div class="nav-responsive">
            
             <ul class="nav  main-navigation collapse in ">
                <li><form action="./ListProductByType" method="post"><input type="submit" name="me_Prdclass" value="Life Support" style="background:#F2F2F2;border:none"></form></li>
                <li><form action="./ListProductByType" method="post"><input type="submit" name="me_Prdclass" value="Medical Treatment" style="background:#F2F2F2;border:none"></form></li>
                <li><form action="./ListProductByType" method="post"><input type="submit" name="me_Prdclass" value="Architecture" style="background:#F2F2F2;border:none"></form></li>
                <li><form action="./ListProductByType" method="post"><input type="submit" name="me_Prdclass" value="Indoor cleaning" style="background:#F2F2F2;border:none"></form></li>
                <li><form action="./ListProductByType" method="post"><input type="submit" name="me_Prdclass" value="Factory production" style="background:#F2F2F2;border:none"></form></li>

              </ul>
					
            </div>
          </div>
          <div class="left_banner left-sidebar-widget mt_30 mb_50"> </div>
          <div class="left-cms left-sidebar-widget mb_50">
            <ul>
              <li>
                <div class="feature-i-left ptb_40">
                  <div class="icon-right Shipping"></div>
                  <h6>Free Shipping</h6>
                  <p>Free delivery worldwide</p>
                </div>
              </li>
              <li>
                <div class="feature-i-left ptb_40">
                  <div class="icon-right Order"></div>
                  <h6>Order Online</h6>
                  <p>Hours : 8am - 11pm</p>
                </div>
              </li>
              <li>
                <div class="feature-i-left ptb_40">
                  <div class="icon-right Save"></div>
                  <h6>Pattern of payment</h6>
                  <p>For All bank cards & credit cards</p>
                </div>
              </li>
              <li>
                <div class="feature-i-left ptb_40">
                  <div class="icon-right Safe"></div>
                  <h6>Safe Shoping</h6>
                  <p>Ensure genuine 100%</p>
                </div>
              </li>
            </ul>
          </div>
          <div class="left-special left-sidebar-widget mb_50"> </div>
          <div class="left_banner left-sidebar-widget mb_50"> </div>
          <div class="Testimonial left-sidebar-widget mb_50"> </div>
          <div class="Tags left-sidebar-widget mb_50"> </div>
        </div>
        <div id="column-right" class="col-sm-8 col-md-8 col-lg-9 mtb_30">
        </div>
      </div>
      </div>
    </div>
		<!-- =====  BANNER STRAT  ===== --> 
			  <table>
				  <tr><td>
					            <div class="banner">
            <div class="main-banner owl-carousel">
              <div class="item"><img src="images/main_banner1.jpg" alt="Main Banner" class="img-responsive" /></div>
              <div class="item"><img src="images/main_banner1.jpg" alt="Main Banner" class="img-responsive" /></div>
            </div>
          </div>
					  </td></tr>
				  <tr><td>
			<div>
	<c:forEach items = "${sessionScope.merchandiselist}" var ="Product">
<div style="border:1px solid">
	  <div class="item">
                      <div class="col-md-5">
                        <div  class="caption product-detail text-left">
							<input type="image" src="${Product.prdimages}" class="img-responsive" alt="submit">
						  </div>
                        <div class="caption product-detail text-left">
                          <h6 data-name="product_name" class="product-name mt_20">${Product.prdname}</h6>
                          <span class="price"><span class="currencySymbol">$</span> ${Product.prdprice}</span>
                          <div><span class="prdclass">${Product.prdclass}</span></div>
                          <div class="button-group text-center">
                            <div><input type="image" name="addtocart" src="images/cart.jpg" value="add to cart" width="25"></div>
                          </div>
                        </div>
                      </div>
                    </div>

</div>
					<div>
					
<br>

    </c:forEach>
	</div>
				</td></tr>
			<!-- =====  BANNER END  ===== -->
			
    <!-- =====  FOOTER START  ===== -->
				  <tr><td>
    <div style="width: 615px;background: #F2F2F2">
<div class="container">  
	<table>
		<tr><td style="width: 300px">
              <div >
              <ul >
              <li>The intersection of Nanfeng Road and Nansan Street of Higher Education Park in Changping District, Beijing, is 400 meters north to east.</li>
				  <li></li>
                  <li>(telephone)</li>
				  <li></li>
                  <li>(email address)</li>
                </ul>
	  </td>
		<td style="width: 300px">
          <div >
            <p style="font-size: 18px"><b>suggestion box</b></p>
            <p >For the good suggestions we will give 20% off for next order </p>
            <div align="center">
              <input  type="text" placeholder="your suggestions">
				<p></p>
              <p align="center"><button style="border: none;background: #E74C3C;color: #FFFFFF;font-size: 18px">Submit</button></p>
            </div>
          </div>
	  </td></tr></table>
      </div>
					  </div></td></tr></table>
    <!-- =====  FOOTER END  ===== -->
  <a id="scrollup">Scroll</a>
  <script src="js/jQuery_v3.1.1.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.magnific-popup.js"></script>
  <script src="js/jquery.firstVisitPopup.js"></script>
  <script src="js/custom.js"></script>
</body>

</html>
