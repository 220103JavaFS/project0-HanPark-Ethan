package com.project0.repos;

import com.project0.models.Role;
import com.project0.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO{
    @Override
    public List<Role> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM departments;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Role> list = new ArrayList<>();
            while (result.next()){
                Role role = new Role();
                role.setRoleName(result.getString("role_name"));
                role.setMinSalary(result.getDouble("min_salary"));
                role.setMaxSalary(result.getDouble("max_salary"));
                list.add(role);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Role>();
    }

    @Override
    public Role findByRole(String roleName) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM roles WHERE role_name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, roleName);
            ResultSet result = statement.executeQuery();

            Role role = new Role();
            while (result.next()){
                role.setRoleName(result.getString("dept_name"));
                role.setMinSalary(result.getDouble("min_salary"));
                role.setMaxSalary(result.getDouble("max_salary"));
            }
            return role;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Role();
    }

    @Override
    public boolean updateRole(Role role) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE roles SET role_name = ?, min_salary = ?, max_salary = ? WHERE role_name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, role.getRoleName());
            statement.setDouble(++count, role.getMinSalary());
            statement.setDouble(++count, role.getMaxSalary());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addRole(Role role) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT roles (role_name, min_salary, max_salary) VALUES (?, ?, ?));";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, role.getRoleName());
            statement.setDouble(++count, role.getMinSalary());
            statement.setDouble(++count, role.getMaxSalary());

            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
