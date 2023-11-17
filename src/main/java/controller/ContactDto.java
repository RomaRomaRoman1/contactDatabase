package controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.ContactDatabase;

public class ContactDto {
    @JsonProperty("numberPhone")
    private int numberPhone;
    @JsonProperty("lastName")
    private String lastName;

    public ContactDto(ContactDatabase contactDatabase) {
        this.numberPhone = contactDatabase.getPhoneNumber();
        this.lastName = contactDatabase.getLastName();
    }

    public ContactDto() {
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
