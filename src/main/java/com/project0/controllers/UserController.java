package com.project0.controllers;

import com.project0.models.User;
import com.project0.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller{
    private UserService userService = new UserService();

    Handler getUser = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);
            User user = userService.callUser(id);
            ctx.json(user);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/user/{id}", getUser);
    }
}
