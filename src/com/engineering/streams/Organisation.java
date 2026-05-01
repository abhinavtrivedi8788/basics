package com.engineering.streams;

import java.util.List;

public class Organisation {

    private String OrgName;
    private String location;
    private List<Employee> employees;

    Organisation(String orgName, String location, List<Employee> employees) {
        OrgName = orgName;
        this.location = location;
        this.employees = employees.stream().map(Employee::new).toList(); // deep copy - best practices
    }
    public String getOrgName() {
        return OrgName;
    }
    public void setOrgName(String orgName) {
        OrgName = orgName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "OrgName='" + OrgName + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                '}';
    }
}
