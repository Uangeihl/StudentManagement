<%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 2022/4/17
  Time: 下午 03:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.bean.Student" %>
<html>
<head>
    <title>modify</title>
</head>
<body align="center">
<h2>修改</h2>
<%
    String message = (String)request.getAttribute("message");
    if(message!=null){
%>
<h4><%=message %></h4>
<%}%>
<form action="ScoresOperateServlet">
    <tr>
        <td>学号</td>
        <td><input type="text" name="id" placeholder="请输入需要修改的学号"></td>
        <td><input type="submit" name="operate" value="search"></td>
    </tr>
</form>
<%
    Student student = (Student) request.getAttribute("stu");
    if (student!=null) {
%>
<form action="ScoresOperateServlet">
    <table align="center">
        <tr  align="center">
            <td></td>
            <td >当前值</td>
            <td>修改</td>
        </tr>
        <tr>
            <td>学号</td>
            <td><%=student.getId()%></td>
            <td><input type="text" name="id" placeholder="请确认学号"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><%=student.getName()%></td>
            <td><input type="text" name="name" placeholder="请输入姓名"></td>
        </tr>
        <tr>
            <td>javaweb</td>
            <td><%=student.getJavaweb()%></td>
            <td><input type="text" name="javaweb" placeholder="请输入javaweb成绩"></td>
        </tr>
        <td>spring</td>
        <td><%=student.getSpring()%></td>
        <td><input type="text" name="spring" placeholder="请输入spring成绩"></td>
        <tr>
            <td>python</td>
            <td><%=student.getPython()%></td>
            <td><input type="text" name="python" placeholder="请输入python成绩"></td>
        </tr>
        <tr>
            <td><a href="/ShowScoresServlet">返回</a></td>
            <td colspan="3" align="right"><input type="submit" name="operate" value="modify"></td>
        </tr>
    </table>
</form>
<%}else {%>
<td><a href="/ShowScoresServlet">返回</a></td>
<%}%>
</body>
</html>