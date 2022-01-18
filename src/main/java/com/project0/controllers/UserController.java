package com.project0.controllers;

import com.project0.models.Role;
import com.project0.models.User;
import com.project0.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller{
    private UserService userService = new UserService();

    Handler getAllUsers = (ctx) -> {
        if (ctx.req.getSession(false) != null){
            ctx.json(userService.findAll());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getUser = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);
            User user = userService.findUser(id);
            ctx.json(user);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateUser = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            User user = ctx.bodyAsClass(User.class);
            if (userService.updateUser(user)) {
                ctx.status(202);
            } else {
                ctx.status(406);
            }
        } else {
            ctx.status(401);
        }
    };

    Handler addUser = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            User user = ctx.bodyAsClass(User.class);
            if (userService.addUser(user)) {
                ctx.status(201);
            } else {
                ctx.status(406);
            }
        } else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/user", getAllUsers);
        app.get("/user/{id}", getUser);
        app.put("/user", updateUser);
        app.post("/user", addUser);
    }
}
