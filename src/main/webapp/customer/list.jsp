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
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/CustomerServlet?action=create">Add New Customer</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customer</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Birth</th>
            <th>PhoneNumber</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id_customer}"/></td>
                <td><c:out value="${customer.name_customer}"/></td>
                <td><c:out value="${customer.email_customer}"/></td>
                <td><c:out value="${customer.address_customer}"/></td>
                <td><c:out value="${customer.birth_customer}"/></td>
                <td><c:out value="${customer.phoneNumber_customer}"/></td>
                <td>
                    <a href="/CustomerServlet?action=edit&id=${customer.id_customer}">Edit</a>
                    <a href="/CustomerServlet?action=delete&id=${customer.id_customer}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
