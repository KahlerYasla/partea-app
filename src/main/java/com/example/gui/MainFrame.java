package com.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton partySelectionButton;
    private JButton offerButton;
    private JButton shoppingCartButton;

    public MainFrame() {
        setTitle("Partea App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        partySelectionButton = new JButton("Select Party Type");
        offerButton = new JButton("View Offers");
        shoppingCartButton = new JButton("Shopping Cart");

        partySelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartySelectionFrame();
            }
        });

        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OfferFrame();
            }
        });

        shoppingCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShoppingCartFrame();
            }
        });

        panel.add(partySelectionButton);
        panel.add(offerButton);
        panel.add(shoppingCartButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
