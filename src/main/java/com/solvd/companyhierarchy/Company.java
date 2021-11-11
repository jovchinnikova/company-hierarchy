package com.solvd.companyhierarchy;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

    @XmlElement(name = "compTitle")
    private String title;
    @XmlElement
    private CEO director;
    @XmlElementWrapper(name = "workers")
    @XmlElement(name = "worker")
    private Set<Worker> workers;
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;
    @XmlAttribute
    private int phoneNumber;
    @XmlAttribute
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
