package com.project0.services;

public class LoginService {
    public boolean login(String username, String password){
        if (username.equals("user") && password.equals("password")){
            return true;
        }else{
            return false;
        }
    }
}
