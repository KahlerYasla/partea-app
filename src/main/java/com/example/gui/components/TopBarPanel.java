package com.example.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.example.gui.Theme;

public class TopBarPanel extends JPanel {
    private JLabel titleLabel;
    private JButton closeButton;
    private JButton resizeButton;

    public TopBarPanel(String title) {
        setLayout(new BorderLayout());
        setBackground(Theme.bgColor.darker());
        setOpaque(true);

        // set padding
        setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));

        titleLabel = new JLabel(title);
        titleLabel.setFont(Theme.font);
        titleLabel.setForeground(Color.white);

        ImageIcon closeIcon = new ImageIcon("src/resources/images/icons/quit.png", "quit");
        Image closeImage = closeIcon.getImage().getScaledInstance(12, 12, Image.SCALE_AREA_AVERAGING);
        closeButton = new JButton(new ImageIcon(closeImage));

        ImageIcon resizeIcon = new ImageIcon("src/resources/images/icons/resize.png", "resize");
        Image resizeImage = resizeIcon.getImage().getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING);
        resizeButton = new JButton(new ImageIcon(resizeImage));

        configureButton(closeButton);
        configureButton(resizeButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Theme.bgColor.darker());
        buttonPanel.setOpaque(true);

        buttonPanel.add(resizeButton);
        buttonPanel.add(closeButton);

        add(titleLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getTopLevelAncestor() instanceof JFrame) {
                    JFrame frame = (JFrame) getTopLevelAncestor();
                    // minimize the frame
                    frame.setState(Frame.ICONIFIED);
                }
            }
        });

        setVisible(true);
    }

    // --------------------------------------------------------------------------------------------------------------
    private void configureButton(JButton button) {
        button.setFont(Theme.font);
        button.setBackground(Theme.bgColor.darker());
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to the button
        button.setForeground(Color.white);
        button.setPreferredSize(new Dimension(25, 25));
    }
}
