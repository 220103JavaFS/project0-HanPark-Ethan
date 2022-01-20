package com.project0.controllers;

import com.project0.models.UserDTO;
import com.project0.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller{
    private LoginService loginService = new LoginService();

    private Handler login = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);

        if (loginService.login(user.username, user.password)){
            ctx.req.getSession();
            ctx.status(200);
        }else{
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };

    private Handler logout = (ctx) -> {
        if(ctx.req.getSession(false) != null){
            ctx.req.getSession().invalidate();
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };
    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.login);
        app.post("/logout", this.logout);
    }
}
