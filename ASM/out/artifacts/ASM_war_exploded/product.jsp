<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/15/2021
  Time: 4:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="lsproduct" value="${requestScope.products}" />
<c:set var="lscate" value="${requestScope.categorys}" />

<html>
<head>
    <title>Product</title>
</head>
<body>
<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="home">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Products</h1>
            </div>
        </div>
    </div>
</div>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul class="product-category">
                    <li><a href="product" class="active">All</a></li>
                    <c:forEach var="cate" items="${lscate}">
                        <li><a href="product?cateid=${cate.id}">${cate.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="row">
            <c:forEach var="product" items="${lsproduct}">
                <div class="col-md-6 col-lg-3 ftco-animate">
                    <div class="product">
                        <a href="product_detail?id=${product.id}" class="img-prod"><img class="img-fluid" src="${product.url_image}" alt="Colorlib Template">
                            <c:if test="${product.discount > 0}">
                                <span class="status">${product.discount}%</span>
                                <div class="overlay"></div>
                            </c:if>
                        </a>
                        <div class="text py-3 pb-4 px-3 text-center">
                            <h3><a href="product_detail?id=${product.id}">${product.name}</a></h3>
                            <div class="d-flex">
                                <c:if test="${product.discount > 0}">
                                    <span class="mr-2 price-dc">$${product.price}</span>
                                    <span class="price-sale">$${product.price*(1-product.discount/100)}</span>
                                </c:if>
                                <c:if test="${product.discount == 0}">
                                    <span >$${product.price}</span>
                                </c:if>

                            </div>
                            <div class="bottom-area d-flex px-3">
                                <div class="m-auto d-flex">
                                    <a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                        <span><i class="ion-ios-menu"></i></span>
                                    </a>
                                    <a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                        <span><i class="ion-ios-cart"></i></span>
                                    </a>
                                    <a href="#" class="heart d-flex justify-content-center align-items-center ">
                                        <span><i class="ion-ios-heart"></i></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
          </div>
        <div class="row mt-5">
            <div class="col text-center">
                <div class="block-27">
                    <ul>
                        <li><a href="#">&lt;</a></li>
                        <li class="active"><span>1</span></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&gt;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
