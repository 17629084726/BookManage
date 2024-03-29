package com.rey.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rey.bean.User;
import com.rey.service.UserDao;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/login.action")
    public  String Login(User user, Model model ) throws Exception {
        HttpSession session = request.getSession();
        User loginUser = userDao.Login(user);
        Integer id = loginUser.getId();
        String power = loginUser.getPower();
        session.setAttribute("id", id);
        session.setAttribute("power", power);
        session.setAttribute("user",loginUser);
        if (loginUser!=null){
            return "frame";
        }else {
            model.addAttribute("mas","用户名密码错误");
            return "login";
        }
        }
        @RequestMapping("/UserList.action")
        public String UserList(@RequestParam(required = false,defaultValue = "1",value = "page")int page,Model model,User user) throws Exception {
            PageHelper.startPage(page,4);
            List<User> userList = userDao.getUserlist(user);
            PageInfo pageInfo = new PageInfo(userList);
            model.addAttribute("pageInfo",pageInfo);
            return "userList";

    }
    @RequestMapping("/getUserByid.action")
    public ModelAndView getUserByid(int id) throws Exception {
        ModelAndView mav =new ModelAndView();
        User user = userDao.getUserByid(id);
        mav.addObject("user",user);
        mav.setViewName("userView");
        return mav;
    }

    @RequestMapping("/getUserByid2.action")
    public ModelAndView getUserByid2(int id) throws Exception {
        ModelAndView mav =new ModelAndView();
        User user = userDao.getUserByid(id);
        mav.addObject("user",user);
        mav.setViewName("userUpdate");
        return mav;
    }
    @RequestMapping("/updateuser.action")
    public String updateuser(User user , MultipartFile pictureFile) throws Exception {
        String filename = UUID.randomUUID().toString().replaceAll("-","");
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        filename = filename+"."+extension;
        pictureFile.transferTo(new File("D:\\picture\\"+filename));
        user.setHeadpath(filename);
         userDao.updateUser(user);
        return "redirect:/UserList.action";
    }

    @RequestMapping("/RegisterUser.action")
    public String RegisterUser(User user) throws Exception {
        userDao.RegisterUser(user);
        return "redirect:/UserList.action";
    }

    @RequestMapping("/deleteUserByid.action")
    public String deleteUserByid(Integer id) throws Exception {
        userDao.deleteUserByid(id);
        return "redirect:/UserList.action";
    }

    @RequestMapping("/selectByWhere.action")

    public  String  selectByWhere(String name) throws Exception {
        List<User> userList =userDao.selectByWhere(name);
        request.setAttribute("userList",userList);
        return "userList";
    }
}
