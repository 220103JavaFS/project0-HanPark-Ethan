package com.project0.services;

import com.project0.models.User;
import com.project0.repos.UserDAO;
import com.project0.repos.UserDAOImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginService {
    private UserDAO userDAO = new UserDAOImpl();
//    public User login(String username, String password) {
//        User user = userDAO.findByUsername(username);
//
//        MessageDigest messageDigest = null;
//        try {
//            messageDigest = MessageDigest.getInstance("SHA-512");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        byte[] encryptedPwd = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
//        if (encryptedPwd.equals(user.getPassword())){
//
//            return user.
//        }else {
//            return null;
//        }
//    }


    public boolean login(String username, String password){
        if (username.equals("user") && password.equals("password")){
            return true;
        }else{
            return false;
        }
    }
}
