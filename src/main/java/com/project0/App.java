package com.project0;

import com.project0.controllers.Controller;
import com.project0.controllers.DepartmentController;
import com.project0.controllers.LoginController;
import com.project0.controllers.RoleController;
import io.javalin.Javalin;

public class App {
    private static Javalin app;

    public static void main(String[] args){

        app = Javalin.create();
        configure(new RoleController(), new DepartmentController(), new LoginController());
        app.start();

    }

    private static void configure(Controller... controllers){
        for (Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
