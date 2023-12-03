<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: NHS24
  Date: 11/19/2023
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <li><a href="">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Giỏ hàng</li>
        </ul>
        <div class="well well-small">
            <h1>Check Out <small class="pull-right"> ${totalQuantity} sản phẩm trong giỏ hàng </small></h1>
            <hr class="soften"/>

            <table class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>Hình ảnh</th>
                    <th>Mô tả</th>
                    <th>Màu sắc</th>
                    <th>Giá bán</th>
                    <th>Số lượng</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                    <th>Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${cart}">
                <tr>
                    <td><img width="100" src="<c:url value="assets/user/img/${item.value.productDTO.img}"/>" alt=""></td>
                    <td>${item.value.productDTO.title}</td>
                    <td><span class="shopBtn" style="background-color: ${item.value.productDTO.code_color}"><span class="icon-ok"></span></span></td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3"
                                          value="${item.value.productDTO.price}"/> ₫</td>
                    <td>
                        <input class="span1" min="0" max="100" style="max-width:34px" placeholder="1"
                               id="quantity-cart-${item.key}" size="16"
                               type="number" value="${item.value.quantity}">
                    </td>
                    <td>
                        <button data-id="${item.key}" href="<c:url value="/edit_cart/${item.key}/5"/> " class="btn btn-mini btn-danger edit-cart" type="button"><span
                                class="icon-edit"></span>
                        </button>
                    </td>
                    <td>
                        <a href="<c:url value="/delete_cart/${item.key}"/>" class="btn btn-mini btn-danger" type="button"><span
                                class="icon-remove"></span>
                        </a>
                    </td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3"
                                          value="${item.value.total}"/> ₫</td>
                </tr>
                </c:forEach>
                <tr>
                    <td colspan="7" class="alignR">Sản phẩm:	</td>
                    <td class="label label-primary">${totalQuantity}</td>
                </tr>
                <tr>
                    <td colspan="7" class="alignR">Tổng:	</td>
                    <td class="label label-primary"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                      value="${totalPrice}"/> ₫</td>
                </tr>
            </table>
            <br/>

            <a href="products.html" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp tục mua sắm
            </a>
            <a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right"> Thanh toán <span class="icon-arrow-right"></span></a>

        </div>
    </div>
</div>
<content tag="script">
    <script>
        $(".edit-cart").on("click",function(){
            var id = $(this).data("id");
            var quantity = $("#quantity-cart-"+id).val();
            // alert(quantity);

            <%--window.location = "<c:url value="/"/>";--%>
            window.location = "edit_cart/"+id+"/"+quantity;
        });
    </script>
</content>
</body>
