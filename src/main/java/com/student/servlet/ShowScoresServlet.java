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

@WebServlet("/ShowScoresServlet")
public class ShowScoresServlet extends HttpServlet {
    private int pageNow=1;
    private int rowCount=0;
    private int pageSize=2;
    private int pageCount=0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoresDeal sdl = new ScoresDeal();
        try {
            rowCount = sdl.getRowCount();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        pageCount = sdl.getPageCount(pageSize,rowCount);

        String sql = "";
        String str_pageNow = request.getParameter("pageNow");
        if(str_pageNow != null){
            pageNow = Integer.parseInt(str_pageNow);
        }
        if(pageNow>1){
            sql = "select * from student.score limit " + pageSize*(pageNow-1) +"," + pageSize +"";
        }else{
            sql = "select * from student.score limit " + pageSize +"";
        }
        ArrayList<Student> al = null;
        try {
            al = sdl.showSelectResult(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("selresult",al);
        request.setAttribute("pageNow",pageNow+"");
        request.setAttribute("rowCount",rowCount+"");
        request.setAttribute("pageCount",pageCount+"");
        request.getRequestDispatcher("StudentManagement.jsp").forward(request,response);
    }
}
