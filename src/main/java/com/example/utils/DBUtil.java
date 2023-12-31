package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Utility class for interacting with the database.
 */
public class DBUtil {
    private static Connection connection = null;

    private static final String JDBC_URL = "jdbc:postgresql://dumbo.db.elephantsql.com/wivjxdqt";
    private static final String USERNAME = "wivjxdqt";
    private static final String PASSWORD = "DYPyvhk7-MW4Aw64DSpSRP5QQpn8grh3";

    // ------------------------------------------------------------------------------------------------------------------------
    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------
    /**
     * Returns a connection to the database.
     *
     * @return a Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public static void startConnection() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------
    public static <T> List<T> selectAllFromDB(String modelName) {
        String query = "SELECT * FROM " + modelName + ";";

        // execute the query
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<T> list = null;

        // convert the result set to a list of objects
        try {
            list = ResultSetToListUtil.convert(rs, modelName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ------------------------------------------------------------------------------------------------------------------------

}
