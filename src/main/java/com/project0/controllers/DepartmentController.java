package com.project0.controllers;

import com.project0.Driver;
import com.project0.models.Department;
import com.project0.services.DepartmentService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentController implements Controller{
    private static Logger log = LoggerFactory.getLogger(Driver.class);
    private DepartmentService departmentService = new DepartmentService();

    Handler getAllDept = (ctx) -> {
        if (ctx.req.getSession(false) != null){
            ctx.json(departmentService.findAll());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getDept = (ctx) -> {
        if (ctx.req.getSession(false) != null){
            String deptName = ctx.pathParam("deptName");
            Department department = departmentService.findByDept(deptName);
            ctx.json(department);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateDept = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Department department = ctx.bodyAsClass(Department.class);
            if (departmentService.updateDept(department)) {
                ctx.status(202);
            } else {
                ctx.status(406);
            }
        } else {
            ctx.status(401);
        }
    };

    Handler addDept = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Department department = ctx.bodyAsClass(Department.class);
            if (departmentService.addDept(department)) {
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
        app.get("/department", getAllDept);
        app.get("/department/{deptName}", getDept);
        app.put("/department", updateDept);
        app.post("/department", addDept);
    }
}
