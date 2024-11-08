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
                    <h1>Checkout</h1>
                    <nav class="d-flex align-items-center">
                        <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="single-product.html">Checkout</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Checkout Area =================-->
    <section class="checkout_area section_gap">
        <div class="container">

            <div class="billing_details">
                <div class="row">
                    <div class="col-lg-8">
                        <h3>Billing Details</h3>
                        <form class="row contact_form" action="SuccesServlet" method="post" novalidate="novalidate">
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="first" name="firstName" placeholder="First name" required>
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="last" name="lastName" placeholder="Last name" required>
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="number" name="phone" placeholder="Phone number" required>
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email Address" required>
                            </div>
                            <div class="col-md-12 form-group p_star">
                                <input type="text" class="form-control" id="add1" name="address" placeholder="Address" required>
                            </div>
                            <div class="col-md-12 form-group">
                                <button type="submit" class="primary-btn">Submit Order</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Your Order</h2>
                            <ul class="list">
                                <li><a href="#">Product <span>Total</span></a></li>
                                <c:forEach items="${cart}" var="item">
                                    <li><a href="#">${item.product.name} <span class="middle">x${item.quantity}</span> <span class="last">$${item.price * item.quantity}</span></a></li>
                                </c:forEach>
                            </ul>
                            <ul class="list list_2">
                                <li><a href="#">Subtotal <span>$${total}</span></a></li>
                                <li><a href="#">Shipping <span>Free</span></a></li>
                                <li><a href="#">Total <span>$${total}</span></a></li>
                            </ul>
                            <div class="creat_account">
                                <input type="checkbox" id="f-option4" name="acceptTerms" required>
                                <label for="f-option4">I?ve read and accept the </label>
                                <a href="#">terms & conditions*</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Checkout Area =================-->

    <!-- Start Footer Area -->
    <%@include file="./inc/footer.jsp"%>
    <!-- End Footer Area -->
</body>

</html>
