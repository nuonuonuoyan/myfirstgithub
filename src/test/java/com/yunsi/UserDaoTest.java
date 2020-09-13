package com.yunsi;

import com.yunsi.dao.UserDao;
import com.yunsi.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void loginTest(){
        UserDao dao = new UserDao();
        User user = new User();
        user.setPassword("1234");
        user.setUsername("赖国");
        User user2 = null;
        try {
            user2 = dao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user2);
    }
}
