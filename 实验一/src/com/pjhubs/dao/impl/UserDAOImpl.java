package com.pjhubs.dao.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pjhubs.dao.intf.UserDAO;
import com.pjhubs.instance.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public User selectUserWithID(int ID) throws  Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        //参数一：namespace.id
        User user = session.selectOne("user.selectUserWithID", ID);
        //--------------
        session.close();
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> usersList = new ArrayList<User>();
        try {
            String resource = "SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            //---------------------
            usersList = session.selectList("user.selectAllUser");
            //----------------------
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usersList;
    }

    @Override
    public void insertUser(User user) throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.insert("user.insertUser", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    @Override
    public void deleteUserWithID(int ID) throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.delete("user.deleteUserWithID", ID);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    @Override
    public void updateUserWithNickname(User user) throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.update("user.updateUserWithNickname", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }
}
