<%--
  Created by IntelliJ IDEA.
  User: neco
  Date: 2017/4/23
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>login</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.js" charset="UTF-8" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/table.css" rel="stylesheet">
</head>
<body>
    <table>
        <tr>
            <td>
                <label for="username">
                    <input id="username" type="text" name="username" value="${username}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">
                    <input id="password" type="text" name="password">
                </label>
            </td>
        </tr>
    </table>
</body>
</html>
