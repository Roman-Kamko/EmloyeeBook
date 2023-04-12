package com.kamko.employeebook.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String patronymicName;
    private final String surName;
    private Department department;
    private BigDecimal salary;
    private Date dateOfEmployment;

    public Employee(String firstName,
                    String patronymicName,
                    String surName,
                    Department department,
                    BigDecimal salary,
                    int year, int month, int date) {
        this.id = ++counter;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.surName = surName;
        this.department = department;
        setSalary(salary);
        setDateOfEmployment(year, month, date);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + patronymicName + " " + surName;
    }

    public String getDepartment() {
        return department.toString();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = new BigDecimal(String.valueOf(salary));
    }

    private void setDateOfEmployment(int year,
                                     int month,
                                     int date) {
        if (year < LocalDate.now().getYear()) {
            throw new RuntimeException();                                         // todo написать exception
        }
        this.dateOfEmployment = new Date(year, month, date);
    }

    @Override
    public String toString() {
        return "ID " + id + ";" +
                "ФИО " + getFullName() + ";" +
                "Отдет " + getDepartment() + ";" +
                "ЗП " + getSalary() + ";" +
                "Дата найма " + dateOfEmployment + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                patronymicName.equals(employee.patronymicName) &&
                surName.equals(employee.surName) &&
                department == employee.department &&
                salary.equals(employee.salary) &&
                dateOfEmployment.equals(employee.dateOfEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                firstName,
                patronymicName,
                surName,
                department,
                salary,
                dateOfEmployment);
    }
}
