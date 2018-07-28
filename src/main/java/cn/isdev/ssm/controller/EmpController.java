package cn.isdev.ssm.controller;

import cn.isdev.ssm.bean.Emp;
import cn.isdev.ssm.bean.User;
import cn.isdev.ssm.dao.EmpDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/7/28.
 */
@Controller
public class EmpController {

    @Resource(name = "empDao")
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @RequestMapping(value = "/register")
    public String register(Emp emp){
        Logger logger = Logger.getLogger(EmpController.class.getName());
        try {
            logger.info("emp = " + emp);
            empDao.add(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
