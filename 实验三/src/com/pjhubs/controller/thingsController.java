package com.pjhubs.controller;

import com.pjhubs.DAO.UserMapper;
import com.pjhubs.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)

public class thingsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String todoList(ModelMap modelMap) {
        modelMap.addAttribute("msg", "To-do List");
        return "todolist";
    }

    @RequestMapping(value = "/allThings", method = RequestMethod.GET)
    public List<User> allThings(ModelMap modelMap) throws Exception {

        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAllUser();
        for (User user : userList) {
            System.out.println("id:" + user.getId() + " 昵称：" + user.getNickname());
        }
        session.close();

        return userList;
    }

}
