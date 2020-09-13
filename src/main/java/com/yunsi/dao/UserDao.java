package com.yunsi.dao;

import com.yunsi.domain.User;
import com.yunsi.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User user) throws Exception{
        String sql = "select * from users where username=? and password=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());
    }
}
