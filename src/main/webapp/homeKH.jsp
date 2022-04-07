<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Theme Made By www.w3schools.com - No Copyright -->
    <title>Bootstrap Theme Simply Me</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./CSS/editHomeView.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="account">Li-bra-ry</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="search-container">
            <form action="/book?action=find" method="post">
                <input type="text" placeholder="Search.." name="findName"/>
            </form>
        </div>
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid bg-2 text-center">
    <h3 class="margin">Welcome to Codegym library!!!</h3>
    <p>Chúc bạn có trải nghiệm tốt tại đây</p>
    <p>Tìm kiếm sách</p>
    <a href="#" class="btn btn-default btn-lg">
        <span class="glyphicon glyphicon-search"></span> Search
    </a>
</div>
<!-- Third Container (Grid) -->
<div class="container-fluid bg-3 text-center">
    <h3 class="margin">Where To Find Me?</h3><br>
    <div class="row">
        <c:forEach items="${listBookKH}" var="listbookkh" varStatus="loop">
            <div class="col-sm-4">
                <img src="images/${listbookkh.image}" class="img-responsive margin" style="width:100%; height: 300px"
                     alt="Image">
                <h5>${listbookkh.callno}</h5>
                <h5>${listbookkh.name}</h5>
                <h5>${listbookkh.author}</h5>
                <h5>${listbookkh.quantity}</h5>
                <a href="/issuebook?action=IssueBookForm" class="btn btn-warning">Borrow</a>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
    <footer class="footer-distributed">
        <div class="footer-left">
            <h3>Code<span>gym</span></h3>
            <p class="footer-links">
                <a href="/khachhang?action=quit" class="link-1">Home</a>
                <a href="#">Blog</a>
                <a href="#">Pricing</a>
                <a href="#">About</a>
                <a href="#">Faq</a>
                <a href="#">Contact</a>
            </p>
            <p class="footer-company-name">CodeGym © 2021</p>
        </div>
        <div class="footer-center">
            <div>
                <i class="fa fa-map-marker"></i>
                <p><span>Nam Từ Liêm</span> Tòa nhà TT04, CodeGym</p>
            </div>
            <div>
                <i class="fa fa-phone"></i>
                <p>+9.999.999</p>
            </div>
            <div>
                <i class="fa fa-envelope"></i>
                <p><a href="mailto:support@company.com">codegym@company.com</a></p>
            </div>
        </div>
        <div class="footer-right">
            <p class="footer-company-about">
                <span>About the Dev</span>
                Thư viện codegym là nơi cung cấp cái tài liệu, sách báo giúp cho lập trình viên giải tỏa căng thẳng!
            </p>
            <div class="footer-icons">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-github"></i></a>
            </div>
        </div>
    </footer>
</footer>

</body>
</html>