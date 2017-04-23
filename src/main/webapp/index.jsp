<%--
  Created by IntelliJ IDEA.
  User: neco
  Date: 2017/4/23
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>register</title>
    <script src="resources/js/jquery-2.1.4.js" charset="UTF-8" type="text/javascript"></script>
    <link href="resources/css/common.css" rel="stylesheet">
    <link href="resources/css/table.css" rel="stylesheet">
</head>
<body>
<form action="#" method="post">
    <table>
        <tr>
            <td>
                <label for="userAccount">用户账号</label>
                <input type="text" id="userAccount" name="username" onblur="checkName()">
            </td>
        </tr>
        <tr>
            <td>
                <label for="username">用户姓名</label>
                <input type="text" id="username" name="username" onblur="checkName()">
            </td>
        </tr>
        <tr>
            <td>
                <label for="pass1">密码</label><input id="pass1" type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <label for="pass2">重复密码</label><input id="pass2" type="text" name="password2">
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    邮箱：
                    <input type="text" name="mail">
                </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="注册">
</form>
</body>
<script type="text/javascript">

    function checkName() {
        $.ajax({
            url:"/study/ajaxCheckName.do",
            type:"POST",
            data:{username:$("#username").val()},
            success:function (jsonResult) {

            }
        });
    }
</script>
</html>
