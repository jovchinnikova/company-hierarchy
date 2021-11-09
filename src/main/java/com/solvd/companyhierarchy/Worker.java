package com.solvd.companyhierarchy;

import java.time.LocalDateTime;

public class Worker {

    private Integer id;
    private String firstName;
    private String lastName;
    private double averageSalary;
    private Integer vacationDuration;
    private LocalDateTime startVacation;

    public Worker(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Worker № " + id + " " + firstName + " " + lastName + System.lineSeparator() +
                "Salary " + averageSalary + System.lineSeparator() +
                "Vacation will start " + startVacation + " and will last " + vacationDuration;
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
