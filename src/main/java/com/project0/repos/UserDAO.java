package com.project0.repos;

import com.project0.models.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findUser(int id);
    User findByUsername(String username);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean removeUser(User user);
}
