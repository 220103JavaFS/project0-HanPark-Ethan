package com.project0.repos;

import com.project0.models.Role;

import java.util.List;

public interface RoleDAO {
    public List<Role> findAll();
    public Role findByRole(String role);
    public boolean updateRole(Role role);
    public boolean addRole(Role role);
}
