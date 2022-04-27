package com.student.service.serviceimpl;

import com.student.bean.User;
import com.student.dao.UserDao;
import com.student.dao.daoimpl.UserDaoImpl;
import com.student.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public User login(User user) throws SQLException {
        return userDao.queryByUsernameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public void regist(User user) throws SQLException {
        userDao.saveUser(user);
    }

    @Override
    public boolean existUser(String username) throws SQLException {
        if (userDao.queryByUsername(username)){
            return true;
        }
        else return false;
    }
}
