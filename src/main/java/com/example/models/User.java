package com.example.models;

public class User {
    private String ssn;
    private String firstName;
    private String lastName;
    private String orgId;

    // Getter and setters
    String getSsn() {
        return ssn;
    }

    void setSsn(String ssn) {
        this.ssn = ssn;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getOrgId() {
        return orgId;
    }

    void saveToDB() {
        // Save user to database using DBUtil class

    }
}