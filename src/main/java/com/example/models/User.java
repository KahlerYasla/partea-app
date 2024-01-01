package com.example.models;

public class User extends Model {
    private String ssn;
    private String userName;
    private String orgId;
    private String password;

    // Getter and setters
    // ===============================================================================
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    // --------------------------------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // --------------------------------------------------------------------------------
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    // --------------------------------------------------------------------------------
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ===============================================================================
    @Override
    public String getTableName() {
        return "users";
    }

    // --------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\'" + ssn + "\', \'" + userName + "\', \'" + orgId + "\', \'" + password + "\'";
    }
}