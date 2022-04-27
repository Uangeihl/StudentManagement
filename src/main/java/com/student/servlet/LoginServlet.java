package com.student.servlet;

import com.student.bean.User;
import com.student.service.UserService;
import com.student.service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService UserServiceImpl=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 取参数
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用service方法
        User user = new User(username, password);
        try {
            if (UserServiceImpl.login(user) != null) {
                response.sendRedirect("ShowScoresServlet");
                //request.getRequestDispatcher("/StudentManagement.jsp").forward(request, response);
            }
            else {
                request.setAttribute("message","请重新登录");
                request.getRequestDispatcher("/login.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }
}