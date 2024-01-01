package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton partySelectionButton;
    private JButton offerButton;
    private JButton shoppingCartButton;
    private JButton logoutButton;

    public MainFrame(String username) {
        setTitle("Partea - Party Organizing System # " + username);
        setSize(576 * 2, 576);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold both the UI and the image
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a panel for the UI
        JPanel uiPanel = new JPanel(new GridLayout(4, 1, 10, 0));

        logoutButton = new JButton("Logout");
        logoutButton.setFont(Theme.font);
        logoutButton.setBackground(Theme.buttonColor);
        logoutButton.setOpaque(true);
        logoutButton.setBorderPainted(false);
        logoutButton.setForeground(Color.pink);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame();
            }
        });

        Icon partyIcon = new ImageIcon("party_icon.png");
        Icon offerIcon = new ImageIcon("offer_icon.png");
        Icon cartIcon = new ImageIcon("cart_icon.png");

        partySelectionButton = createButton("Select Party Type", partyIcon);
        offerButton = createButton("View Offers", offerIcon);
        shoppingCartButton = createButton("Shopping Cart", cartIcon);

        uiPanel.add(partySelectionButton);
        uiPanel.add(offerButton);
        uiPanel.add(shoppingCartButton);
        uiPanel.add(logoutButton);

        uiPanel.setBackground(Theme.bgColor);
        uiPanel.setOpaque(true);

        // border color purpleish blue only right side
        uiPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.pink));
        uiPanel.setSize(new Dimension(576, 576));

        mainPanel.add(uiPanel, BorderLayout.WEST);

        // Create a label to display the image
        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("SidePic.png")));
        mainPanel.add(imageLabel, BorderLayout.EAST);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(String text, Icon icon) {
        JButton button = new JButton(text, icon);
        button.setFont(Theme.font);
        button.setBackground(Theme.buttonColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setForeground(Color.pink);
        button.setPreferredSize(new Dimension(576, 576 / 4 - 10));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Button click actions
                if (text.equals("Select Party Type")) {
                    new PartySelectionFrame();
                } else if (text.equals("View Offers")) {
                    new OfferFrame();
                } else if (text.equals("Shopping Cart")) {
                    new ShoppingCartFrame();
                }
            }
        });

        return button;
    }

    public static void main(String[] args) {
        // Example of how to use the MainFrame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame("PyschoKillerXX42125");
            }
        });
    }
}
