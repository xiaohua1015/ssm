package cn.isdev.ssm.dao;

import cn.isdev.ssm.bean.User;

import java.util.List;

/**
 * Created by lsh134667 on 2018/7/26.
 */
public interface IUserDao {

    void save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<User> findAll();
    List<User> findPageList();
}
