package com.miaojl.sys.dao;

import com.miaojl.sys.utils.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 对象dao
 */
public class BaenDao {
    public JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
}
