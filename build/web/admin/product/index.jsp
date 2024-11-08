<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="./assets/admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="./assets/admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="./assets/admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="./assets/admin/css/style.css" rel="stylesheet">
</head>
<body>
     <%@include file="../inc/sidebar.jsp"%>
    <div class="container">
          <%@include file="../inc/navbar.jsp"%>
        <h2>Product Table</h2>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Thumbnail</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">View</th>
                        <th scope="col">Category</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="index" value="1" />
                    <c:forEach items="${productList}" var="product">
                        <tr>
                            <th scope="row">${index}</th>
                            <td><img style="width: 75px; height: 75px; object-fit: cover;" src="${product.thumbnail}" alt=""/></td>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.quantity}</td>
                            <td>${product.view}</td>
                            <td>${product.category.name}</td>
                            <td><a href="EditProductServlet?productId=${product.id}" style="color: orange;"><i class="fa fa-edit me-2"></i></a></td>
                            <td>
                                <form action="DeleteProductServlet" method="POST">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <button style="border: none; background: none; cursor: pointer;">
                                        <i class="fa fa-trash me-2" style="color: red;"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <c:set var="index" value="${index + 1}" />
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="./assets/admin/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/admin/lib/chart/chart.min.js"></script>
        <script src="./assets/admin/lib/easing/easing.min.js"></script>
        <script src="./assets/admin/lib/waypoints/waypoints.min.js"></script>
        <script src="./assets/admin/lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="./assets/admin/lib/tempusdominus/js/moment.min.js"></script>
        <script src="./assets/admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="./assets/admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
     <script src="./assets/admin/js/main.js"></script>
</body>
</html>
