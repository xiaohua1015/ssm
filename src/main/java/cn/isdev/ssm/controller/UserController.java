package cn.isdev.ssm.controller;

import cn.isdev.ssm.bean.User;
import cn.isdev.ssm.dao.IUserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/7/29.
 */
@Controller
public class UserController {

    @Resource(type = IUserDao.class)
    private IUserDao userDao;

    @RequestMapping(value = "/userRegister")
    public String register(User user) {
        Logger logger = Logger.getLogger(UserController.class.getName());
        try {
            logger.info("emp = " + user);
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/finById")
    @ResponseBody
    public User register(int id) {
        Logger logger = Logger.getLogger(UserController.class.getName());
        try {
            User user = userDao.findById(1);
            System.out.println("user = " + user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
