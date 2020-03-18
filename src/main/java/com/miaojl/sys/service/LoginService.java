package com.miaojl.sys.service;

import com.miaojl.sys.dao.UserDao;
import com.miaojl.sys.entity.User;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 登录业务逻辑
 */
public class LoginService {
    private UserDao userDao = new UserDao();
    public User getLoginUser(User user){
        return userDao.LoginDao(user);
    }

}
