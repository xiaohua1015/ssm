package cn.isdev.ssm.dao;

import cn.isdev.ssm.bean.Emp;
import cn.isdev.ssm.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Administrator on 2018/7/28.
 */
public class EmpDao {
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void add (Emp emp) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert(Emp.class.getName() + ".add", emp);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
