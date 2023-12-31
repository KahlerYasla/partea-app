package com.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfferFrame extends JFrame {
    private JTable offerTable;
    private JButton buyButton;

    public OfferFrame() {
        setTitle("Party Offers");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        offerTable = new JTable();
        buyButton = new JButton("Buy Selected");

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Seçilen teklifleri satın alma işlemleri
            }
        });

        panel.add(new JScrollPane(offerTable));
        panel.add(buyButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
