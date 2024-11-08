<%-- 
    Document   : sidebar
    Created on : Sep 21, 2024, 3:48:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-light navbar-light">
        <a href="index.html" class="navbar-brand mx-4 mb-3">
            <h3 class="text-primary"><i class="">ADM</i></h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
            <div class="position-relative">
                <img class="rounded-circle" src="https://avatars.githubusercontent.com/u/135443787?v=4" alt="" style="width: 40px; height: 40px;">
                <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
            </div>
            <div class="ms-3">
                <h6 class="mb-0">Phi Kiet</h6>
                <span>Admin</span>
            </div>
        </div>
        <div class="navbar-nav w-100">
            <a href="DashboardServlet" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-user-circle me-2"></i>Users</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="IndexUserServlet" class="dropdown-item">All</a>
                    <a href="CreateUserServlet" class="dropdown-item">Add</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-th-large me-2"></i>Categories</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="IndexCategoryServlet" class="dropdown-item">All</a>
                    <a href="CreateCategoryServlet" class="dropdown-item">Add</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-box me-2"></i>Products</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="IndexProductServlet" class="dropdown-item">All</a>
                    <a href="CreateProductServlet" class="dropdown-item">Add</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-receipt me-2"></i>Orders</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="IndexOrderServlet" class="dropdown-item">All</a>
                </div>
            </div>
        </div>
    </nav>
</div>