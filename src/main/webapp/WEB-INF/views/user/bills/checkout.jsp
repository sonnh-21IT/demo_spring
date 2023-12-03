<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/20/2023
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<head>
    <title>Thanh toán</title>
</head>
<body>
<div class="row">
    <div id="sidebar" class="span3">
        <div class="well well-small">
            <ul class="nav nav-list">
                <c:forEach var="i" begin="0" end="${categories.size() - 1}">
                    <li><a href="<c:url value="/san-pham/${categories.get(i).id}"/>"><span
                            class="icon-circle-blank"></span> ${categories.get(i).name}</a>
                    </li>
                </c:forEach>
                <li style="border:0"> &nbsp;</li>
                <li><a class="totalInCart" href=""><strong>Đã thêm <span
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
        <ul class="breadcrumb">
            <li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Người dùng</li>
        </ul>
        <h3>Người dùng</h3>
        <hr class="soft"/>
        <div class="row">
            <div class="span9">
                <div class="well">
                    <br>
                    <form:form class="form-horizontal" action="checkout" method="post" modelAttribute="bills">
                        <h3>Thanh toán hóa đơn</h3>
                        <div class="control-group">
                            <label class="control-label">Fiels label <sup>*</sup></label>
                            <div class="controls">
                                <form:input type="text" path="display_name" placeholder="Mời nhập họ tên"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Email <sup>*</sup></label>
                            <div class="controls">
                                <form:input type="email" path="user" placeholder="Mời nhập Email"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Liên hệ <sup>*</sup></label>
                            <div class="controls">
                                <form:input type="text" path="phone" placeholder="Mời nhập số điện thoại"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Địa chỉ <sup>*</sup></label>
                            <div class="controls">
                                <form:textarea path="address" rows="5"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Ghi chú <sup>*</sup></label>
                            <div class="controls">
                                <form:textarea path="note" rows="5"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <input type="submit" name="submitAccount" value="Thanh toán" class="shopBtn exclusive">
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="span1"> &nbsp;</div>
        </div>
    </div>
</div>
</body>