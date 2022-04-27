package com.student.utils;

import com.student.bean.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoresDeal {
    private Connection conn=null;
    private Statement stmt=null;
    ResultSet resultSet = null;
    private String sql="";

    public int getRowCount() throws SQLException {
        int rowcount = 0;
        conn = DBManager.getConnection();
        stmt=conn.createStatement();
        String sql = "select * from student.score";
        resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) rowcount = resultSet.getInt(1);
        return rowcount;
    }
    public int getPageCount(int pagesize,int rowcount){
        int pagecount = 0;
        if(rowcount%pagesize==0){
            pagecount = rowcount/pagesize;
        }else{
            pagecount = rowcount/pagesize+1;
        }
        return pagecount;
    }
    public ArrayList<Student> showSelectResult(String sql) throws SQLException {
        ArrayList<Student> scoreal = new ArrayList<Student>();
        conn = DBManager.getConnection();
        stmt=conn.createStatement();
        resultSet = stmt.executeQuery(sql);
        while (resultSet.next()){
            Student stu = new Student();
            stu.setId(resultSet.getInt("id"));
            stu.setName(resultSet.getString("name"));
            stu.setJavaweb(resultSet.getInt("javaweb"));
            stu.setSpring(resultSet.getInt("spring"));
            stu.setPython(resultSet.getInt("python"));
            scoreal.add(stu);
        }
        return scoreal;
    }

    public boolean isIdExist(int id) throws SQLException {
        boolean result=false;
        conn=new DBManager().getConnection();
        stmt=conn.createStatement();
        sql="select 1 from student.score where id=" + id + " limit 1";
        if(stmt.executeQuery(sql).next()) {
            result=true;
        }
        return result;
    }

    public boolean addResult(Student student) throws SQLException {
        boolean result=false;
        if(isIdExist(student.getId())) return false;
        conn=new DBManager().getConnection();
        stmt=conn.createStatement();
        sql="insert into student.score (id,name,javaweb,spring,python) values(" + student.getId() + ",'" + student.getName() + "'," + student.getJavaweb() + "," + student.getSpring() + "," + student.getPython() + ")";
        if(stmt.executeUpdate(sql)>=1) result=true;
        return result;
    }

    public boolean modifyResult(Student student) throws SQLException {
        boolean result=false;
        if(!isIdExist(student.getId())) return false;
        conn=new DBManager().getConnection();
        stmt=conn.createStatement();
        sql="update student.score set name = '" + student.getName() + "',javaweb = " + student.getJavaweb() + ",spring = " + student.getSpring() + ",python = " + student.getPython() + " where id = " + student.getId() + "";
        if(stmt.executeUpdate(sql)>=1) result=true;
        return result;
    }

    public Student search(int id) throws SQLException {
        Student stu = new Student();
        sql = "select * from student.score where id = " + id;
        conn= new DBManager().getConnection();
        stmt=conn.createStatement();
        resultSet = stmt.executeQuery(sql);
        stu.setId(id);
        while (resultSet.next()){

            stu.setName(resultSet.getString("name")); stu.setJavaweb(resultSet.getInt("javaweb")); stu.setSpring(resultSet.getInt("spring"));resultSet.getInt("spring"); stu.setPython(resultSet.getInt("python"));
        }
            return stu;
    }

    public boolean deleteResult(int id) throws SQLException {
        boolean result=false;
        if(!isIdExist(id)) return false;
        conn= new DBManager().getConnection();
        stmt=conn.createStatement();
        sql = "delete from student.score where id = "+id ;
        if(stmt.executeUpdate(sql)>=1) result=true;
        return result;
    }

    public boolean isNumber(String str){
        boolean result = false;
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            result = true;
        }
        return result;
    }
}
