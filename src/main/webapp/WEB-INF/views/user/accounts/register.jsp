<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/19/2023
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<head>
    <title>Đăng ký</title>
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
        <div class="well well-small"><a href="#"><img src="<c:url value="/assets/user/img/paypal.jpg"/>" alt="payment method paypal"></a>
        </div>

        <a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
        <br>
        <br>
    </div>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Người dùng</li>
        </ul>
        <h3>Người dùng</h3>
        <hr class="soft"/>
        <div class="row">
            <div class="span4">
                <div class="well">
                    <h5>Đăng ký tài khoản</h5>
                    <br/>
                    <form:form action="dang_ky" method="post" modelAttribute="user">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <form:input type="email" path="user" class="span3" id="inputEmail" placeholder="Mời nhập email"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Mật khẩu</label>
                            <div class="controls">
                                <form:input type="password" path="password" class="span3" id="inputPassword" placeholder="Mời nhập mật khẩu"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputFullName">Họ và tên</label>
                            <div class="controls">
                                <form:input type="text" path="display_name" class="span3" id="inputFullName" placeholder="Mời nập họ và tên"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputAddress">Địa chỉ</label>
                            <div class="controls">
                                <form:input type="text" path="address" class="span3" id="inputAddress" placeholder="Mời nhập địa chỉ"/>
                            </div>
                        </div>
                        <div class="controls">
                            <button type="submit" class="btn block">Đăng ký thành viên</button>
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="span1"> &nbsp;</div>
            <div class="span4">
                <div class="well">
                    <h5>Đăng nhập hệ thống</h5>
                    <h1>${statusLogin}</h1>
                    <form:form action="dang_nhap" method="post" modelAttribute="user">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <form:input path="user" class="span3" id="inputAddress" type="email" placeholder="Mời nhập email"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Mật khẩu</label>
                            <div class="controls">
                                <form:input path="password" class="span3" id="inputAddress" type="password" placeholder="Mời nhập mật khẩu"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="defaultBtn">Đăng nhập</button>
                                <a href="#">Quên mật kẩu?</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>