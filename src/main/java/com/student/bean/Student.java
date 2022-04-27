package com.student.bean;

public class Student {
    private int id;
    private String name;
    private int javaweb;
    private int spring;
    private int python;

    public Student(String username, String password) {
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJavaweb() {
        return javaweb;
    }

    public void setJavaweb(int javaweb) {
        this.javaweb = javaweb;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", javaweb=" + javaweb +
                ", spring=" + spring +
                ", python=" + python +
                '}';
    }
}