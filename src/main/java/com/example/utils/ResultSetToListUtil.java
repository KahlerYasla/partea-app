package com.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.*;

public class ResultSetToListUtil<T> {
    public static <T> List<T> convert(ResultSet rs, String ModelName) throws SQLException {
        System.out.println("ModelName: " + ModelName);

        switch (ModelName) {
            case "users":
                return (List<T>) convertUser(rs);
            // case "Material":
            // return (List<T>) convertMaterial(rs);
            // case "Organization":
            // return (List<T>) convertOrganization(rs);
            // case "Company":
            // return (List<T>) convertCompany(rs);
            // case "OwnedMaterial":
            // return (List<T>) convertOwnedMaterial(rs);
            default:
                return null;
        }
    }

    private static List<User> convertUser(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<User>();

        System.out.println("users:");

        // iterate through the result set
        while (rs.next()) {
            User user = new User();
            user.setSsn(rs.getString(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setOrgId(rs.getString(4));
            users.add(user);

            System.out.println("User: " + user.getFirstName());
        }

        return users;
    }

    // Todo: :( nolur kalanlarini yapin

}
