package com.project0.services;

import com.project0.models.Department;
import com.project0.repos.DepartmentDAO;
import com.project0.repos.DepartmentDAOImpl;

import java.util.List;

public class DepartmentService {
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    public List<Department> findAll(){
        return departmentDAO.findAll();
    }
    public Department findByDept(String department){
        return departmentDAO.findByDept(department);
    }
    public boolean updateDept(Department department){
        return departmentDAO.updateDept(department);
    }
    public boolean addDept(Department department){
        return departmentDAO.addDept(department);
    }
}
