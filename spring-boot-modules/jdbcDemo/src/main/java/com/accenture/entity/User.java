package com.accenture.entity;


import java.time.LocalDate;

public class User {

    private int id;
    private String firstName;
    private String email;
    private int age;
    private LocalDate bday;

    public User(int id, String firstName, String email, int age,LocalDate bday) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.age = age;
        this.bday= bday;
    }

    public User(String firstName, String email, int age,LocalDate bday) {
        this.firstName = firstName;
        this.email = email;
        this.age = age;
        this.bday= bday;
    }

    public User() {
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", bday=" + bday +
                "}\n";
    }
}
