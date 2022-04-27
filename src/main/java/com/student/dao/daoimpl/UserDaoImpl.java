package com.student.dao.daoimpl;
import com.student.bean.User;
import com.student.dao.UserDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.student.utils.DBManager;
import java.sql.Connection;



public class UserDaoImpl implements UserDao {

    @Override
    public boolean queryByUsername(String username) throws SQLException {
        DBManager db = new DBManager();
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from student.user where username='" +username+ "'";
        ResultSet resultSet=stmt.executeQuery(sql);
        if(resultSet.next()) return true;
        return false;

    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) throws SQLException {
        boolean result = false;
        DBManager db = new DBManager();
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from student.user where username='" + username+ "'and password='" + password + "'";
        if(stmt.executeQuery(sql).next()) return new User(username,password);
        return null;
    }

    @Override
    public User saveUser(User user) throws SQLException {
        boolean result = false;
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student.user (username,password) values('" + user.getUserName() + "','" + user.getPassword() + "')";
        if (stmt.executeUpdate(sql) >= 1) {
            result = true;
            return user;
        }
        return null;
    }
}
