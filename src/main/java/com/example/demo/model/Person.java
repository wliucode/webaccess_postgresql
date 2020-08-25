package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;

    //@NotBlank not working
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("first name") String firstName,
                  @JsonProperty("last name") String lastName,
                  @JsonProperty("email") String email,
                  @JsonProperty("password") String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
