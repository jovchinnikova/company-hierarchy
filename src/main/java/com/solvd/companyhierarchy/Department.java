package com.solvd.companyhierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    @XmlElement(name = "depTitle")
    private String title;
    @XmlElementWrapper
    @XmlElement(name = "service")
    @JsonProperty("service")
    private List<Service> services;

    public Department(){

    }

    public Department(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return title + " department provides services:" + System.lineSeparator() +
                services;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }

}
