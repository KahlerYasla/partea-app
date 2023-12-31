package com.example;

import com.example.gui.LoginFrame;

public class App {
    public static void main(String[] args) {
        // Uygulama başladığında yapılacak işlemler
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Uygulama arayüzünü oluştur
        LoginFrame mainFrame = new LoginFrame();
        mainFrame.setVisible(true);
    }
}
