package com.example.doric7.models;

import java.io.Serializable;

/**
 * Represents base class for all classes that stores data about employees.
 * It handles their first name and last name.
 */
abstract public class Person implements Serializable {
    Integer id;
    String firstName;
    String lastName;

    Person(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
