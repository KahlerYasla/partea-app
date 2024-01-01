package com.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.*;

public class ResultSetToListUtil<T> {
    public static <Model> List<Model> convert(ResultSet rs, String ModelName) throws SQLException {

        switch (ModelName) {
            case "users":
                return (List<Model>) convertUser(rs);
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

    private static List<Users> convertUser(ResultSet rs) throws SQLException {
        List<Users> users = new ArrayList<Users>();

        // iterate through the result set
        while (rs.next()) {
            Users user = new Users();
            user.setSsn(rs.getString(1));
            user.setUserName(rs.getString(2));
            user.setOrgId(rs.getString(3));
            user.setPassword(rs.getString(4));
            users.add(user);
        }

        return users;
    }

    // Todo: :( nolur kalanlarini yapin

}
