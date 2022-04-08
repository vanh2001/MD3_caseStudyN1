<%--
  Created by IntelliJ IDEA.
  User: anhtv
  Date: 08/04/2022
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Loan Slip</title>
    <style>
        body {
            background-color: springgreen;
        }

        h1 {
            color: chocolate;
            text-align: center;
        }

        p {
            font-family: verdana;
            font-size: 20px;
        }
    </style>
</head>
<body>
<center>
    <h1>Loan Slip</h1>
    <h2>
        <a href="/CustomerServlet?action=create">Add New Loan Slip</a>
    </h2>
</center>
</body>
</html>
