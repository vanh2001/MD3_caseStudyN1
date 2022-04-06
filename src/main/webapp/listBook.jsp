<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thư viện sách</title>
</head>
<body>
<center>
    <h1>Thư viện sách</h1>
    <h2 >
    <a href="/book?action=create">Add new book</a>
</h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>List of book</h2>
        </caption>
        <tr>
        <th>ID</th>
        <th>IdTitle</th>
        <th>name</th>
        <th>Description</th>
        <th>Amount</th>
        <th>Kind</th>
        <th>Publishing</th>
        <th>Action</th>
    </tr>
        <c:forEach var="books" items="${listBook}">
        <tr>
            <td><c:out value="${books.id}"/></td>
            <td><c:out value="${books.idTitle}"/></td>
            <td><c:out value="${books.name}"/></td>
            <td><c:out value="${books.description}"/></td>
            <td><c:out value="${books.amount}"/></td>
            <td><c:out value="${books.kind}"/></td>
            <td><c:out value="${books.publishing}"/></td>
        </tr>

        </c:forEach>

</body>
</html>
