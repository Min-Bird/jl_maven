package com.miaojl.sys.dao;

import com.miaojl.sys.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 数据访问
 */
public class UserDao extends BaenDao {

//    public User LoginDao(User user) {
////        String sql = "select id,dept_id,username,password,email,qq_openid,wx_openid,real_name,age,phone,gender,desc,register_time,login_time,pic,look,is_secret,dept_name,create_date,create_by,delflag from user where username=? and password=?";
//        String sql = "select * from sys_user where username=? and password=?";
//        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
//
//    }
    public User LoginDao(User user) {
        String sql = "select * from sys_user where username=? and password =?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
    }
}
