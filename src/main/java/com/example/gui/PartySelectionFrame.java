package com.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartySelectionFrame extends JFrame {
    private JComboBox<String> partyTypeComboBox;
    private JButton selectButton;

    public PartySelectionFrame() {
        setTitle("Select Party Type");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        partyTypeComboBox = new JComboBox<>(new String[] { "Birthday", "Engagement", "Other" });
        selectButton = new JButton("Select");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPartyType = (String) partyTypeComboBox.getSelectedItem();
                // Seçilen parti tipine göre işlemler
            }
        });

        panel.add(new JLabel("Select Party Type:"));
        panel.add(partyTypeComboBox);
        panel.add(selectButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
