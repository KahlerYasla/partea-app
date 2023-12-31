package com.example.gui.frames;

import javax.swing.*;

import com.example.gui.MainFrame;
import com.example.gui.Theme;
import com.example.gui.panels.OfferPanel;
import com.example.gui.panels.PartySelectionPanel;
import com.example.gui.panels.ShoppingCartPanel;
import com.example.gui.components.RoundedBorder;

import java.awt.*;

public class HomeFrame extends MainFrame {
    public HomeFrame(String username) {
        super(username);

        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));

        // #region Tabbed pane ---------------------------------------------
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(Theme.font);
        tabbedPane.setForeground(Color.white);
        tabbedPane.setBackground(Theme.bgColor);
        tabbedPane.setOpaque(true);
        tabbedPane.setPreferredSize(new Dimension(576, 576));

        tabbedPane.addTab("Party Selection", new PartySelectionPanel());
        tabbedPane.addTab("Cart", new ShoppingCartPanel());
        tabbedPane.addTab("Offer", new OfferPanel());
        tabbedPane.addTab("Logout", null);

        tabbedPane.setBackgroundAt(0, Theme.buttonColor);
        tabbedPane.setBackgroundAt(1, Theme.buttonColor);
        tabbedPane.setBackgroundAt(2, Theme.buttonColor);
        tabbedPane.setBackgroundAt(3, Theme.buttonColor);

        tabbedPane.setSelectedIndex(0);

        // when the user clicks on the logout tab, the program will return to the
        // authentication panel
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 3) {
                new AuthFrame();
                dispose();
            }
        });
        // #endregion Tabbed pane ------------------------------------------

        leftPanel.add(tabbedPane, BorderLayout.CENTER);

        leftPanel.setBackground(Theme.bgColor);
        leftPanel.setOpaque(true);

        leftPanel.setSize(new Dimension(576, 576));

        contentPanel.add(leftPanel, BorderLayout.WEST);

        // Create a label to display the image
        JLabel imageLabel = new JLabel(new ImageIcon("src/resources/images/side_pic.png"));

        contentPanel.add(imageLabel, BorderLayout.EAST);

        // Add some margin between the top bar and the content panel
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // --------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Example of how to use the MainFrame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeFrame("PyschoKillerXX42125");
            }
        });
    }
}
