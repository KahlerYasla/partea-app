package com.example.gui;

import javax.swing.*;
import java.awt.*;

public abstract class MainFrame extends JFrame {
    JPanel mainPanel;
    JPanel topBarPanel;
    JPanel contentPanel;
    JLabel titleLabel;
    String username;

    public MainFrame(String username) {
        this.username = username;

        setTitle("Partea - Party Organizing System #" + username);
        setSize(576 * 2, 576);
        setResizable(false);
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.black);
        contentPanel.setOpaque(true);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
