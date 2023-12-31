package com.example;

import java.util.List;

import com.example.gui.LoginFrame;
import com.example.models.User;
import com.example.utils.DBUtil;

/**
 * The main class of the application.
 * This class contains the entry point of the application and handles the
 * database connection.
 */
public class App {
    public static void main(String[] args) {

        // Things to do before starting the application
        // --------------------------------------------------------------------

        // Start the connection to the database
        DBUtil.startConnection();

        // Test the database connection is working with a simple query of the user table
        List<User> users = DBUtil.selectAllFromDB("users");
        for (User user : users) {
            System.out.println(user.getFirstName());
        }

        // ---------------------------------------------------------------------
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

        // Things to do after the application is closed
        // --------------------------------------------------------------------
        DBUtil.closeConnection();
    }

    private static void createAndShowGUI() {
        // Uygulama arayüzünü oluştur
        LoginFrame mainFrame = new LoginFrame();
        mainFrame.setVisible(true);
    }
}
