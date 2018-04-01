package com.pjhubs.dao.intf;

import java.util.List;
import com.pjhubs.instance.User;

public interface UserDAO {

    public User selectUserWithID(int ID) throws Exception;
    public List<User> selectAllUser() throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserWithID(int ID) throws Exception;
    public void updateUserWithNickname(User user) throws Exception;

}
