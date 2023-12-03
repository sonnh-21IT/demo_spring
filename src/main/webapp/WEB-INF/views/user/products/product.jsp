<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/10/2023
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<head>
    <title>Sản Phẩm</title>
    <meta charset="UTF-8">
    <style>
        .product-content{
            overflow-x: hidden;
        }
    </style>
</head>
<body>
<!--
Body Section
-->
<h1>${cart.size()}</h1>
<div class="row product-content">
    <div id="sidebar" class="span3">
        <div class="well well-small">
            <ul class="nav nav-list">
                <c:forEach var="i" begin="0" end="${categories.size() - 1}">
                    <li><a href='<c:url value="/san-pham/${categories.get(i).id}"/>'><span
                            class="icon-circle-blank"></span> ${categories.get(i).name}</a>
                    </li>
                </c:forEach>
                <li style="border:0"> &nbsp;</li>
                <li><a class="totalInCart" href="cart.html"><strong>Đã thêm <span
                        class="badge badge-warning pull-right" style="line-height:18px;"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                                                           value="${totalPrice}"/> ₫</span></strong></a>
                </li>
            </ul>
        </div>
        <div class="well well-small alert alert-warning cntr">
            <h2>50% Discount</h2>
            <p>
                only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
            </p>
        </div>
        <div class="well well-small"><a href="#"><img src="<c:url value="/assets/user/img/paypal.jpg"/>" alt="payment method paypal"></a>
        </div>
        <a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
        <br>
        <br>
    </div>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
            <li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
            <li class="active">Chi tiết sản phẩm</li>
        </ul>
        <div class="well well-small">
            <div class="row-fluid">
                <div class="span5">
                    <div id="myCarousel" class="carousel slide cntr">
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="#"> <img src="<c:url value="/assets/user/img/${product.img}"/>" alt="" style="width:100%"></a>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                    </div>
                </div>
                <div class="span7">
                    <h3>${product.name}</h3>
                    <hr class="soft"/>

                    <form class="form-horizontal qtyFrm" method="get" action="<c:url value="/add_cart/${product.id_product}"/>">
                        <div class="control-group">
                            <label class="control-label"><span><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                                 value="${product.price}"/> ₫</span></label>
                            <div class="controls">
                                <input type="number" min="1" value="1" class="span6">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label"><span>Color</span></label>
                            <div class="controls">
                                <select class="span11">
                                    <option>Red</option>
                                    <option>Purple</option>
                                    <option>Pink</option>
                                    <option>Red</option>
                                </select>
                            </div>
                        </div>
                        <h4></h4>
                        <p>${product.title}<p>
                            <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Thêm giỏ hàng
                            </button>
                    </form>
                </div>
            </div>
            <hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
                <li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan </a></li>
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
                <div class="tab-pane fade active in" id="home">
                    ${product.details}
                </div>
                <div class="tab-pane fade" id="profile">
                    <c:set var="countlist" value="${productByIdCategory.size()}"/>
                    <c:if test="${productByIdCategory.size()>10}">
                        <c:set var="countlist" value="10"/>
                    </c:if>
                    <c:forEach var="i" begin="0" end="${countlist-1}" varStatus="loop">
                        <div class="row-fluid">
                            <div class="span2">
                                <img src="<c:url value="/assets/user/img/${productByIdCategory.get(i).img}"/>" alt="">
                            </div>
                            <div class="span6">
                                <h5>${productByIdCategory.get(i).name}</h5>
                                <p>${productByIdCategory.get(i).title}</p>
                            </div>
                            <div class="span4 alignR">
                                <form class="form-horizontal qtyFrm">
                                    <h3><fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value="${productByIdCategory.get(i).price}"/> ₫</h3>
                                    <div class="btn-group">
                                        <a href="product_details.html" class="defaultBtn"><span
                                                class=" icon-shopping-cart"></span> Add to cart</a>
                                        <a href="product_details.html" class="shopBtn">VIEW</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr class="soft">
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div> <!-- Body wrapper -->
</body>
