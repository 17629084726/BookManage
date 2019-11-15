package service;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //登录
    public User Login(User user)throws SQLException;
    //用户表列
    public List<User> userList()throws Exception;
    //注册
    public boolean RegisterUser(User user) throws Exception;
    //查询
    public List<User> selectByWhere(String name) throws Exception;
}
