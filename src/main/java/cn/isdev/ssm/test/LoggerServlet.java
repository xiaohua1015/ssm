package cn.isdev.ssm.test;

import cn.isdev.ssm.bean.User;
import cn.isdev.ssm.dao.IUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lsh134667 on 2018/7/26.
 */
@WebServlet(name = "LoggerServlet", urlPatterns = "/test")
public class LoggerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Logger logger = LogManager.getLogger(LoggerServlet.class);
        logger.debug("response befor");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        IUserDao userDao = context.getBean(IUserDao.class);
        User user = userDao.findById(1);
        response.getWriter().write("testServlet" + user);
        System.out.println("user = " + user);
        logger.error("user ====" + user);
        /*ist<User> all = userDao.findAll();
        System.out.println("list = " + all);*/
        logger.debug("response after");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
