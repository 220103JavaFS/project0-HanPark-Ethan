package com.project0.services;

import com.project0.models.Role;
import com.project0.repos.RoleDAO;
import com.project0.repos.RoleDAOImpl;

import java.util.List;

public class RoleService {
    private RoleDAO roleDAO = new RoleDAOImpl();

    public List<Role> findAll(){
        return roleDAO.findAll();
    }

    public Role findByRole(String roleName){
        return roleDAO.findByRole(roleName);
    }

    public boolean updateRole(Role role){
        return roleDAO.updateRole(role);
    }

    public boolean addRole(Role role){
        return roleDAO.addRole(role);
    }
}

