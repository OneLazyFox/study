<%--
  Created by IntelliJ IDEA.
  User: neco
  Date: 2017/4/23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="点击" onclick="alert(path)">
</body>
</html>
