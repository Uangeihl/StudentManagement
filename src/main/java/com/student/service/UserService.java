package com.student.service;

import com.student.bean.User;

import java.sql.SQLException;

public interface UserService {
    public User login(User user) throws SQLException;
    public void regist(User user) throws SQLException;
    public boolean existUser(String username) throws SQLException;
}
