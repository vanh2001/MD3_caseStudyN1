<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title></title>
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
      <a class="navbar-brand" href="/account">eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/account">Home</a></li>
        <li><a href="account?action=addlibrarian">Add Librarian</a></li>
        <li><a href="account?action=showlib">View Librarian</a></li>
        <li><a href="account?action=logout">Logout</a></li>
      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class='container'>
  <form action='account?action=editlib' method='post' style='width:300px'>
    <div class='form-group'>
      <input type='hidden' name='id' value='${lib.idLibrarian}'/>
      <label for='name1'>Name</label>
      <input type='text' class='form-control' value='${lib.nameLibrarian}' name='name' id='name1' placeholder='Name'/>
    </div>
    <div class='form-group'>
      <label for='email1'>Email address</label>
      <input type='email' class='form-control' value='${lib.emailLibrarian}'  name='email' id='email1' placeholder='Email'/>
    </div>
    <div class='form-group'>
      <label for='password1'>Password</label>
      <input type='password' class='form-control' value='${lib.passwordLibrarian}'  name='password' id='password1' placeholder='Password'/>
    </div>
    <div class='form-group'>
      <label for='mobile1'>Mobile Number</label>
      <input type='number' class='form-control' value='${lib.phoneLibrarian}'  name='mobile' id='mobile1' placeholder='Mobile'/>
    </div>
    <button type='submit' class='btn btn-primary'>Update</button>
  </form>

</div>
</body>
</html>