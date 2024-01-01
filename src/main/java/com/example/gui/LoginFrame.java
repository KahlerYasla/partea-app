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
        setTitle("Partea - Party Organizing System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(Theme.bgColor);
        // Add padding to the panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        configureTextField(usernameField);
        configureTextField(passwordField);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        configureButton(loginButton);
        configureButton(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // print username and password
                ColoredOutput.print(usernameField.getText() + " " + String.valueOf(passwordField.getPassword()),
                        ColoredOutput.Color.YELLOW_BOLD_BRIGHT);

                if (Authentication.authenticate(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                    new MainFrame(usernameField.getText());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the register frame
                new RegisterFrame();
            }
        });

        panel.add(configureLabel(new JLabel("Username:")));
        panel.add(usernameField);
        panel.add(configureLabel(new JLabel("Password:")));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        // Center align the panel within the frame
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configureButton(JButton button) {
        button.setFont(Theme.font);
        button.setBackground(Theme.buttonColor);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to the button
        button.setForeground(Color.pink);
        button.setPreferredSize(new Dimension(200, 40));
    }

    private JLabel configureLabel(JLabel label) {
        label.setFont(Theme.font);
        label.setForeground(Color.pink);
        label.setBackground(Theme.bgColor);
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(100, 40));
        // Add padding to the label
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        return label;
    }

    private void configureTextField(JTextField textField) {
        textField.setFont(Theme.font);
        textField.setBackground(Theme.buttonColor);
        textField.setOpaque(true);
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to the text field
        textField.setForeground(Color.pink);
        textField.setPreferredSize(new Dimension(200, 40));
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
