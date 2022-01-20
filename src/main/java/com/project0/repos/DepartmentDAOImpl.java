package com.project0.repos;

import com.project0.models.Department;
import com.project0.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO{
    @Override
    public List<Department> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM departments;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Department> list = new ArrayList<>();
            while (result.next()){
                Department department = new Department();
                department.setDeptName(result.getString("dept_name"));
                department.setDeptDescr(result.getString("dept_descr"));
                list.add(department);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Department>();
    }

    @Override
    public Department findByDept(String deptName) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM departments WHERE dept_name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, deptName);
            ResultSet result = statement.executeQuery();

            Department department = new Department();
            if (result.next()){
                department.setDeptName(result.getString("dept_name"));
                department.setDeptDescr(result.getString("dept_descr"));
            }
            return department;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Department();
    }

    @Override
    public boolean updateDept(Department department) {
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE departments SET dept_name = ?, dept_descr = ? WHERE dept_name = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(count++, department.getDeptName());
            statement.setString(count++, department.getDeptDescr());
            statement.setString(count++, department.getDeptName());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDept(Department department) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO departments (dept_name, dept_descr) VALUES (?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, department.getDeptName());
            statement.setString(++count, department.getDeptDescr());
            statement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
