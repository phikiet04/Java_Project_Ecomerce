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
                        <h1>Login/Register</h1>
                        <nav class="d-flex align-items-center">
                            <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Login/Register</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Login Box Area =================-->
        <section class="login_box_area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="login_box_img">
                            <img class="img-fluid" src="./assets/img/login.jpg" alt="">
                            <div class="hover">
                                <h4>New to our website?</h4>
                                <p>There are advances being made in science and technology everyday, and a good example of this is the</p>
                                <a class="primary-btn" href="RegisterServlet">Create an Account</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="login_form_inner">
                            <h3>Login to enter</h3>
                            <span class="error">${error}</span>
                            <c:remove var="error" scope="session"/>
                            <form class="row login_form" action="LoginServlet" method="post" id="contactForm" novalidate="novalidate">
                                <div class="col-md-12 form-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'email'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="password" class="form-control"  name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="creat_account">
                                        <input type="checkbox" id="f-option2" name="selector">
                                        <label for="f-option2">Keep me Register</label>
                                    </div>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit" class="primary-btn">Login</button>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="button" class="primary-btn" onclick="window.location.href = 'GoogleLoginServlet'">
                                        <i class="bi bi-google"></i> Login with Google
                                    </button>
                                </div>
                                <div class="col-md-12 form-group">
                                    <button type="button" class="primary-btn" onclick="window.location.href = 'FacebookLoginServlet'">
                                        <i class="fa fa-facebook"></i> Login with Facebook
                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Login Box Area =================-->
        <!-- start footer Area -->
        <%@include file="./inc/footer.jsp"%>
        <!-- End footer Area -->



    </body>

</html>