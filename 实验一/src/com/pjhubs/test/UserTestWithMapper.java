package com.pjhubs.test;

import com.pjhubs.dao.intf.UserMapper;
import com.pjhubs.instance.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTestWithMapper {

    @Test
    public void selectUserWithID() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserWithID(2);
        System.out.println("id:" + user.getId() + " 昵称：" + user.getNickname());
        //--------------
        session.close();
    }

    @Test
    public void selectAllUser() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAllUser();
        for (User user : userList) {
            System.out.println("id:" + user.getId() + " 昵称：" + user.getNickname());
        }
        //----------------------
        session.close();
    }

    @Test
    public void deleteUserWithID() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUserWithID(2);
        session.commit();
        //----------------------
        session.close();
    }

    @Test
    public void insertUser() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        User user = new User();
        user.setNickname("yhyyyy");
        user.setPasswd("woaiwoziji123");

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(user);
        session.commit();
        //----------------------
        session.close();
    }

    @Test
    public void updateUserWithNickname() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        User user = new User();
        user.setId(2);
        user.setNickname("ppppjjjj");

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUserWithNickname(user);
        session.commit();
        //----------------------
        session.close();
    }
}
