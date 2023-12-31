package com.example.gui;

import javax.swing.*;
import java.awt.*;
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
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // Grid layout eklenerek düzen iyileştirildi

        Icon partyIcon = UIManager.getIcon("Tree.closedIcon");
        Icon offerIcon = UIManager.getIcon("FileView.computerIcon");
        Icon cartIcon = UIManager.getIcon("FileView.computerIcon");

        partySelectionButton = createButton("Select Party Type", partyIcon);
        offerButton = createButton("View Offers", offerIcon);
        shoppingCartButton = createButton("Shopping Cart", cartIcon);

        panel.add(partySelectionButton);
        panel.add(offerButton);
        panel.add(shoppingCartButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(String text, Icon icon) {
        JButton button = new JButton(text, icon);
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Font ayarları eklendi

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Butonlara tıklandığında yapılacak işlemler
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
}
