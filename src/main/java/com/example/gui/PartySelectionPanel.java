package com.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.utils.PartyUtil;

public class PartySelectionPanel extends JPanel {
    private JComboBox<String> partyTypeComboBox;
    private JButton selectButton;
    private String[] partyTypes;

    public PartySelectionPanel() {
        partyTypes = PartyUtil.getPartyTypes();

        JPanel panel = new JPanel();
        panel.setBackground(Theme.bgColor);

        partyTypeComboBox = new JComboBox<>(partyTypes);
        partyTypeComboBox.setBackground(Theme.bgColor);
        partyTypeComboBox.setForeground(Theme.buttonColor);

        selectButton = new JButton("Select");
        selectButton.setBackground(Theme.buttonColor);
        selectButton.setForeground(Theme.bgColor);

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
        setVisible(true);
    }
}
