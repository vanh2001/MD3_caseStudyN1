<%--
  Created by IntelliJ IDEA.
  User: lequan
  Date: 4/7/22
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Librarian Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="account">Li-bra-ry</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="account" class="active">Home</a></li>
                <li><a href="account?action=admin" class="active">Admin</a></li>
                <li><a href="account?action=librarian">Librarian</a></li>
                <li><a href="account?action=user" class="active">User</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class='container'>
    <h3>Librarian Login</h3>
    ${messageloginlib}
    <form action="account?action=librarian" method="post" style="width:300px">
        <div class="form-group">
            <label for="email1">Email address</label>
            <input type="email" class="form-control" id="email1" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <label for="password1">Password</label>
            <input type="password" class="form-control" id="password1" name="password" placeholder="Password"/>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>

</body>
</html>
