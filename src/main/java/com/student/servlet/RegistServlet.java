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
@WebServlet(name = "RegistServlet",urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //2.检查
        try {
            if(userService.existUser(username)){
                System.out.println("用户已经存在");
                req.setAttribute("message","用户已经存在");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
            else{
                userService.regist(new User(username,password));
                //跳转注册登录页面
                System.out.println("注册成共并且跳转");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
