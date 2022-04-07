<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/7/2022
  Time: 3:01 PM
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
    <h2>
        <a href="book?action=book">List of book</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Book
                </h2>
            </caption>
            <c:if test="${book != null}">
                <input type="hidden" name="id" value="<c:out value='${books.id_book}' />"/>
            </c:if>
            <tr>
                <th>Title ID:</th>
                <td>
                    <input type="text" name="id_title" size="45"
                           value="<c:out value='${books.id_title_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${books.name_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${books.description_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Amount:</th>
                <td>
                    <input type="text" name="amount" size="45"
                           value="<c:out value='${books.amount_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Kind:</th>
                <td>
                    <input type="text" name="kind" size="45"
                           value="<c:out value='${books.kind_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Publishing:</th>
                <td>
                    <input type="text" name="publishing" size="45"
                           value="<c:out value='${books.publishing_book}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <input type="text" name="status" size="45"
                           value="<c:out value='${books.status_book}' />"
                    />
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
