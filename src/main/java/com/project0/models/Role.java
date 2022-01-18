package com.project0.models;

import java.util.Objects;

public class Role {
    private String roleName;
    private double minSalary;
    private double maxSalary;

    public Role() {
    }

    public Role(String roleName, double min_salary, double max_salary) {
        this.roleName = roleName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Double.compare(role.getMinSalary(), getMinSalary()) == 0 && Double.compare(role.getMaxSalary(), getMaxSalary()) == 0 && Objects.equals(getRoleName(), role.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName(), getMinSalary(), getMaxSalary());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
