package com.example.models;

import java.util.Date;

public class Organization extends Model {
    private String orgId;
    private String companyId;
    private String orgType;
    private int guestLimit;
    private String season;
    private String availability;
    private Date orgDate;
    private float price;

    @Override
    public String getTableName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTableName'");
    }

    // Getter and setters
}