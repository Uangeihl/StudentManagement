<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2022/4/13
  Time: 下午 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body align="center">
<h2>注册</h2>
<%
    String message = (String) request.getAttribute("message");
    if(message!=null){
%>
<h4><%=message%></h4>
<%
    }
%>
<form action="RegistServlet" method="post">
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
            <td>确认密码</td>
            <td><input type="password" name="checkpassword" placeholder="请确认密码"></td>
        </tr>
        <tr>
            <td><a href="/Login.jsp">返回登录</a></td>
            <td align="right">
                <input type="submit" name="operate" value="register">
            </td>
        </tr>
    </table>
</form>
</body>
</html>