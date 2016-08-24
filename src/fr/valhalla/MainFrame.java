package fr.valhalla;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created by mw4rf on 23/08/2016.
 */
public class MainFrame {
    private JTabbedPane tabbedPane1;
    public JPanel appPanel;
    private JPanel liquidPane;
    private JPanel coilPane;
    private JPanel basePane;
    private JPanel flavorPane;
    private JComboBox base1vgpg;
    private JPanel base1panel;
    private JComboBox base2vgpg;
    private JTextField base3percent;
    private JComboBox base3vgpg;
    private JTextField base3nicotine;
    private JSlider nicotine_slider;
    private JTextField target_nicotine;
    private JLabel desirednicotinelabel;
    private JLabel desiredvglabel;
    private JLabel desiredPGVGlabel;
    private JTextField target_quantity;
    private JTextField base1PG;
    private JTextField base1VG;
    private JTextField base2PG;
    private JTextField base2VG;
    private JTextField base1nico;
    private JLabel result_base1_ml;
    private JLabel result_base2_ml;
    private JLabel result_base1_percent;
    private JLabel result_base2_percent;
    private JLabel result_vgpg;
    private JTextField aroma1concentration;
    private JTextField aroma2concentration;
    private JTextField aroma3concentration;
    private JLabel result_aroma1_ml;
    private JLabel result_aroma2_ml;
    private JLabel result_aroma3_ml;
    private JLabel result_aroma1_drops;
    private JLabel result_aroma2_drops;
    private JLabel result_aroma3_drops;
    private JProgressBar pgvg_bar;
    private JLabel result_pg;
    private JLabel result_vg;

    public MainFrame() {

        // Set nicotine slider max value
        nicotine_slider.setMaximum(new Integer(base1nico.getText()));
        nicotine_slider.setValue(new Integer(target_nicotine.getText()));

        // Brew !
        brew();

        /**
         * Changes PG and VG labels according to slider movement.
         */
        nicotine_slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Integer val = nicotine_slider.getValue();
                target_nicotine.setText(val.toString());
                brew();
            }
        });

        /**
         * Base PG + Base VG = 100%
         * Automatically updates the VG when the PG changes.
         */
        base1PG.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                base1VG.setText(100 - new Integer(base1PG.getText()).intValue() + "");
                brew();
            }
        });
        base1VG.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                base1PG.setText(100 - new Integer(base1VG.getText()).intValue() + "");
                brew();
            }
        });
        base2PG.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                base2VG.setText(100 - new Integer(base2PG.getText()).intValue() + "");
                brew();
            }
        });
        base2VG.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                base2PG.setText(100 - new Integer(base2VG.getText()).intValue() + "");
                brew();
            }
        });

        base1nico.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // Change slider
                nicotine_slider.setMaximum(new Integer(base1nico.getText()));
                brew();
            }
        });
        target_quantity.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                brew();
            }
        });
        target_nicotine.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // Change slider
                if(new Integer(target_nicotine.getText()).intValue() <= new Integer(base1nico.getText()).intValue())
                    nicotine_slider.setValue(new Integer(target_nicotine.getText()));
                brew();
            }
        });
        aroma1concentration.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                brew();
            }
        });
        aroma2concentration.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                brew();
            }
        });
        aroma3concentration.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                brew();
            }
        });
    }

    /**
     * Rounds a DOUBLE to 2 decimals, returns a STRING representation.
     * @param d java.lang.Double
     * @return java.lang.String
     */
    private String round(double d) {
        return "" + Math.round(d * 100.0) / 100.0;
    }

    /**
     * Magic happens here !
     */
    public void brew() {
        // Check everything is setup
            // ok, later...

        // Create the liquid
        Liquid liquid = new Liquid();

        // Create the bases
        BaseLiquid base1 = new BaseLiquid(new Double(base1PG.getText()), new Double(base1VG.getText()), new Double(base1nico.getText()));
        BaseLiquid base2 = new BaseLiquid(new Double(base2PG.getText()), new Double(base2VG.getText()));

        // Add the bases
        liquid.addBase(base1);
        liquid.addBase(base2);

        // Create the aromas
        BaseLiquid aroma1 = new BaseLiquid(new Double(aroma1concentration.getText()));
        BaseLiquid aroma2 = new BaseLiquid(new Double(aroma2concentration.getText()));
        BaseLiquid aroma3 = new BaseLiquid(new Double(aroma3concentration.getText()));

        // Add the aromas
        liquid.addAroma(aroma1);
        liquid.addAroma(aroma2);
        liquid.addAroma(aroma3);

        // Brew
        liquid.brew(new Double(target_nicotine.getText()), new Double(target_quantity.getText()));

        // Update results
        result_base1_ml.setText(round(liquid.getBase(0).getQuantity()) + " ml");
        result_base2_ml.setText(round(liquid.getBase(1).getQuantity()) + " ml");
        result_base1_percent.setText(round(liquid.getBase(0).getConcentration()) + "%");
        result_base2_percent.setText(round(liquid.getBase(1).getConcentration()) + "%");
        result_aroma1_ml.setText(round(liquid.getAroma(0).getQuantity()) + " ml");
        result_aroma1_drops.setText(liquid.getAroma(0).getDrops() + "");
        result_aroma2_ml.setText(round(liquid.getAroma(1).getQuantity()) + " ml");
        result_aroma2_drops.setText(liquid.getAroma(1).getDrops() + "");
        result_aroma3_ml.setText(round(liquid.getAroma(2).getQuantity()) + " ml");
        result_aroma3_drops.setText(liquid.getAroma(2).getDrops() + "");
        result_pg.setText(round(liquid.getPG()) + "% PG");
        result_vg.setText(round(liquid.getVG()) + "% VG");
        pgvg_bar.setValue(liquid.getPG().intValue());
    }

}


