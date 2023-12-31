package com.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartFrame extends JFrame {
    private JTable cartTable;
    private JButton checkoutButton;

    public ShoppingCartFrame() {
        setTitle("Shopping Cart");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        cartTable = new JTable();
        checkoutButton = new JButton("Checkout");

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alışverişi tamamlama işlemleri
            }
        });

        panel.add(new JScrollPane(cartTable));
        panel.add(checkoutButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
