package com.pjhubs.controller;

import com.pjhubs.DAO.MemoryMapper;
import com.pjhubs.DAO.UserMapper;
import com.pjhubs.Model.Memory;
import com.pjhubs.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Controller
@Component
public class thingsController {

    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行
    public void taskCycle() throws Exception {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory() / 1024 / 1024 + "," + runtime.totalMemory() / 1024 / 1024 + "," + runtime.freeMemory() / 1024 / 1024);


        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        Memory memory = new Memory();
        memory.setMax(runtime.maxMemory() / 1024 / 1024);
        memory.setTotal(runtime.totalMemory() / 1024 / 1024);
        memory.setFree(runtime.freeMemory() / 1024 / 1024);


        MemoryMapper mapper = session.getMapper(MemoryMapper.class);
        mapper.insertData(memory);
        session.commit();
        session.close();

    }

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

    @RequestMapping(value = "/deleteThing/{id}", method = RequestMethod.POST)
    public String deleteThing(@PathVariable("id") int id) throws Exception {

        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUserWithID(id);
        session.commit();

        session.close();

        System.out.println(id);
        return "redirect:/allThings";
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public String modifyThing(@PathVariable("id") int id, ModelMap modelMap) throws Exception {

        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserWithID(id);
        session.commit();

        session.close();

        modelMap.addAttribute("id", user.getId());
        modelMap.addAttribute("nickname", user.getNickname());

        return "modify";
    }

    @RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.POST)
    public String updateStudent(int id, String nickname) throws Exception {

        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        User user = new User();
        user.setId(id);
        user.setNickname(nickname);

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUserWithNickname(user);
        session.commit();

        session.close();

        return "redirect:/allThings";
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser(ModelMap modelMap) {
        return "insertUser";
    }

    @RequestMapping(value = "/insertNewuser", method = RequestMethod.POST)
    public String updateStudent(String nickname, String passwd) throws Exception {

        String resource = "com/pjhubs/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        User newuser = new User();
        newuser.setNickname(nickname);
        newuser.setPasswd(passwd);

        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(newuser);
        session.commit();
        session.close();

        return "redirect:/allThings";
    }

}
