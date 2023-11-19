package org.example.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.ContactDatabase;

public class ContactDto {
    @JsonProperty("numberPhone")
    private String numberPhone;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;

    public ContactDto(ContactDatabase contactDatabase) {
        this.numberPhone = contactDatabase.getPhoneNumber();
        this.lastName = contactDatabase.getLastName();
        this.name = contactDatabase.getName();
        this.email = contactDatabase.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactDto() {
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
