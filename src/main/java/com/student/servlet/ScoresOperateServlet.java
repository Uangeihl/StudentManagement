package com.student.servlet;

import com.student.bean.Student;
import com.student.utils.ScoresDeal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/ScoresOperateServlet")
public class ScoresOperateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoresDeal sdl = new ScoresDeal();
        String operate = request.getParameter("operate");
        String strId = request.getParameter("id");
        if(operate.equals("delete")){
            if(strId.equals("")||!sdl.isNumber(strId)){
                request.setAttribute("message", "请输入正确值,且不可空");
                request.getRequestDispatcher("delete.jsp").forward(request, response);
            } else {
                try {
                    if (sdl.deleteResult(Integer.parseInt(request.getParameter("id")))){
                        request.setAttribute("message", "删除成功");
                        request.getRequestDispatcher("delete.jsp").forward(request, response);
                    } else {
                        request.setAttribute("message", "删除不成功，学号不存在");
                        request.getRequestDispatcher("delete.jsp").forward(request, response);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else if(operate.equals("search")){
            if(strId.equals("")||!sdl.isNumber(strId)){
                request.setAttribute("message","请输入正确值,且不可空");
                request.getRequestDispatcher("modify.jsp").forward(request, response);}
            else {
                int id =Integer.parseInt(strId);
                try {
                    if (!sdl.isIdExist(id)){
                        request.setAttribute("message","学号不存在");
                        request.getRequestDispatcher("modify.jsp").forward(request, response);
                    }
                    else {
                        Student stu = sdl.search(id);
                        ArrayList<Student> al = null;
                        request.setAttribute("stu",stu);
                        request.getRequestDispatcher("modify.jsp").forward(request, response);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else {
            Student student = new Student();
            boolean flage = false;
            String strName = request.getParameter("name");
            String strJavaweb = request.getParameter("javaweb");
            String strSpring = request.getParameter("spring");
            String strPython = request.getParameter("python");
            if (strId.equals("")||strName.equals("")||strJavaweb.equals("")||strSpring.equals("")||strPython.equals("")){
                flage = true;
            } else if (!sdl.isNumber(strId)||!sdl.isNumber(strJavaweb)||!sdl.isNumber(strSpring)||!sdl.isNumber(strPython)){
                flage = true;
            } else {
                student.setId(Integer.parseInt(strId));
                student.setName(strName);
                student.setJavaweb(Integer.parseInt(strJavaweb));
                student.setSpring(Integer.parseInt(strSpring));
                student.setPython(Integer.parseInt(strPython));
            }
            if(operate.equals("add")){
                if(flage){
                    request.setAttribute("message", "请输入正确值,且不可空");
                    request.getRequestDispatcher("add.jsp").forward(request, response);
                } else {
                    try {
                        if (sdl.addResult(student)){
                            request.setAttribute("message", "添加成功");
                            request.getRequestDispatcher("add.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "添加失败，学号已存在");
                            request.getRequestDispatcher("add.jsp").forward(request, response);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            if(operate.equals("modify")){
                if(flage){
                    request.setAttribute("message", "请输入正确值,且不可空");
                    request.getRequestDispatcher("modify.jsp").forward(request, response);
                } else {
                    try {
                        if (sdl.modifyResult(student)){
                            request.setAttribute("message", "修改成功");
                            request.getRequestDispatcher("modify.jsp").forward(request, response);
                        } else{
                            request.setAttribute("message", "修改不成功，学号不存在");
                            request.getRequestDispatcher("modify.jsp").forward(request, response);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }
    }
}
