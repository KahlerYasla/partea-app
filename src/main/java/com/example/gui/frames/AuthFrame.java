package com.example.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import com.example.services.Authentication;
import com.example.gui.Theme;
import com.example.gui.components.TopBarPanel;
import com.example.utils.ColoredOutput;

public class AuthFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public AuthFrame() {

        ImageIcon myAppImage = new ImageIcon("src/resources/images/logo.png", "logo");
        if (myAppImage.getImage().getWidth(null) > 0) {
            setIconImage(myAppImage.getImage());
        } else {
            ColoredOutput.print("Could not find logo.png in src/resources/images/", ColoredOutput.Color.RED);
        }

        setUndecorated(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make the window rounded 30 pixels
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(Theme.bgColor);
        // Add padding to the panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        passwordField.setEchoChar('*');

        configureTextField(usernameField);
        configureTextField(passwordField);

        ImageIcon loginIcon = new ImageIcon("src/resources/images/icons/login.png", "Login");
        Image loginImage = loginIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        loginButton = new JButton("Login", new ImageIcon(loginImage));

        ImageIcon registerIcon = new ImageIcon("src/resources/images/icons/register.png", "Register");
        Image registerImage = registerIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        registerButton = new JButton("Register", new ImageIcon(registerImage));

        configureButton(loginButton);
        configureButton(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFieldsProperlySet())
                    return;

                if (Authentication.authenticate(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                    dispose();
                    new HomeFrame(usernameField.getText());
                } else {
                    JOptionPane.showMessageDialog(AuthFrame.this, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFieldsProperlySet())
                    return;

                try {
                    Authentication.register(usernameField.getText(), String.valueOf(passwordField.getPassword()));
                    JOptionPane.showMessageDialog(AuthFrame.this, "Registration successful!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(AuthFrame.this, exception.getMessage());
                }
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

        add(panel, BorderLayout.CENTER);
        add(new TopBarPanel("Partea"), BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // --------------------------------------------------------------------------------------------------------------
    private void configureButton(JButton button) {
        button.setFont(Theme.font);
        button.setBackground(Theme.buttonColor);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to the button
        button.setForeground(Color.white);
        button.setPreferredSize(new Dimension(200, 40));
    }

    private JLabel configureLabel(JLabel label) {
        label.setFont(Theme.font);
        label.setForeground(Color.white);
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
        textField.setForeground(Color.white);
        textField.setCaretColor(Color.white);
        textField.setPreferredSize(new Dimension(200, 40));
    }

    private boolean isFieldsProperlySet() {
        if (usernameField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(AuthFrame.this, "Username and password cannot be empty!");
            return false;
        } else if (usernameField.getText().length() < 3 || String.valueOf(passwordField.getPassword()).length() < 3) {
            JOptionPane.showMessageDialog(AuthFrame.this,
                    "Username and password must be at least 3 characters long!");
            return false;
        } else if (usernameField.getText().length() > 8 || String.valueOf(passwordField.getPassword()).length() > 8) {
            JOptionPane.showMessageDialog(AuthFrame.this,
                    "Username and password must be at most 8 characters long!");
            return false;
        }

        return true;
    }

    // --------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        new AuthFrame();
    }
}
