package mapper;

import pojo.User;

import java.util.List;

public interface UserMapper {
    //登录
    public User Login(User user);
    //用户表列
    public List<User> userList();
    //注册
    public boolean RegisterUser(User user)throws Exception;
    //用户查询
    public List<User> selectByWhere(String name) throws Exception;
}
