package fr.valhalla.coil;

/**
 * Created by mw4rf on 27/08/2016.
 */
public class Coil {

    private Wire wire;

    private Double innerDiameter;
    private Double legLength;

    private Double wraps;
    private Double resistance;

    // R = G x (D x pi x W + L)
    //
    // R - Total/target coil resistance
    // G - Wire resistance for the gauge of kanthal you're using (Ω/mm)
    // D - Coil diameter
    // W - Number of wraps
    // L - Lead length (mm)

    public Coil() {
    }

    /**
     * Get the number of wraps needed to get the target resistance.
     *
     * @param target_resistance
     * @return
     */
    public Double getWraps(Double target_resistance) {
        // Get wraps
        // wraps = (ohms / resistance - innerDiameter - legs*2) / length
        Double wraps = (target_resistance / wire.getResistance() - innerDiameter - legLength * 2) / getWrapLength();
        return wraps;
    }

    /**
     * Get the resistance of the coil, in ohms, given the number of wraps desired.
     *
     * @param target_wraps
     * @return
     */
    public Double getResistance(Double target_wraps) {
        // Get resistance
        // R = total_length * resistivity;
        Double ohms = getLength(target_wraps) * wire.getResistance();
        return ohms;
    }

    /**
     * Get the wire length of 1 wrap.
     *
     * @return
     */
    public Double getWrapLength() {
        // Get length of 1 wrap
        // Length = Math.sqrt(Math.pow(Math.PI * (COIL_DIAMETER + WIRE_HEIGHT), 2) + Math.pow(WIRE_WIDTH, 2));
        // for a round wire, HEIGHT = WIDTH
        Double length = Math.sqrt(Math.pow(Math.PI * (innerDiameter + wire.getDiameter()), 2) + Math.pow(wire.getDiameter(), 2));
        return length;
    }

    /**
     * Get total length of the coil (wraps+legs).
     *
     * @param target_wraps
     * @return
     */
    public Double getLength(Double target_wraps) {
        // Get total length : wraps + legs
        // dist = (length * wraps) + (leg * 2) + diameter;
        Double distance = (getWrapLength() * target_wraps) + (legLength * 2) + innerDiameter;
        return distance;
    }

    /**
     * Return the coil heat flux
     *
     * @param watts
     * @param numberOfCoils
     * @param wraps
     * @return
     */
    public Double getHeatFlux(Double watts, Integer numberOfCoils, Double wraps) {
        // coeff = (result.watts / (model.coil.count * model.wire.count)) / ((Math.PI * model.wire.width) * dist);
        Double coeff = (watts / numberOfCoils) / (Math.PI * wire.getDiameter() * getLength(wraps));
        return coeff;
    }

    public Wire getWire() {
        return wire;
    }

    public void setWire(Wire wire) {
        this.wire = wire;
    }

    public Double getInnerDiameter() {
        return innerDiameter;
    }

    public void setInnerDiameter(Double innerDiameter) {
        this.innerDiameter = innerDiameter;
    }

    public Double getLegLength() {
        return legLength;
    }

    public void setLegLength(Double legLength) {
        this.legLength = legLength;
    }

    public Double getWraps() {
        return wraps;
    }

    public void setWraps(Double wraps) {
        this.wraps = wraps;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }
}
