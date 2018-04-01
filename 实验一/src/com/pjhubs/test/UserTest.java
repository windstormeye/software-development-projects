package com.pjhubs.test;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.pjhubs.instance.User;
import com.pjhubs.dao.intf.UserDAO;
import com.pjhubs.dao.impl.UserDAOImpl;

public class UserTest {

    @Test
    public void testSelectAllUser() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        List<User> userList = userDAO.selectAllUser();
        for (User user : userList) {
            System.out.println("id：" + user.getId() + "昵称：" + user.getNickname());
        }
    }

    @Test
    public void testSelectUserWithID() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.selectUserWithID(1);
        System.out.println("id:" + user.getId() + " 昵称:" + user.getNickname());
    }

    @Test
    public void testInsertUser() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setNickname("PJHubs");
        user.setPasswd("woaiwoziji123");
        userDAO.insertUser(user);
    }

    @Test
    public void testDeleteUserByID() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.deleteUserWithID(1);
    }

    @Test
    public void testUpdateUserNickname() throws Exception {
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setNickname("pjhubs");
        user.setId(1);
        user.setPasswd("woaiwoziji123");
        userDAO.updateUserWithNickname(user);
    }

}
