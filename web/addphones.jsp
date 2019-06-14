<%--
  Created by IntelliJ IDEA.
  User: haich
  Date: 6/14/2019
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Phone</title>
</head>
<body>
    <form name="phone" action="/addPhone" method="post">
        Name:<input name="name"><br>
        Brand:<select name="brand">
        <option value="Apple">Apple</option>
        <option value="SamSung">Samsung</option>
        <option value="Nokia">Nokia</option>
        <option value="Others">Others</option>
    </select><br>
        Price:<input name="price"><br>
        Description:<input name="des"><br>
        <input type="submit" value="submit">
        <br>
        <input type="reset" value="reset">
    </form>
</body>
</html>
