package fr.valhalla.coil;

/**
 * Created by mw4rf on 26/08/2016.
 */
public class Wire {

    public static final String KANTHAL_A1_APM = "Kanthal A1/APM";
    public static final String KANTHAL_A_AE_AF = "Kanthal A/AE/AF";
    public static final String KANTHAL_D = "Kanthal D";
    public static final String NICHROME_N20 = "Nichrome N20";
    public static final String NICHROME_N40 = "Nichrome N40";
    public static final String NICHROME_N60 = "Nichrome N60";
    public static final String NICHROME_N70 = "Nichrome N70";
    public static final String NICHROME_N80 = "Nichrome N80";
    public static final String SS_304 = "Stainless Steel 304";
    public static final String SS_316 = "Stainless Steel 316";
    public static final String SS_316L = "Stainless Steel 316 Elite";
    public static final String SS_317L = "Stainless Steel 317 L / Haywire";
    public static final String SS_321 = "Stainless Steel 321";
    public static final String SS_430 = "Stainless Steel 430";
    public static final String GOLD = "Gold";
    public static final String SILVER = "Silver";
    public static final String COPPER = "Copper";
    public static final String TITANIUM_1 = "Titanium 1";
    public static final String TITANIUM_2 = "Titanium 2";
    public static final String TITANIUM_READY = "TItanium Readu (e-SG)";
    public static final String TUNGSTEN = "Tungsten";
    public static final String NIOBIUM = "Niobium Alloy";
    public static final String NI200_lin = "Nickel 200 Linear";
    public static final String NI200 = "Nickel 200";
    public static final String NIFE30 = "NiFe30 Dicodes";
    public static final String NIFE_R = "NiFe Reactor";
    public static final String NIFE_S = "NiFe Stealth";
    public static final String INVAR36 = "Invar 36";
    public static final String NIDH = "Nickel DH";
    public static final String NFT70 = "Nifethal 70";
    public static final String NFT52 = "Nifethal 52";

    private String NAME;
    private Double RESISTANCE;
    private Double TCR;
    private Double DENSITY;

    public Wire(String wire_name) {
        NAME = wire_name;

        switch(wire_name) {

            case(KANTHAL_A1_APM):
                RESISTANCE = 1.45;
                TCR = 0.46;
                DENSITY = 7.1;
                break;

            case(KANTHAL_A_AE_AF):
                RESISTANCE = 1.39;
                TCR = 0.4625;
                DENSITY = 7.15;
                break;

            case(KANTHAL_D):
                RESISTANCE = 1.35;
                TCR = 0.465;
                DENSITY = 7.25;
                break;

            case(NICHROME_N20):
                RESISTANCE = 0.95;
                TCR = 0.447;
                DENSITY = 8.7;
                break;

            case(NICHROME_N40):
                RESISTANCE = 1.04;
                TCR = 0.447;
                DENSITY = 8.6;
                break;

            case(NICHROME_N60):
                RESISTANCE = 1.11;
                TCR = 0.447;
                DENSITY = 8.5;
                break;

            case(NICHROME_N70):
                RESISTANCE = 1.18;
                TCR = 0.447;
                DENSITY = 8.4;
                break;

            case(NICHROME_N80):
                RESISTANCE = 1.09;
                TCR = 0.447;
                DENSITY = 8.31;
                break;

            case(SS_304):
                RESISTANCE = 0.713;
                TCR = 0.5;
                DENSITY = 8.0;
                break;

            case(SS_316):
                RESISTANCE = 0.771;
                TCR = 0.5;
                DENSITY = 8.0;
                break;

            case(SS_316L):
                RESISTANCE = 0.75;
                TCR = 0.5;
                DENSITY = 8.0;
                break;

            case(SS_317L):
                RESISTANCE = 0.81;
                TCR = 0.5;
                DENSITY = 7.9;
                break;

            case(SS_321):
                RESISTANCE = 0.746;
                TCR = 0.5;
                DENSITY = 8.09;
                break;

            case(SS_430):
                RESISTANCE = 0.6;
                TCR = 0.46;
                DENSITY = 7.74;
                break;

            case(GOLD):
                RESISTANCE = 0.035;
                TCR = 0.129;
                DENSITY = 19.32;
                break;

            case(SILVER):
                RESISTANCE = 0.0159;
                TCR = 0.233;
                DENSITY = 10.49;
                break;

            case(COPPER):
                RESISTANCE = 0.0168;
                TCR = 0.385;
                DENSITY = 8.96;
                break;

            case(TITANIUM_1):
                RESISTANCE = 0.47;
                TCR = 0.523;
                DENSITY = 4.43;
                break;

            case(TITANIUM_2):
                RESISTANCE = 0.56;
                TCR = 0.54;
                DENSITY = 4.51;
                break;

            case(TITANIUM_READY):
                RESISTANCE = 0.85;
                TCR = 0.56;
                DENSITY = 4.75;
                break;

            case(TUNGSTEN):
                RESISTANCE = 0.56;
                TCR = 0.134;
                DENSITY = 19.25;
                break;

            case(NIOBIUM):
                RESISTANCE = 1.46809443507;
                TCR = 0.45;
                DENSITY = 7.5;
                break;

            case(NI200_lin):
                RESISTANCE = 0.096;
                TCR = 0.456;
                DENSITY = 8.89;
                break;

            case(NI200):
                RESISTANCE = 0.096;
                TCR = 0.456;
                DENSITY = 8.89;
                break;

            case(NIFE30):
                RESISTANCE = 0.33;
                TCR = 0.45;
                DENSITY = 8.2;
                break;

            case(NIFE_R):
                RESISTANCE = 0.4334;
                TCR = 0.45;
                DENSITY = 8.2;
                break;

            case(NIFE_S):
                RESISTANCE = 0.21;
                TCR = 0.45;
                DENSITY = 8.5;
                break;

            case(INVAR36):
                RESISTANCE = 0.82;
                TCR = 0.515;
                DENSITY = 8.055;
                break;

            case(NIDH):
                RESISTANCE = 0.09;
                TCR = 0.48;
                DENSITY = 8.9;
                break;

            case(NFT70):
                RESISTANCE = 0.2;
                TCR = 0.52;
                DENSITY = 8.45;
                break;

            case(NFT52):
                RESISTANCE = 0.37;
                TCR = 0.5;
                DENSITY = 8.2;
                break;

        }
    }

    public Double getResistance() {
        return RESISTANCE;
    }

    public Double getTCR() {
        return TCR;
    }

    public Double getDensity() {
        return DENSITY;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
