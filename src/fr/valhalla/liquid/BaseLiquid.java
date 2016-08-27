package fr.valhalla.liquid;

public class BaseLiquid {

    private Double VGpercent = new Double(0.0);
    private Double PGpercent = new Double(0.0);
    private Double nicotine_mgml = new Double(0.0);
    private Double quantity = new Double(0.0);
    private Double concentration = new Double(0.0);
    private Double price_per_ml = new Double(0.0);

    public BaseLiquid() {
    }

    public BaseLiquid(Double PGpercent, Double VGpercent, Double nicotine_mgml) {
        this.VGpercent = VGpercent;
        this.PGpercent = PGpercent;
        this.nicotine_mgml = nicotine_mgml;
    }

    public BaseLiquid(Double PGpercent, Double VGpercent) {
        this.VGpercent = VGpercent;
        this.PGpercent = PGpercent;
        this.nicotine_mgml = new Double("0");
    }

    public BaseLiquid(Double concentration) {
        this.concentration = concentration;
    }

    public Double getVG() {
        return VGpercent;
    }

    public void setVG(Double VGpercent) {
        this.VGpercent = VGpercent;
    }

    public Double getPG() {
        return PGpercent;

    }

    public void setPG(Double PGpercent) {
        this.PGpercent = PGpercent;
    }

    public Double getNicotine() {
        return nicotine_mgml;
    }

    public void setNicotine(Double nicotine_mgml) {
        this.nicotine_mgml = nicotine_mgml;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getConcentration() {
        return concentration;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    /**
     * Get the number of liquid drops needed to match the desired quantity.
     * 1 ml = 20 drops
     * @return
     */
    public Integer getDrops() {
        Double drops = this.getQuantity() * 20;
        return (int)Math.round(drops);
    }

    public void setPricePerML(Double full_price, Double ml) {
        try {
            this.price_per_ml = full_price / ml;
        } catch (Exception e) {
            // Catch because is ML is 0, this is a division by 0 !
            this.price_per_ml = 0.0;
        }
    }

    public Double getPricePerML() {
        return this.price_per_ml;
    }

    public Double getPrice() {
        return price_per_ml * quantity;
    }
}