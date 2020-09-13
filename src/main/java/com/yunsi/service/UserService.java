package com.yunsi.service;

import com.yunsi.dao.UserDao;
import com.yunsi.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

public class UserService {

    public User login(User user){
        UserDao dao = new UserDao();
        try {
            User user2 = dao.login(user);
            return user2;
        } catch (EmptyResultDataAccessException e) {//如果没有查询到记录，会报一个空结果集异常
            System.out.println("用户不存在");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;//上面catch块执行以后，这个return语句也可以被执行到吗？看LoginServlet能否获取到null
    }

}