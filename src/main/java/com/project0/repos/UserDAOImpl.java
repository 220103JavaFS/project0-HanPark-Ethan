package com.project0.repos;

import com.project0.models.Department;
import com.project0.models.Role;
import com.project0.models.User;
import com.project0.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
        private RoleDAO roleDAO = new RoleDAOImpl();
    @Override
    public List<User> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<User> list = new ArrayList<>();
            while (result.next()){
                User user = new User();
                user.setUserID(result.getInt("user_id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmailAddress(result.getString("user_email"));
                user.setPhoneNumber(result.getString("user_phone"));
                user.setDob(result.getString("user_dob"));
                user.setSalary(result.getDouble("salary"));
                String roleName = result.getString("role_name");
                if (roleName != null){
                    Role role = roleDAO.findByRole(roleName);
                    user.setRole(role);
                }
                Department deptName = new Department(result.getString("dept_name"), result.getString("dept_descr"));
                user.setDepartment(deptName);
                list.add(user);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<User>();
    }

    @Override
    public User findUser(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM (SELECT * FROM users LEFT JOIN roles ON roles.role_name = users.role_name AS employee_name WHERE user_id = "+id+";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            User user = new User();

            while (result.next()){
                user.setUserID(result.getInt("user_id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmailAddress(result.getString("user_email"));
                user.setPhoneNumber(result.getString("user_phone"));
                user.setDob(result.getString("user_dob"));
                user.setSalary(result.getDouble("salary"));
                String roleName = result.getString("role_name");
                if (roleName != null){
                    Role role = roleDAO.findByRole(roleName);
                    user.setRole(role);
                }
                Department deptName = new Department(result.getString("dept_name"), result.getString("dept_descr"));
                user.setDepartment(deptName);
            }
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public boolean addUser(User user) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE users SET first_name = ?, last_name = ?, user_email = ?, user_phone = ?, user_dob = ?, dept_names = ?, role_names = ? WHERE role_name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, user.getFirstName());
            statement.setString(++count, user.getLastName());
            statement.setString(++count, user.getEmailAddress());
            statement.setString(++count, user.getPhoneNumber());
            statement.setString(++count, user.getDob());
            statement.setString(++count, user.getRole().getRoleName());
            statement.setString(++count, user.getDepartment().getDeptName());
            statement.setDouble(++count, user.getSalary());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean removeUser(User user) {
        return false;
    }
}
