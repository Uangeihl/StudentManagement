package com.student.dao;

import com.student.bean.User;

import java.sql.SQLException;

public interface UserDao {
    public boolean queryByUsername(String username) throws SQLException;
    public User queryByUsernameAndPassword(String username, String password) throws SQLException;
    public User saveUser(User user) throws SQLException;

}
