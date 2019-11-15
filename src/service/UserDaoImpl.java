package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(User user) throws SQLException {
        return userMapper.Login(user);
    }

    @Override
    public List<User> userList() throws Exception {
        return userMapper.userList();
    }

    @Override
    public boolean RegisterUser(User user) throws Exception {
        return userMapper.RegisterUser(user);
    }

    @Override
    public List<User> selectByWhere(String name) throws Exception {
        return userMapper.selectByWhere(name);
    }


}
