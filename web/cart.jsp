<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">



    <body>

        <!-- Start Header Area -->
        <%@include file="./inc/header.jsp"%>
        <!-- End Header Area -->

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Shopping Cart</h1>
                        <nav class="d-flex align-items-center">
                            <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Cart</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Cart Area =================-->
        <section class="cart_area">
            <div class="container">
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Product</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${cart}" var="orderItem">
                                    <tr>

                                        <td>
                                            <div class="media">
                                                <div class="d-flex">
                                                    <img src="${orderItem.product.thumbnail}" alt="" height="100px">
                                                </div>
                                                <div class="media-body">
                                                    <p>${orderItem.product.name}</p>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <h5>$${orderItem.price}</h5>
                                        </td>
                                        <td>
                                            <form action="CartServlet" method="post">
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="productId" value="${orderItem.productId}"/>
                                                <input onchange="this.form.submit()" name="quantity" type="number" value="${orderItem.quantity}" min="1">
                                            </form>
                                        </td>
                                        <td>
                                            <h5>$${orderItem.price * orderItem.quantity}</h5>
                                        </td>
                                        <td>
                                            <form action="CartServlet" method="post">
                                                <input type="hidden" name="action" value="delete"/>
                                                <input type="hidden" name="productId" value="${orderItem.productId}"/>
                                                <button type="submit" class="fa-regular fa-circle-xmark"></button>
                                            </form>

                                        </td>

                                    </tr>
                                </c:forEach>


                                <tr>

                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <h5>Subtotal</h5>
                                    </td>
                                    <td>
                                        <h5>$${total}</h5>
                                    </td>

                                </tr>
                                <tr class="shipping_area">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <h5>Shipping</h5>
                                    </td>
                                    <td>
                                        <div class="shipping_box">
                                            <ul class="list">
                                                <li><a href="#">Free Shipping</a></li>
                                            </ul>

                                        </div>
                                    </td>
                                </tr>
                                <tr class="out_button_area">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <div class="checkout_btn_inner d-flex align-items-center">
                                            <a class="gray_btn" href="ShopServlet">Continue Shopping</a>
                                            <a class="primary-btn" href="CheckoutServlet">Proceed to checkout</a>

                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Cart Area =================-->

        <!-- start footer Area -->
        <%@include file="./inc/footer.jsp"%>
    </body 