package com.example;

import com.example.gui.LoginFrame;
import com.example.utils.DBUtil;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The main class of the application.
 * This class contains the entry point of the application and handles the
 * database connection.
 */
public class App {
    public static void main(String[] args) {
        // Connection connection = null;

        // // Things to do before starting the application
        // // --------------------------------------------------------------------

        // // Start the connection to the database
        // connection = DBUtil.getConnection();

        // // Test if the database connection is working
        // DBUtil.selectFromDBTable("users");
        // // ---------------------------------------------------------------------
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
        // public void run() {
        // createAndShowGUI();
        // }
        // });

        // // Things to do after the application is closed
        // // --------------------------------------------------------------------
        // connection.close();

        final String JDBC_URL = "jdbc:postgresql://dumbo.db.elephantsql.com/wivjxdqt";
        final String USERNAME = "wivjxdqt";
        final String PASSWORD = "DYPyvhk7-MW4Aw64DSpSRP5QQpn8grh3";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            String query = "SELECT * FROM users";
            ResultSet rs = connection.createStatement().executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createAndShowGUI() {
        // Uygulama arayüzünü oluştur
        LoginFrame mainFrame = new LoginFrame();
        mainFrame.setVisible(true);
    }
}
