package com.project0.services;

import com.project0.models.User;
import com.project0.repos.UserDAO;
import com.project0.repos.UserDAOImpl;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public User callUser(int id){
        return userDAO.findUser(id);
    }
}
