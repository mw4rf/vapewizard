package fr.valhalla.coil;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by mw4rf on 25/08/2016.
 */
public class OhmsLaw {

    BigDecimal R = new BigDecimal("0"); // ohms
    BigDecimal E = new BigDecimal("0"); // volts
    BigDecimal P = new BigDecimal("0"); // watts
    BigDecimal I = new BigDecimal("0"); // amps

    public OhmsLaw(BigDecimal ohms, BigDecimal volts, BigDecimal watts, BigDecimal amps) {
        R = ohms;
        E = volts;
        P = watts;
        I = amps;
    }

    public OhmsLaw(String ohms, String volts, String watts, String amps) {
        this(new BigDecimal(ohms), new BigDecimal(volts), new BigDecimal(watts), new BigDecimal(amps));
    }

    public static BigDecimal round(BigDecimal b) {
        return b.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }

    public BigDecimal getOhms() {
        // We already know
        if(R.signum() != 0)
            return R;
        // R = E / I
        if(E.signum() != 0 &&  I.signum() != 0)
            return E.divide(I, MathContext.DECIMAL64);
        // R = E2 / P
        if(E.signum() != 0 &&  P.signum() != 0)
            return E.multiply(E).divide(P, MathContext.DECIMAL64);
        // R = P / I2
        if(P.signum() != 0 &&  I.signum() != 0)
            return P.divide(I.multiply(I), MathContext.DECIMAL64);

        return BigDecimal.ZERO;
    }

    public BigDecimal getVolts() {
        // We already know
        if(E.signum() != 0)
            return E;
        // E = R * I
        if(R.signum() != 0 &&  I.signum() != 0)
            return R.multiply(I);
        // E = P / I
        if(P.signum() != 0 &&  I.signum() != 0)
            return P.divide(I, MathContext.DECIMAL64);
        // E = sq(P * R)
        if(P.signum() != 0 &&  R.signum() != 0)
            return sqrt(P.multiply(R));

        return BigDecimal.ZERO;
    }

    public BigDecimal getWatts() {
        // We already know
        if(P.signum() != 0)
            return P;
        // P = E2 / R
        if(E.signum() != 0 &&  R.signum() != 0)
            return E.multiply(E).divide(R, MathContext.DECIMAL64);
        // P = R * I2
        if(R.signum() != 0 &&  I.signum() != 0)
            return R.multiply(I.multiply(I));
        // P = E * I
        if(E.signum() != 0 &&  I.signum() != 0)
            return E.multiply(I);

        return BigDecimal.ZERO;
    }

    public BigDecimal getAmps() {
        // We already know
        if(I.signum() != 0)
            return I;
        // I = sqrt(P/R)
        if(P.signum() != 0 &&  R.signum() != 0)
            return sqrt(P.divide(R, MathContext.DECIMAL64));
        // I = P / E
        if(P.signum() != 0 &&  E.signum() != 0)
            return P.divide(E, MathContext.DECIMAL64);
        // I = E / R
        if(E.signum() != 0 &&  R.signum() != 0)
            return E.divide(R, MathContext.DECIMAL64);

        return BigDecimal.ZERO;
    }


}
