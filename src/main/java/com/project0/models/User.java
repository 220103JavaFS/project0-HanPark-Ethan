package com.project0.models;

import java.util.Objects;

public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String dob;
    private double salary;
    private Role role;
    private Department department;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String emailAddress, String phoneNumber, String dob, double salary, Role role, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.salary = salary;
        this.role = role;
        this.department = department;
    }

    public User(int userID, String firstName, String lastName, String emailAddress, String phoneNumber, String dob, double salary, Role role, Department department) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.salary = salary;
        this.role = role;
        this.department = department;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && Double.compare(user.getSalary(), getSalary()) == 0 && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmailAddress(), user.getEmailAddress()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber()) && Objects.equals(getDob(), user.getDob()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getDepartment(), user.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmailAddress(), getPhoneNumber(), getDob(), getSalary(), getRole(), getDepartment());
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob='" + dob + '\'' +
                ", salary=" + salary +
                ", role=" + role +
                ", department=" + department +
                '}';
    }
}



