<%--
  Created by IntelliJ IDEA.
  User: haich
  Date: 6/14/2019
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Phone</title>
</head>
<body>
    <table>
        <c:forEach items="${list}" var = "item">
            <tr>
                <td><c:out value="$item}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
