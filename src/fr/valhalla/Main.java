package fr.valhalla;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mw4rf on 23/08/2016.
 */
public class Main {
    public static void main(String args[]) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {

        }

        // Create main frame
        JFrame app = new JFrame("VapeWizard");
        app.setContentPane(new MainFrame().appPanel);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();

        // Center on screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        app.setLocation(dim.width / 2 - app.getSize().width / 2, dim.height / 2 - app.getSize().height / 2);

        // Display
        app.setVisible(true);
    }
}
