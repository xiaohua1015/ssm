package cn.isdev.ssm.utils;

import cn.isdev.ssm.bean.Student;
import cn.isdev.ssm.bean.User;
import cn.isdev.ssm.dao.IUserDao;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/28.
 */
public class MybatisUtils {

    private static  ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("test/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null) {
            sqlSession.close();
            threadLocal.set(null);
        }
    }

    public static void main(String[] args) {
//        baseTest();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Student student= sqlSession.selectOne("cn.isdev.ssm.dao.Student.findById", 1);
        System.out.println("student = " + student);
        MybatisUtils.closeSqlSession();
    }

    private static void baseTest() {
        Connection connection = MybatisUtils.getSqlSession().getConnection();
        if(connection == null) {
            System.out.println("链接失败");
        } else {
            System.out.printf("链接成功");
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int delete = sqlSession.delete(IUserDao.class.getName()+".delete", 84);
        sqlSession.commit();
        System.out.println("操作影响" + delete + "行");

        //分页查询
        Map<String,Object> map = new HashMap();
        map.put("name", "%杨%");
        map.put("pstart", 2);
        map.put("psize", 3);
        List<User> userList = sqlSession.selectList(IUserDao.class.getName() + ".findPageList", map);
        System.out.printf("userlist = " + userList);
    }
}
