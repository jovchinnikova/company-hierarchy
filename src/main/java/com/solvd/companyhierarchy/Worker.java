package com.solvd.companyhierarchy;

import java.time.LocalDateTime;

public class Worker {

    private Integer id;
    private String firstName;
    private String lastName;
    private double averageSalary;
    private Integer vacationDuration;
    private LocalDateTime startVacation;

    public Worker(String firstName, String lastName, double averageSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageSalary = averageSalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public Integer getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(Integer vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    public void setStartVacation(LocalDateTime startVacation) {
        this.startVacation = startVacation;
    }

    public LocalDateTime getStartVacation() {
        return startVacation;
    }
}
