package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import com.example.gui.components.TopBarPanel;

public abstract class MainFrame extends JFrame {
    JPanel mainPanel;
    JPanel topBarPanel;
    protected JPanel contentPanel;
    JLabel titleLabel;
    String username;

    public MainFrame(String username) {
        this.username = username;

        setIconImage(new ImageIcon("src/resources/images/icons/logo.png").getImage());

        setSize(576 * 2, 576);
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make the window rounded 30 pixels
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

        mainPanel = new JPanel(new BorderLayout());

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Theme.bgColor);
        contentPanel.setOpaque(true);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
        add(new TopBarPanel("Partea - Party Organizing System # " + username), BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
