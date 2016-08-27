package fr.valhalla;

import java.awt.color.ColorSpace;

/**
 * Created by mw4rf on 27/08/2016.
 */
public class Color extends java.awt.Color {

    // Red
    public static final Color FIREBRICK = new Color(178, 34, 34);
    public static final Color INDIAN_RED = new Color(176, 23, 31);
    public static final Color CRIMSON = new Color(220, 20, 60);
    // Red + Blue
    public static final Color PINK = new Color(255, 192, 203);
    public static final Color DEEP_PINK = new Color(255, 20, 147);
    public static final Color ORCHID = new Color(218, 112, 214);
    public static final Color DARK_ORCHID = new Color(139, 71, 137);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color DARK_MAGENTA = new Color(139, 0, 139);
    public static final Color INDIGO = new Color(75, 0, 130);
    public static final Color PURPLE = new Color(155, 48, 255);
    // Blue
    public static final Color SLATE_BLUE = new Color(106, 90, 205);
    public static final Color NAVY = new Color(0, 0, 128);
    public static final Color COBALT = new Color(61, 89, 171);
    public static final Color ROYAL_BLUE = new Color(65, 105, 225);
    public static final Color LIGHT_STEEL_BLUE = new Color(202, 225, 255);
    public static final Color STEEL_BLUE = new Color(70, 130, 180);
    public static final Color DODGER_BLUE = new Color(30, 144, 255);
    public static final Color SKY_BLUE = new Color(0, 191, 255);
    public static final Color DEEP_SKY_BLUE = new Color(0, 104, 139);
    // Blue + Green
    public static final Color TURQUOISE = new Color(0, 245, 255);
    public static final Color TEAL = new Color(0, 128, 128);
    // Green
    public static final Color AQUAMARINE = new Color(127, 255, 213);
    public static final Color EMERALD = new Color(0, 201, 87);
    public static final Color MINT = new Color(189, 252, 201);
    public static final Color COBALT_ALT = new Color(61, 145, 64);
    public static final Color OLIVE = new Color(162, 205, 90);
    // Yellow
    public static final Color KHAKI = new Color(255, 246, 143);
    public static final Color LIGHT_GOLD = new Color(255, 236, 139);
    public static final Color GOLD = new Color(255, 215, 0);
    public static final Color DARK_GOLD = new Color(205, 173, 0);
    // Orange
    public static final Color LIGHT_ORANGE = new Color(255, 165, 0);
    public static final Color DARK_ORANGE = new Color(205, 133, 0);
    public static final Color CORAIL = new Color(255, 114, 86);

    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Color(int rgb) {
        super(rgb);
    }

    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Color(float r, float g, float b) {
        super(r, g, b);
    }

    public Color(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Color(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }
}
