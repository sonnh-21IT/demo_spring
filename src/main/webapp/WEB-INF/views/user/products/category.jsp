<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/15/2023
  Time: 5:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<head>
    <title>Sản - Phẩm</title>
    <style>
        .pagination {
            display: flex;
            justify-content: center;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .pagination a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        .pagination a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="well well-small">
    <div class="row">
        <span style="margin-left: 25px;">Danh sách sản phẩm</span>
        <select class="pull-right">
            <option>A - Z</option>
            <option>Cao - Thấp</option>
        </select>
    </div>
    <c:if test="${productsPaginate.size()>0}">
    <div class="row-fluid">
        <ul class="thumbnails">
            <c:forEach var="i" begin="0" end="${productsPaginate.size()-1}" varStatus="loop">
                <li class="span4">
                    <div class="thumbnail">
                        <a href="product_details.html" class="overlay"></a>
                        <a class="zoomTool" href="product_details.html" title="add to cart"><span
                                class="icon-search"></span> QUICK VIEW</a>
                        <a href="<c:url value="/chi-tiet-san-pham/${productsPaginate.get(i).id_product}"/> "><img src="<c:url value="/assets/user/img/${productsPaginate.get(i).img}"/> " alt=""></a>
                        <div class="caption cntr">
                            <p>${productsPaginate.get(i).name}</p>
                            <p><strong>
                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value="${productsPaginate.get(i).price}"/> ₫
                            </strong></p>
                            <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
                            <div class="actionList">
                                <a class="pull-left" href="#">Add to Wish List </a>
                                <a class="pull-left" href="#"> Add to Compare </a>
                            </div>
                            <br class="clr">
                        </div>
                    </div>
                </li>
                <c:if test="${(loop.index+1) % 3 == 0 || (loop.index+1) == productsPaginate.size()}">
                        </ul>
                    </div>
                    <c:if test="${(loop.index+1)<productsPaginate.size()}">
                        <div class="row-fluid">
                            <ul class="thumbnails">
                    </c:if>
                </c:if>
            </c:forEach>
        </c:if>

    </div>
    <div class="pagination">
        <c:forEach var="i" begin="1" end="${paginateDTO.totalPage}">
            <a href="<c:url value="/san-pham/${idCategory}/${i}"/>" class="<c:if test="${i == paginateDTO.currentPage}">active</c:if>">${i}</a>
        </c:forEach>
<%--        <a href="#">&laquo;</a>--%>
<%--        <a href="#">1</a>--%>

<%--        <a href="#">3</a>--%>
<%--        <a href="#">4</a>--%>
<%--        <a href="#">5</a>--%>
<%--        <a href="#">6</a>--%>
<%--        <a href="#">&raquo;</a>--%>
    </div>
</body>