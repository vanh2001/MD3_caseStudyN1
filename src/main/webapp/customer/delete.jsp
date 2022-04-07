<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06/04/2022
  Time: 9:55 CH
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
    <h1>User Management</h1>
    <h2>
        <a href="/CustomerServlet?action=customer">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Are you sure?
                </h2>
            </caption>
            <c:if test="${customer!= null}">
                <input type="hidden" name="id_customer" value="<c:out value='${customer.id_customer}' />"/>
            </c:if>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name_customer" size="45"
                           value="<c:out value='${customer.name_customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email_customer" size="45"
                           value="<c:out value='${customer.email_customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address_customer" size="15"
                           value="<c:out value='${customer.address_customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birth:</th>
                <td>
                    <input type="text" name="birth_customer" size="15"
                           value="<c:out value='${customer.birth_customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>phoneNumber:</th>
                <td>
                    <input type="text" name="phoneNumber_customer" size="15"
                           value="<c:out value='${customer.phoneNumber_customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Delete"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
