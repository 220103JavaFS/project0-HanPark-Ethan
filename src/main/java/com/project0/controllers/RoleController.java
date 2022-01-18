package com.project0.controllers;

import com.project0.models.Role;
import com.project0.services.RoleService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class RoleController implements Controller{
    private RoleService roleService = new RoleService();

    Handler getAllRoles = (ctx) -> {
      if (ctx.req.getSession(false) != null){
          ctx.json(roleService.findAll());
          ctx.status(200);
      }else {
          ctx.status(401);
      }
    };

    Handler getRole = (ctx) -> {
        if (ctx.req.getSession(false) != null){
            String roleName = ctx.pathParam("roleName");
            Role role = roleService.findByRole(roleName);
            ctx.json(role);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateRole = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Role role = ctx.bodyAsClass(Role.class);
            if (roleService.updateRole(role)) {
                ctx.status(202);
            } else {
                ctx.status(406);
            }
        } else {
            ctx.status(401);
        }
    };

    Handler addRole = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Role role = ctx.bodyAsClass(Role.class);
            if (roleService.addRole(role)) {
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

    }
}
