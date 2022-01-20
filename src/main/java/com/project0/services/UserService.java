package com.project0.services;

import com.project0.models.User;
import com.project0.repos.UserDAO;
import com.project0.repos.UserDAOImpl;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public List<User> findAll(){
        return userDAO.findAll();
    }
    public User findUser(int id){
        return userDAO.findUser(id);
    }

    public boolean updateUser(User user){
        return userDAO.updateUser(user);
    }

    public boolean addUser(User user){
        return userDAO.addUser(user);
    }
}
