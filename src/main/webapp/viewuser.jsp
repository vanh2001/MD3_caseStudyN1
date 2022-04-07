<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View User</title>

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
            </button>
            <a class="navbar-brand" href="account">Li-bra-ry</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/account">Home</a></li>
                <li><a href="account?action=addlibrarian">Add Librarian</a></li>
                <li><a href="account?action=showlib">View Librarian</a></li>
                <li><a href="account?action=showuser">View User</a></li>
                <li><a href="account?action=logout">Logout</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class='container'>
    <table class='table table-bordered table-striped'>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listUser}" var="x" varStatus="loop">
            <tr>
                <td>${x.idUser}</td>
                <td>${x.nameUser}</td>
                <td>${x.emailUser}</td>
                <td>${x.passwordUser}</td>
                <td>${x.phoneUser}</td>
                <td><a href='account?action=editlib&id=${x.idUser}'>Edit</a></td>
                <td><a href='account?action=deletelib&id=${x.idUser}'>Delete</a></td></tr>
        </c:forEach>
    </table>
</div>

</body>
</html>