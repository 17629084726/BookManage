package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserDao;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @RequestMapping("/frame.action")
    public ModelAndView frame(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("frame");
        return mav;
    }

    @Autowired
    UserDao userDao;

    @Autowired
    HttpServletRequest request;
    //登录
    @RequestMapping("/login.action")
    public String login(String name, String password) throws SQLException {
        HttpSession session = request.getSession();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        User loginUser = userDao.Login(user);
        if (loginUser != null){
            //重定向
            session.setAttribute("user",loginUser);
            return "frame";
        }else {
            return "login";
        }
    }
    //用户表列
    @RequestMapping("/userList.action")
    public ModelAndView  userList(@RequestParam(required = false,defaultValue = "1",value = "page")int page,User user) throws Exception {
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(page,5);
        List<User> userList = userDao.userList();
        PageInfo pages = new PageInfo(userList);
        mav.addObject("pageInfo",pages);
        mav.setViewName("userList");
        return mav;
    }
    //注册
    @RequestMapping("/RegisterUser.action")
    public String RegisterUser(User user) throws Exception {
        userDao.RegisterUser(user);
        //重定向
        return "redirect:/userList.action";
    }
    //查询
    @RequestMapping("/selectByWhere.action")
    public  String  selectByWhere(String name) throws Exception {
        List<User> userList = userDao.selectByWhere(name);
        request.setAttribute("userList", userList);
        return "userList";
    }
}
