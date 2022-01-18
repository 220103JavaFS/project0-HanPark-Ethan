package com.project0.models;

import java.util.Objects;

public class Department {
    private String deptName;
    private String deptDescr;

    public Department() {
    }

    public Department(String deptName, String deptDescr) {
        this.deptName = deptName;
        this.deptDescr = deptDescr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDescr() {
        return deptDescr;
    }

    public void setDeptDescr(String deptDescr) {
        this.deptDescr = deptDescr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getDeptName(), that.getDeptName()) && Objects.equals(getDeptDescr(), that.getDeptDescr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeptName(), getDeptDescr());
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", deptDescr='" + deptDescr + '\'' +
                '}';
    }
}
