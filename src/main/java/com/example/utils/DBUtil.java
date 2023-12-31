package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for interacting with the database.
 */
public class DBUtil {
    private static final String JDBC_URL = "postgres://wivjxdqt:DYPyvhk7-MW4Aw64DSpSRP5QQpn8grh3@dumbo.db.elephantsql.com/wivjxdqt ";
    private static final String USERNAME = "wivjxdqt";
    private static final String PASSWORD = "wivjxdqt";

    // ------------------------------------------------------------------------------------------------------------------------
    static {
        try {
            Class.forName("org.postgresql.Driver");
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
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database", e);
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------
    /**
     * Saves data to the database.
     * 
     * @param model  the name of the table to insert data into
     * @param fields an array of field names
     * @param values an array of corresponding field values
     */
    public static void saveToDB(String model, String[] fields, String[] values) {
        String query = "INSERT INTO " + model + " (";
        for (int i = 0; i < fields.length; i++) {
            query += fields[i];
            if (i != fields.length - 1) {
                query += ", ";
            }
        }
        query += ") VALUES (";
        for (int i = 0; i < values.length; i++) {
            query += "'" + values[i] + "'";
            if (i != values.length - 1) {
                query += ", ";
            }
        }
        query += ");";
        System.out.println(query);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    /**
     * Updates the specified database table with the given value for the specified
     * column.
     *
     * @param model the name of the database table
     * @param id    the name of the column to be updated
     * @param value the new value for the column
     */
    public static void updateDB(String model, String id, String value) {
        String query = "UPDATE " + model + " SET " + id + " = " + value + ";";
        System.out.println(query);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    /**
     * Deletes a record from the database table specified by the given model, using
     * the provided id and value.
     *
     * @param model the name of the database table
     * @param id    the name of the column used for identification
     * @param value the value of the identification column for the record to be
     *              deleted
     */
    public static void deleteFromDB(String model, String id, String value) {
        String query = "DELETE FROM " + model + " WHERE " + id + " = " + value + ";";
        System.out.println(query);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    /**
     * Executes a SELECT query on the database table specified by the given model,
     * filtering the results based on the provided id and value.
     *
     * @param model the name of the database table to query
     * @param id    the column name to filter on
     * @param value the value to match in the specified column
     */
    public static void selectFromDBWithId(String model, String id, String value) {
        String query = "SELECT * FROM " + model + " WHERE " + id + " = " + value + ";";
        System.out.println(query);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    /**
     * Executes a SELECT query on the specified database table.
     *
     * @param model the name of the database table to select from
     */
    public static void selectFromDBTable(String model) {
        String query = "SELECT * FROM " + model + ";";
        System.out.println(query);
    }

    // ------------------------------------------------------------------------------------------------------------------------

}
