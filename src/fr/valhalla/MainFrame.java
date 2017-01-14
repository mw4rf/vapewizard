package fr.valhalla;

import fr.valhalla.coil.Coil;
import fr.valhalla.coil.OhmsLaw;
import fr.valhalla.coil.Wire;
import fr.valhalla.liquid.BaseLiquid;
import fr.valhalla.liquid.Liquid;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * Created by mw4rf on 23/08/2016.
 */
public class MainFrame {
    public JPanel appPanel;
    private JTabbedPane mainPane;
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
    private JTextField voltsField;
    private JTextField wattsField;
    private JTextField ampsField;
    private JTextField ohmsField;
    private JComboBox wireComboBox;
    private JLabel wireNameLabel;
    private JLabel wireResistanceLabel;
    private JLabel wireTCRLabel;
    private JLabel wireDensityLabel;
    private JTextField wireMMField;
    private JTextField wireAWGField;
    private JTextField coilNumberField;
    private JTextField coilInnerDiameterField;
    private JTextField coilLegLengthField;
    private JSlider coilTargetResistanceSlider;
    private JLabel coilTargetResistanceLabel;
    private JSpinner devicePowerSpinner;
    private JLabel coilWireLengthLabel;
    private JLabel coilWrapsNumberLabel;
    private JLabel coilHeatFluxLabel;
    private JTextField coilTargetResistanceField;
    private JTextField coilTargetPowerField;
    private JTextField coilTargetWrapsField;
    private JLabel coilResistanceLabel;
    private JSlider coilTargetPowerSlider;
    private JTextField base2Price;
    private JTextField base1Price;
    private JTextField aroma1Price;
    private JTextField aroma2Price;
    private JTextField aroma3Price;
    private JTextField base1PriceQuantity;
    private JTextField base2PriceQuantity;
    private JTextField aroma1PriceQuantity;
    private JTextField aroma2PriceQuantity;
    private JTextField aroma3PriceQuantity;
    private JLabel pricePerMLLabel;
    private JLabel priceTotalLabel;
    private JLabel coilVoltageLabel;
    private JLabel coilAmpsLabel;
    private JProgressBar heatFluxProgressBar;
    private JLabel copyrightLabel;
    private JLabel versionLabel;
    private JTabbedPane liquidPane;
    private JPanel classicLiquidPane;
    private JPanel boosterLiquidPane;
    private JTextField bdiy_inAroma;
    private JTextField bdiy_inVolume;
    private JTextField bdiy_inNicotine;
    private JTextField bdiy_inBooster;
    private JLabel bdiy_outAroma;
    private JLabel bdiy_outBooster;
    private JLabel bdiy_outBase;
    private JButton brewButton;
    private JSpinner coilTargetResistanceSpinner;

