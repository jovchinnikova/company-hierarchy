package com.solvd.companyhierarchy;

import java.util.List;
import java.util.Set;

public class Company {

    private String title;
    private CEO director;
    private Set<Worker> workers;
    private List<Department> departments;
    private int phoneNumber;
    private String site;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDirector(CEO director) {
        this.director = director;
    }

    public CEO getDirector() {
        return director;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }
}
