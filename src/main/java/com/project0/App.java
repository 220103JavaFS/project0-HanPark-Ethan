package com.project0;

import com.project0.controllers.*;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static Logger log = LoggerFactory.getLogger(Driver.class);

    private static Javalin app;

    public static void main(String[] args){

        app = Javalin.create();
        configure(new UserController(), new RoleController(), new DepartmentController(), new LoginController());
        app.start();

    }

    private static void configure(Controller... controllers){
        for (Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
