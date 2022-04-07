<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Section</title>
    <link rel='stylesheet' href='bootstrap.min.css'/>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="account">eLibrary</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="account">Home</a></li>
                <li><a href="account?action=addlibrarian">Add Librarian</a></li>
                <li><a href="account?action=showlib">View Librarian</a></li>
                <li><a href="account?action=showuser">View User</a></li>
                <li><a href="account?action=logout">Logout</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/admin1.jpg" alt="baby 1" >
        </div>

        <div class="item">
            <img src="images/admin2.jpg" alt="baby 2" >
        </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- corousel end -->

</div>

<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</body>
</html>