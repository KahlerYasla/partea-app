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
        return "organizations";
    }

    @Override
    public String toString() {
        return "\'" + availability + "," + companyId + "," + guestLimit + "," + orgDate + "," + orgId + "," + orgType
                + "," + price + "," + season + "\'";
    }

    // #region Getters and Setters --------------------------------------------
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public int getGuestLimit() {
        return guestLimit;
    }

    public void setGuestLimit(int guestLimit) {
        this.guestLimit = guestLimit;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Date getOrgDate() {
        return orgDate;
    }

    public void setOrgDate(Date orgDate) {
        this.orgDate = orgDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    // #endregion -------------------------------------------------------------
}