package com.dao;

import com.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     */
    List<User> findUserAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除指定用户
     * @param id
     */
    void deleteUserById(int id);

    /**
     * 根据有户名模糊查询
     * @param username
     * @return
     */
    List<User> findUserByUsername(String username);

    /**
     *获取用户及用户下的账户
     */
    List<User> findUserAndAccount();

    /**
     * 根据user条件查询
     */
    List<User> findUserByCondition(User user);
}
