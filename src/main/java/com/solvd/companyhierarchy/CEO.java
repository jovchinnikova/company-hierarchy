package com.solvd.companyhierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CEO {

    @XmlElement(name = "firstNameDir")
    private String firstName;
    @XmlElement(name = "lastNameDir")
    private String lastName;

    public CEO(){

    }

    public CEO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("%s %s",firstName,lastName);
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
}
