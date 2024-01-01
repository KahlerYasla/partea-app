package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.models.Model;

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
            ColoredOutput.print("PostgreSQL JDBC Driver Registered!", ColoredOutput.Color.GREEN_BOLD_BRIGHT);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================
    /**
     * Returns a connection to the database.
     *
     * @return a Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public static void startConnection() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            ColoredOutput.print("Database connection is working.", ColoredOutput.Color.GREEN_BOLD_BRIGHT);
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

    // Repositories for generic CRUD operations on the database
    // ========================================================================================================================
    /**
     * Retrieves all records from the specified table in the database.
     *
     * @param modelName the name of the table to retrieve records from
     * @param <T>       the type of the objects in the resulting list
     * @return a list of objects representing the records from the table
     */
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

        ColoredOutput.print("Retrieved " + list.size() + " records from " + modelName + ".",
                ColoredOutput.Color.MAGENTA_BOLD_BRIGHT);

        return list;
    }

    // ------------------------------------------------------------------------------------------------------------------------
    // insert
    public static void insertToDB(Model object) {

        ColoredOutput.print("Inserting " + object.toString() + " to the table " + object.getTableName() + ".",
                ColoredOutput.Color.MAGENTA_BOLD_BRIGHT);

        String query = "INSERT INTO " + object.getTableName() + " VALUES (" + object.toString() + ");";

        // execute the query
        try {
            connection.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
