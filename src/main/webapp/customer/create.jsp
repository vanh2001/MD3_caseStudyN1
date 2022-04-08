<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06/04/2022
  Time: 9:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Manager</title>
    <style>
        body {
            background-color: greenyellow;
        }

        h1 {
            color: gold;
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
    <h1>User Management</h1>
    <h2>
        <a href="/CustomerServlet?action=customer">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name_customer" id="name_customer" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email_customer" id="email_customer" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address_customer" id="address_customer" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Birth:</th>
                <td>
                    <input type="text" name="birth_customer" id="birth_customer" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer phoneNumber:</th>
                <td>
                    <input type="text" name="phoneNumber_customer" id="phoneNumber_customer" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
