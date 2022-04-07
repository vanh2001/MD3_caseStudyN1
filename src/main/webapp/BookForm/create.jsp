<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2022
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thư viện sách</title>
</head>
<body>
<center>
    <h1><a href="book?action=book">List All Class</a></h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Book</h2>
            </caption>
            <tr>
                <th>Id_title_book</th>
                <td>
                    <input type="text" name="id" id="id" size="45">
                </td>
            </tr>
            <tr>
                <th>Book name</th>
                <td>
                    <input type="text" name="name" id="name" size="45">
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <input type="text" name="description" id="description" size="45">
                </td>
            </tr>
            <tr>
                <th>Amount</th>
                <td>
                    <input type="text" name="amount" id="amount" size="45">
                </td>
            </tr>
            <tr>
                <th>Kind</th>
                <td>
                    <input type="text" name="kind" id="kind" size="45">
                </td>
            </tr>
            <tr>
                <th>Publishing</th>
                <td>
                    <input type="text" name="publishing" id="publishing" size="45">
                </td>
            </tr>
            <tr>
                <th>Status</th>
                <td>
                    <input type="text" name="status" id="status" size="45">
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
