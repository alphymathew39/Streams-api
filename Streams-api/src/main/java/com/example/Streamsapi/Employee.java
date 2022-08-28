package com.example.Streamsapi;

import java.util.List;

public class Employee {
    private String FirstName;
    private String LastName;
    private double salary;
    private List<String> projects;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    public Employee(String firstName, String lastName, double salary, List<String> projects) {
        FirstName = firstName;
        LastName = lastName;
        this.salary = salary;
        this.projects = projects;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }


}