    public MainFrame() {

        // Set nicotine slider max value
        nicotine_slider.setMaximum(new Integer(base1nico.getText()));
        nicotine_slider.setValue(new Integer(target_nicotine.getText()));

        // Add coils to combobox
        DefaultComboBoxModel<Wire> wireComboModel = new DefaultComboBoxModel<Wire>();
        wireComboModel.addElement(new Wire(Wire.KANTHAL_A1_APM));
        wireComboModel.addElement(new Wire(Wire.KANTHAL_A_AE_AF));
        wireComboModel.addElement(new Wire(Wire.KANTHAL_D));
        wireComboModel.addElement(new Wire(Wire.SS_304));
        wireComboModel.addElement(new Wire(Wire.SS_316));
        wireComboModel.addElement(new Wire(Wire.SS_316L));
        wireComboModel.addElement(new Wire(Wire.SS_317L));
        wireComboModel.addElement(new Wire(Wire.SS_321));
        wireComboModel.addElement(new Wire(Wire.SS_430));
        wireComboModel.addElement(new Wire(Wire.NI200));
        wireComboModel.addElement(new Wire(Wire.NI200_lin));
        wireComboModel.addElement(new Wire(Wire.TITANIUM_1));
        wireComboModel.addElement(new Wire(Wire.TITANIUM_2));
        wireComboModel.addElement(new Wire(Wire.TITANIUM_READY));
        wireComboModel.addElement(new Wire(Wire.NICHROME_N20));
        wireComboModel.addElement(new Wire(Wire.NICHROME_N40));
        wireComboModel.addElement(new Wire(Wire.NICHROME_N60));
        wireComboModel.addElement(new Wire(Wire.NICHROME_N70));
        wireComboModel.addElement(new Wire(Wire.NICHROME_N80));
        wireComboModel.addElement(new Wire(Wire.NIFE30));
        wireComboModel.addElement(new Wire(Wire.NIFE_R));
        wireComboModel.addElement(new Wire(Wire.NIFE_S));
        wireComboModel.addElement(new Wire(Wire.COPPER));
        wireComboModel.addElement(new Wire(Wire.GOLD));
        wireComboModel.addElement(new Wire(Wire.INVAR36));
        wireComboModel.addElement(new Wire(Wire.NFT52));
        wireComboModel.addElement(new Wire(Wire.NFT70));
        wireComboModel.addElement(new Wire(Wire.NIDH));
        wireComboModel.addElement(new Wire(Wire.NIOBIUM));
        wireComboModel.addElement(new Wire(Wire.SILVER));
        wireComboModel.addElement(new Wire(Wire.TUNGSTEN));
        wireComboBox.setModel(wireComboModel);

        Wire w = (Wire) wireComboBox.getSelectedItem();
        wireNameLabel.setText(w.getName());
        wireDensityLabel.setText(w.getDensity().toString());
        wireResistanceLabel.setText(w.getResistivity().toString());
        wireTCRLabel.setText(w.getTCR().toString());


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
                if (new Integer(target_nicotine.getText()).intValue() <= new Integer(base1nico.getText()).intValue())
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

        /**
         * Omh's Law Calculations
         */
        FocusAdapter ohmslistener = new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                try {
                    Double.parseDouble(ohmsField.getText());
                } catch (NumberFormatException ex) {
                    ohmsField.setText("0.00");
                }

                try {
                    Double.parseDouble(wattsField.getText());
                } catch (NumberFormatException ex) {
                    wattsField.setText("0.00");
                }

                try {
                    Double.parseDouble(ampsField.getText());
                } catch (NumberFormatException ex) {
                    ampsField.setText("0.00");
                }

                try {
                    Double.parseDouble(voltsField.getText());
                } catch (NumberFormatException ex) {
                    voltsField.setText("0.00");
                }

                ohmslaw();
            }
        };
        ohmsField.addFocusListener(ohmslistener);
        voltsField.addFocusListener(ohmslistener);
        ampsField.addFocusListener(ohmslistener);
        wattsField.addFocusListener(ohmslistener);

        /**
         * Wire combo selection change
         */
        wireComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Wire w = (Wire) wireComboBox.getSelectedItem();
                wireNameLabel.setText(w.getName());
                wireDensityLabel.setText(w.getDensity().toString());
                wireResistanceLabel.setText(w.getResistivity().toString());
                wireTCRLabel.setText(w.getTCR().toString());
            }
        });

        // Compute wire diameter
        wireMMField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                //Wire w = new Wire(new Double(wireMMField.getText()), Wire.METRIC);
                //wireAWGField.setText(w.getAWG().toString());
            }
        });
        wireAWGField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Wire w = new Wire(new Double(wireAWGField.getText()), Wire.AWG);
                BigDecimal bd = new BigDecimal(w.getDiameter());
                bd = bd.setScale(2, RoundingMode.HALF_UP); // round
                wireMMField.setText(bd.toString());
            }
        });


        coilTargetResistanceField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                coil(true);
            }
        });
        coilTargetWrapsField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                coil(false);
            }
        });
        coilTargetPowerField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                coilTargetPowerSlider.setValue(new Double(coilTargetPowerField.getText()).intValue());
                coil(true);
            }
        });
        coilTargetPowerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                coilTargetPowerField.setText("" + coilTargetPowerSlider.getValue());
                coil(true);
            }
        });

        // Set default tab
        liquidPane.setSelectedIndex(1);


        // Brew !
        brew();
        // Coil !
        coil(true);

        // Copyright
        copyrightLabel.setText("Copyright (c) 2015-" + Calendar.getInstance().get(Calendar.YEAR) + " Guillaume Florimond");
        versionLabel.setText("Version " + Main.VERSION);

        brewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brew_booster();
            }
        });
    }

    /**
     * Rounds a DOUBLE to 2 decimals, returns a STRING representation.
     *
     * @param d java.lang.Double
     * @return java.lang.String
     */
    private String round(double d) {
        return "" + Math.round(d * 100.0) / 100.0;
    }

    public void coil(boolean known_resistance) {
        // Check everything is setup
        // ok, later...

        // Get user data
        Integer coils = new Integer(coilNumberField.getText());

        // Get user data, wanted resistance and/or number of wraps.
        Double target_resistance = 0.0;
        Double target_wraps = 0.0;

        if (known_resistance)
            target_resistance = new Double(coilTargetResistanceField.getText());
        else
            target_wraps = new Double(coilTargetWrapsField.getText());


        // Create the coil
        Coil coil = new Coil();

        // Add the wire
        Wire w = new Wire(wireComboBox.getSelectedItem().toString(), new Double(wireMMField.getText()), Wire.METRIC);
        coil.setWire(w);

        // Coil setup
        coil.setInnerDiameter(new Double(coilInnerDiameterField.getText()));
        coil.setLegLength(new Double(coilLegLengthField.getText()));

        // Get wraps for target resistance
        if (known_resistance) {
            BigDecimal bd = new BigDecimal(coil.getWraps(target_resistance));
            bd = bd.setScale(2, RoundingMode.HALF_UP); // round
            coilTargetWrapsField.setText(bd.toString());
            target_wraps = bd.doubleValue();
        } else {
            BigDecimal bd = new BigDecimal(coil.getResistance(target_wraps));
            bd = bd.setScale(2, RoundingMode.HALF_UP); // round
            coilTargetResistanceField.setText(bd.toString());
            target_resistance = bd.doubleValue();
        }

        // Wraps & resistance
        coilResistanceLabel.setText(target_resistance + " Ω");
        coilWrapsNumberLabel.setText(target_wraps.toString());

        // Wire & Coil length
        coilWireLengthLabel.setText(new BigDecimal(coil.getLength(target_wraps)).setScale(2, RoundingMode.HALF_UP).toString() + " mm");

        // Power Related Values
        try {
            // Heat Flux
            Double watts = new Double(coilTargetPowerField.getText());
            Double heatflux = coil.getHeatFlux(watts, coils, target_wraps) * 1000; // *1000 for display, mW instead of Watts
            coilHeatFluxLabel.setText(new BigDecimal(heatflux).setScale(2, RoundingMode.HALF_UP).toString() + " mW/mm²");
            heatFluxProgressBar.setValue(new BigDecimal(heatflux).intValue());
            heatFluxProgressBar.setUI(new BasicProgressBarUI() {
                protected Color getSelectionBackground() {
                    return Color.WHITE;
                }

                protected Color getSelectionForeground() {
                    return Color.WHITE;
                }
            });
            // Set label color
            if (heatflux < 60) {
                heatFluxProgressBar.setString("Freezing");
                heatFluxProgressBar.setBackground(Color.LIGHT_STEEL_BLUE);
                heatFluxProgressBar.setForeground(Color.LIGHT_STEEL_BLUE);
                heatFluxProgressBar.setUI(new BasicProgressBarUI() {
                    protected Color getSelectionBackground() {
                        return Color.BLACK;
                    }

                    protected Color getSelectionForeground() {
                        return Color.BLACK;
                    }
                });
            } else if (heatflux < 100) {
                heatFluxProgressBar.setString("Very Cold");
                heatFluxProgressBar.setBackground(Color.SLATE_BLUE);
                heatFluxProgressBar.setForeground(Color.SLATE_BLUE);
            } else if (heatflux < 140) {
                heatFluxProgressBar.setString("Colder");
                heatFluxProgressBar.setBackground(Color.STEEL_BLUE);
                heatFluxProgressBar.setForeground(Color.STEEL_BLUE);
            } else if (heatflux < 180) {
                heatFluxProgressBar.setString("Cold");
                heatFluxProgressBar.setBackground(Color.DODGER_BLUE);
                heatFluxProgressBar.setForeground(Color.DODGER_BLUE);
            } else if (heatflux < 220) {
                heatFluxProgressBar.setString("A bit cold");
                heatFluxProgressBar.setBackground(Color.TEAL);
                heatFluxProgressBar.setForeground(Color.TEAL);
            } else if (heatflux < 260) {
                heatFluxProgressBar.setString("A bit warm");
                heatFluxProgressBar.setBackground(Color.EMERALD);
                heatFluxProgressBar.setForeground(Color.EMERALD);
            } else if (heatflux < 300) {
                heatFluxProgressBar.setString("Warm");
                heatFluxProgressBar.setBackground(Color.LIGHT_GOLD);
                heatFluxProgressBar.setForeground(Color.LIGHT_GOLD);
                heatFluxProgressBar.setUI(new BasicProgressBarUI() {
                    protected Color getSelectionBackground() {
                        return Color.BLACK;
                    }

                    protected Color getSelectionForeground() {
                        return Color.BLACK;
                    }
                });
            } else if (heatflux < 350) {
                heatFluxProgressBar.setString("Warmer");
                heatFluxProgressBar.setBackground(Color.DARK_GOLD);
                heatFluxProgressBar.setForeground(Color.DARK_GOLD);
                heatFluxProgressBar.setUI(new BasicProgressBarUI() {
                    protected Color getSelectionBackground() {
                        return Color.BLACK;
                    }

                    protected Color getSelectionForeground() {
                        return Color.BLACK;
                    }
                });
            } else if (heatflux < 400) {
                heatFluxProgressBar.setString("A bit hot");
                heatFluxProgressBar.setBackground(Color.LIGHT_ORANGE);
                heatFluxProgressBar.setForeground(Color.LIGHT_ORANGE);
            } else if (heatflux < 450) {
                heatFluxProgressBar.setString("Hot");
                heatFluxProgressBar.setBackground(Color.DARK_ORANGE);
                heatFluxProgressBar.setForeground(Color.DARK_ORANGE);
            } else if (heatflux < 550) {
                heatFluxProgressBar.setString("Very Hot");
                heatFluxProgressBar.setBackground(Color.CRIMSON);
                heatFluxProgressBar.setForeground(Color.CRIMSON);
            } else {
                heatFluxProgressBar.setString("Burning!");
                heatFluxProgressBar.setBackground(Color.FIREBRICK);
                heatFluxProgressBar.setForeground(Color.FIREBRICK);
            }

            // Voltage
            coilVoltageLabel.setText(OhmsLaw.round(new OhmsLaw(target_resistance.toString(), "0", coilTargetPowerField.getText(), "0").getVolts()).toString());

            // Amps
            coilAmpsLabel.setText(OhmsLaw.round(new OhmsLaw("0", coilVoltageLabel.getText(), coilTargetPowerField.getText(), "0").getAmps()).toString());

        } catch (NumberFormatException e) {
            // Power is not set, then do nothing.
        }

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



        // Create the aromas
        BaseLiquid aroma1 = new BaseLiquid(new Double(aroma1concentration.getText()));
        BaseLiquid aroma2 = new BaseLiquid(new Double(aroma2concentration.getText()));
        BaseLiquid aroma3 = new BaseLiquid(new Double(aroma3concentration.getText()));

        // Set the prices, if needed
        base1.setPricePerML(new Double(base1Price.getText()), new Double(base1PriceQuantity.getText()));
        base2.setPricePerML(new Double(base2Price.getText()), new Double(base2PriceQuantity.getText()));
        aroma1.setPricePerML(new Double(aroma1Price.getText()), new Double(aroma1PriceQuantity.getText()));
        aroma2.setPricePerML(new Double(aroma2Price.getText()), new Double(aroma2PriceQuantity.getText()));
        aroma3.setPricePerML(new Double(aroma3Price.getText()), new Double(aroma3PriceQuantity.getText()));

        // Add the bases
        liquid.addBase(base1);
        liquid.addBase(base2);

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
        pricePerMLLabel.setText(new BigDecimal(liquid.getPricePerML()).setScale(2, RoundingMode.HALF_UP).toString());
        priceTotalLabel.setText(new BigDecimal(liquid.getPrice()).setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void ohmslaw() {
        BigDecimal R = new BigDecimal(ohmsField.getText());
        BigDecimal I = new BigDecimal(ampsField.getText());
        BigDecimal P = new BigDecimal(wattsField.getText());
        BigDecimal E = new BigDecimal(voltsField.getText());

        OhmsLaw law = new OhmsLaw(R, E, P, I);

        ohmsField.setText(OhmsLaw.round(law.getOhms()).toString());
        ampsField.setText(OhmsLaw.round(law.getAmps()).toString());
        wattsField.setText(OhmsLaw.round(law.getWatts()).toString());
        voltsField.setText(OhmsLaw.round(law.getVolts()).toString());
    }

    public void brew_booster() {
        /** Get user data */
        Double inAroma = new Double(bdiy_inAroma.getText());
        Double inVolume = new Double(bdiy_inVolume.getText());
        Double inNicotine = new Double(bdiy_inNicotine.getText());
        Double inBooster = new Double(bdiy_inBooster.getText());

        /** Compute */
        Double outAroma = inAroma * inVolume / 100;
        Double outBooster = inVolume * inNicotine / inBooster;
        Double outBase = inVolume - (outAroma + outBooster);

        /** Display */
        bdiy_outAroma.setText(outAroma.toString());
        bdiy_outBooster.setText(outBooster.toString());
        bdiy_outBase.setText(outBase.toString());
    }

}


