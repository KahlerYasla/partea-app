package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.services.Authentication;
import com.example.utils.ColoredOutput;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        Icon loginIcon = UIManager.getIcon("FileView.computerIcon");
        Icon registerIcon = UIManager.getIcon("FileView.floppyDriveIcon");

        loginButton.setIcon(loginIcon);
        registerButton.setIcon(registerIcon);
        // ------------------------------------------------------------------------------
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // print username and password
                ColoredOutput.print(usernameField.getText() + " " + String.valueOf(passwordField.getPassword()),
                        ColoredOutput.Color.YELLOW_BOLD_BRIGHT);

                if (Authentication.authenticate(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {

                    new MainFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
                }
            }
        });
        // ------------------------------------------------------------------------------
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the register frame
                new RegisterFrame();
            }
        });
        // ------------------------------------------------------------------------------
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
