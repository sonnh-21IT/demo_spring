<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/6/2023
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>--%>
<title>Trang chủ</title>
<body>
<!--
Body Section
-->
<div class="row">
    <div id="sidebar" class="span3">
        <div class="well well-small">
            <ul class="nav nav-list">
                <c:forEach var="i" begin="0" end="${categories.size() - 1}">
                    <li><a href='<c:url value="/san-pham/${categories.get(i).id}"/>'><span
                            class="icon-circle-blank"></span> ${categories.get(i).name}</a>
                    </li>
                </c:forEach>
                <li style="border:0"> &nbsp;</li>
                <li><a class="totalInCart" href="cart.html"><strong>Total Amount <span
                        class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a>
                </li>
            </ul>
        </div>

        <div class="well well-small alert alert-warning cntr">
            <h2>50% Discount</h2>
            <p>
                only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
            </p>
        </div>
        <div class="well well-small"><a href="#"><img src="assets/img/paypal.jpg" alt="payment method paypal"></a>
        </div>

        <a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
        <br>
        <br>
        <ul class="nav nav-list promowrapper">
            <li>
                <div class="thumbnail">
                    <a class="zoomTool" href="product_details.html" title="add to cart"><span
                            class="icon-search"></span> QUICK VIEW</a>
                    <img src="assets/img/bootstrap-ecommerce-templates.png" alt="bootstrap ecommerce templates">
                    <div class="caption">
                        <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                                class="pull-right">$22.00</span>
                        </h4>
                    </div>
                </div>
            </li>
            <li style="border:0"> &nbsp;</li>
            <li>
                <div class="thumbnail">
                    <a class="zoomTool" href="product_details.html" title="add to cart"><span
                            class="icon-search"></span> QUICK VIEW</a>
                    <img src="assets/img/shopping-cart-template.png" alt="shopping cart template">
                    <div class="caption">
                        <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                                class="pull-right">$22.00</span>
                        </h4>
                    </div>
                </div>
            </li>
            <li style="border:0"> &nbsp;</li>
            <li>
                <div class="thumbnail">
                    <a class="zoomTool" href="product_details.html" title="add to cart"><span
                            class="icon-search"></span> QUICK VIEW</a>
                    <img src="assets/img/bootstrap-template.png" alt="bootstrap template">
                    <div class="caption">
                        <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                                class="pull-right">$22.00</span>
                        </h4>
                    </div>
                </div>
            </li>
        </ul>

    </div>
    <div class="span9">
        <div class="well np">
            <div id="myCarousel" class="carousel slide homCar">
                <div class="carousel-inner">
                    <%--                    <h1>${categories.size()}</h1>--%>
                    <c:forEach var="i" begin="0" end="${slides.size() - 1}" varStatus="index">
                        <div class="item <c:if test="${index.first}"> active </c:if>">
                            <img style="width:100%"
                                 src="<c:url value="/assets/user/img/slides/${ slides.get(i).img }"/>"
                                 alt="bootstrap ecommerce templates">
                            <div class="carousel-caption">
                                <h4>${slides.get(i).caption}</h4>
                                <p><span>${slides.get(i).content}</span></p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
            </div>
        </div>
        <!--
        New Products
        -->
        <div class="well well-small">
            <h3>Sản phẩm mới </h3>
            <hr class="soften"/>
            <div class="row-fluid">
                <div id="newProductCar" class="carousel slide">
                    <div class="carousel-inner">
                        <div class="item <c:if test="${products_new.size() > 0}">active</c:if>">
                            <ul class="thumbnail">
                                <c:forEach var="i" begin="0" end="${products_new.size()-1}" varStatus="loop">
                                <li class="span3">
                                    <div class="thumbnail">
                                        <a class="zoomTool" href="product_details.html" title="add to cart"><span
                                                class="icon-search"></span> QUICK VIEW</a>
                                        <a href="#" class="tag"></a>
                                        <a href="product_details.html"><img
                                                src="<c:url value="/assets/user/img/${products_new.get(i).img}"/>"
                                                alt="bootstrap-ring"></a>
                                    </div>
                                </li>
                                <c:if test="${(loop.index + 1) % 4 == 0 || (loop.index + 1) == products_new.size()}">
                            </ul>
                        </div>
                        <c:if test="${(loop.index+1)<products_new.size()}">
                        <div class="item">
                            <ul class="thumbnails">
                                </c:if>
                                </c:if>
                                </c:forEach>
                        </div>
                        <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                        <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                    </div>
                </div>
            </div>
            <!--
            Featured Products
            -->
            <div class="well well-small">
                <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span
                        class="icon-plus"></span></a> Sản phẩm nổi bật </h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <c:if test="${products_highlight.size()>0}">
                        <ul class="thumbnails">
                        <c:forEach var="i" begin="0" end="${products_highlight.size()-1}" varStatus="loop">
                            <li class="span4">
                                <div class="thumbnail">
                                    <a class="zoomTool" href="product_details.html" title="add to cart"><span
                                            class="icon-search"></span> QUICK VIEW</a>
                                    <a href="chi-tiet-san-pham/${products_highlight.get(i).id_product}">
                                        <img src="<c:url value="/assets/user/img/${products_highlight.get(i).img}"/>"
                                             alt="">
                                    </a>
                                    <div class="caption">
                                        <h5>${products_highlight.get(i).name}</h5>
                                        <h4>
                                            <a class="defaultBtn" href="" title="Click to view"><span
                                                    class="icon-zoom-in"></span></a>
                                            <a class="shopBtn" href="#" title="add to cart"><span
                                                    class="icon-plus"></span></a>
                                            <span class="pull-right">
                                            <fmt:formatNumber type="number" maxFractionDigits="3"
                                                              value="${products_highlight.get(i).price}"/> ₫
                                        </span>
                                        </h4>
                                    </div>
                                </div>
                            </li>
                            <c:if test="${(loop.index+1) % 3 == 0 || (loop.index+1) == products_highlight.size()}">
                                </ul>
                                <c:if test="${(loop.index+1)<products_highlight.size()}">
                                    <ul class="thumbnails">
                                </c:if>
                            </c:if>
                        </c:forEach>
                        </ul>
                    </c:if>
                </div>
            </div>
            <hr>
            <div class="well well-small">
                <a class="btn btn-mini pull-right" href="#">Xen thêm <span class="icon-plus"></span></a>
                Tất cả sản phẩm
            </div>
        </div>
    </div>
</body>
