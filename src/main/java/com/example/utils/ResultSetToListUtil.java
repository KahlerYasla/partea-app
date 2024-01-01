package com.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.*;
import com.example.utils.ColoredOutput;

public class ResultSetToListUtil {
    public static <Model> List<Model> convert(ResultSet rs, String ModelName) throws SQLException {

        switch (ModelName) {
            case "users":
                return (List<Model>) convertUser(rs);
            case "materials":
                return (List<Model>) convertMaterial(rs);
            case "organizations":
                return (List<Model>) convertOrganization(rs);
            case "companies":
                return (List<Model>) convertCompany(rs);
            case "owned_materials":
                return (List<Model>) convertOwnedMaterial(rs);
            default:
                return null;
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------
    private static List<User> convertUser(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<User>();

        // iterate through the result set
        while (rs.next()) {
            User user = new User();
            user.setSsn(rs.getString(1));
            user.setUserName(rs.getString(2));
            user.setOrgId(rs.getString(3));
            user.setPassword(rs.getString(4));
            users.add(user);
        }

        return users;
    }

    // ------------------------------------------------------------------------------------------------------------------------
    private static List<Material> convertMaterial(ResultSet rs) throws SQLException {
        List<Material> materials = new ArrayList<Material>();

        // iterate through the result set
        while (rs.next()) {
            Material material = new Material();
            material.setMaterialId(rs.getString(1));
            material.setCompanyId(rs.getString(2));
            material.setMaterialType(rs.getString(3));
            material.setBarcode(rs.getString(4));
            material.setPrice(rs.getFloat(5));
            materials.add(material);
        }

        return materials;
    }

    // ------------------------------------------------------------------------------------------------------------------------
    private static List<Organization> convertOrganization(ResultSet rs) throws SQLException {
        List<Organization> organizations = new ArrayList<Organization>();

        // iterate through the result set
        while (rs.next()) {
            Organization organization = new Organization();
            organization.setOrgId(rs.getString(1));

            organization.setCompanyId(rs.getString(2));
            organization.setOrgType(rs.getString(3));
            organization.setGuestLimit(rs.getInt(4));
            organization.setSeason(rs.getString(5));
            organization.setAvailability(rs.getString(6));
            organization.setOrgDate(rs.getDate(7));
            organization.setPrice(rs.getFloat(8));
            organizations.add(organization);
        }

        return organizations;
    }

    // ------------------------------------------------------------------------------------------------------------------------
    private static List<Company> convertCompany(ResultSet rs) throws SQLException {
        List<Company> companies = new ArrayList<Company>();

        // iterate through the result set
        while (rs.next()) {
            Company company = new Company();
            company.setCompanyId(rs.getString(1));
            company.setCompanyName(rs.getString(2));
            companies.add(company);
        }

        return companies;
    }

    // ------------------------------------------------------------------------------------------------------------------------
    private static List<OwnedMaterial> convertOwnedMaterial(ResultSet rs) throws SQLException {
        List<OwnedMaterial> ownedMaterials = new ArrayList<OwnedMaterial>();

        // iterate through the result set
        while (rs.next()) {
            OwnedMaterial ownedMaterial = new OwnedMaterial();
            ownedMaterial.setMaterialId(rs.getString(1));
            ownedMaterial.setUserSsn(rs.getString(2));
            ownedMaterials.add(ownedMaterial);
        }

        return ownedMaterials;
    }
}
