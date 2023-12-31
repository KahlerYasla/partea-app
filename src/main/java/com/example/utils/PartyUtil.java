package com.example.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartyUtil {
    public static ResultSet getCompaniesByPartyType(Connection connection, String partyType) throws SQLException {
        String sql = "SELECT * FROM company WHERE cid IN (SELECT comp_id FROM organizations WHERE otype = ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, partyType);
            return statement.executeQuery();
        }
    }

    public static ResultSet getOfferedCompanies(Connection connection, String userSSN) throws SQLException {
        String sql = "SELECT * FROM company WHERE cid IN (SELECT comp_id FROM organizations WHERE oid IN " +
                "(SELECT oid FROM owned_metarials WHERE user_ssn = ?))";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userSSN);
            return statement.executeQuery();
        }
    }

    // Todo: Diğer veritabanı işlemleri burada yoruldum :D
}
