<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2022/4/16
  Time: 下午 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body align="center">
<h2>登录</h2>
<%
    String message = (String)request.getAttribute("message");
    if(message!=null){
%>
<h4><%=message %></h4>
<%
    }
%>
<form action="LoginServlet" method="post">
    <table align="center">
        <tr>
            <td>账号</td>
            <td><input type="text" name="username" placeholder="请输入账号"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>
                <a href="/register.jsp">注册</a>
            </td>
            <td colspan="2" align="right">
                <input type="submit" name="operate" value="login">
            </td>
        </tr>
    </table>
</form>

</body>
</html>