package cn.isdev.ssm.test;

import cn.isdev.ssm.bean.Emp;
import cn.isdev.ssm.dao.EmpDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/28.
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        EmpDao empDao = context.getBean("empDao", EmpDao.class);
        empDao.add(new Emp(2, "小明", 12000.89, "F"));
    }
}
