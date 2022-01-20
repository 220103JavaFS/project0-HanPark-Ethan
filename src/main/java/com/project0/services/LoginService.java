package com.project0.services;

import com.project0.models.User;
import com.project0.repos.UserDAOImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginService {

//    private UserDAOImpl userDAO = new UserDAOImpl();
//
//    public User login(String username, String password) {
//        User user = userDAO.findByUsername(username);
//        MessageDigest messageDigest = null;
//        try {
//            MessageDigest.getInstance("SHA-512");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        byte[] encryptedPwd = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
//
//        if (checkEncryption(user.getPassword(), String.valueOf(encryptedPwd))) {
//            return user;
//        } else {
//            return null;
//        }
//    }
//
//    private static boolean checkEncryption(String encrypt1, String encrypt2) {
//        if (encrypt1.length() != encrypt2.length()) {
//            return false;
//        }
//        return true;
//    }

    public boolean login(String username, String password){
        if (username.equals("user") && password.equals("password")){
            return true;
        }else{
            return false;
        }
    }
}