package com.spodin.v.graphql.demo.clients;

import com.spodin.v.graphql.demo.common.model.Language;

public class ClientUpdate {

    private String email;
    private String firstName;
    private String lastName;
    private Language language;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ClientUpdate{" +
            "email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", language=" + language +
            '}';
    }
}
