
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Orr</title>
</head>
<body>
    <%@include file="./inc/header.jsp"%>
    <!-- End Header Area -->

    <!-- Start Error Area -->
    <section class="error_area section_gap">
        <div class="container">
            <h2>Oops! Something went wrong.</h2>
            <p>We encountered an error while processing your order. Please try again later.</p>
            <a href="CheckoutServlet" class="primary-btn">Go Back to Checkout</a>
        </div>
    </section>
    <!-- End Error Area -->

    <!-- Start Footer Area -->
    <%@include file="./inc/footer.jsp"%>
    <!-- End Footer Area -->
</body>
</html>
