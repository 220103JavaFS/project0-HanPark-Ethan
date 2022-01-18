package com.project0.repos;

import com.project0.models.Department;

import java.util.List;

public interface DepartmentDAO {
    public List<Department> findAll();
    public Department findByDept(String department);
    public boolean updateDept(Department department);
    public boolean addDept(Department department);
}
