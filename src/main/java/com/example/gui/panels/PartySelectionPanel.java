package com.example.gui.panels;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.gui.Theme;
import com.example.utils.PartyUtil;

public class PartySelectionPanel extends JPanel {
    private JComboBox<String> partyTypeComboBox;
    private JSlider priceRangeSlider;
    private String selectedPartyType;
    private String[] partyTypes;

    public PartySelectionPanel() {
        partyTypes = PartyUtil.getPartyTypes();

        JPanel panel = new JPanel();
        panel.setBackground(Theme.bgColor);

        partyTypeComboBox = new JComboBox<>(partyTypes);
        partyTypeComboBox.setBackground(Theme.bgColor);
        partyTypeComboBox.setFont(Theme.font);
        partyTypeComboBox.setEditable(true);

        partyTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPartyType = (String) partyTypeComboBox.getSelectedItem();
            }
        });

        JLabel label = new JLabel("Party Type:");
        label.setForeground(Color.WHITE);

        panel.add(label);
        panel.add(partyTypeComboBox);

        // Price Range Slider
        priceRangeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        priceRangeSlider.setBackground(Theme.bgColor);
        priceRangeSlider.setPaintTicks(true);
        priceRangeSlider.setPaintLabels(true);
        priceRangeSlider.setFont(Theme.font);
        priceRangeSlider.setForeground(Color.WHITE);
        priceRangeSlider.setMajorTickSpacing(25);
        priceRangeSlider.setMinorTickSpacing(5);
        priceRangeSlider.setPaintLabels(true);

        panel.add(priceRangeSlider);

        add(panel);
        setVisible(true);
        setBackground(Theme.bgColor);
    }
}
