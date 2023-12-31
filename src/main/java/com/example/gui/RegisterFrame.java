package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        registerButton = new JButton("Register");

        // ImageIcon kullanarak bir ikon ekleyebilirsiniz (icon.png dosyasının varlığını
        // kontrol etmelisiniz).
        Icon registerIcon = UIManager.getIcon("FileView.floppyDriveIcon");
        registerButton.setIcon(registerIcon);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Register işlemleri
                JOptionPane.showMessageDialog(RegisterFrame.this, "Registration successful!");
                dispose();
            }
        });

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(registerButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
