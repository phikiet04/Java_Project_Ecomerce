<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<body>
    <%@include file="./inc/header.jsp"%>
    <div class="container mt-5">
        <h1 class="text-success">Payment Successful!</h1>
        <p>Thank you for your purchase. Below are your order details:</p>

        <!-- Thông tin khách hàng -->
     

        <!-- Thông tin ??n hàng -->
        <h2>Your Order:</h2>
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Product Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart}">
                    <tr>
                        <td>${item.product.name}</td>
                        <td>${item.quantity}</td>
                        <td>$${item.price}</td>
                        <td>$${item.price * item.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3" class="text-right"><strong>Grand Total:</strong></td>
                    <td><strong>$${total}</strong></td>
                </tr>
            </tfoot>
        </table>

        <a href="index.jsp" class="btn btn-primary">Back to Home</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
     <%@include file="./inc/footer.jsp"%>
</body>
</html>
