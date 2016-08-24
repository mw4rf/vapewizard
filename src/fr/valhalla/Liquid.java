package fr.valhalla;

import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by mw4rf on 23/08/2016.
 */
public class Liquid extends BaseLiquid {

    private ArrayList<BaseLiquid> bases = new ArrayList<>();
    private ArrayList<BaseLiquid> aromas = new ArrayList<>();
    private Double quantity;

    public void addBase(BaseLiquid base) {
        this.bases.add(base);
    }

    public BaseLiquid getBase(int index) {
        return this.bases.get(index);
    }

    public void addAroma(BaseLiquid base) {
        this.aromas.add(base);
    }

    public BaseLiquid getAroma(int index) {
        return this.aromas.get(index);
    }


    /**
     * Magic happens here.
     * @param target_nicotine
     * @param target_quantity
     */
    public void brew(Double target_nicotine, Double target_quantity) {
        // Get bases & aromas
        BaseLiquid base1 = getBase(0);
        BaseLiquid base2 = getBase(1);
        BaseLiquid aroma1 = getAroma(0);
        BaseLiquid aroma2 = getAroma(1);
        BaseLiquid aroma3 = getAroma(2);

        // Get quantity of each aroma
        Double aroma1_quantity = aroma1.getConcentration() / 100 * target_quantity;
        Double aroma2_quantity = aroma2.getConcentration() / 100 * target_quantity;
        Double aroma3_quantity = aroma3.getConcentration() / 100 * target_quantity;
        Double total_aroma = aroma1_quantity + aroma2_quantity + aroma3_quantity;

        // Get quantity of each base
        Double base1_quantity = target_nicotine * target_quantity / base1.getNicotine();
        Double base2_quantity = target_quantity - (base1_quantity + total_aroma);

        // Protection
        if(base2_quantity<0) {
            base1_quantity = target_quantity - total_aroma;
            base2_quantity = 0.0;
        }

        // Get percent of each base
        Double base1_percent = base1_quantity / target_quantity * 100;
        Double base2_percent = 100 - base1_percent;

        // Get total PG/VG percent of the new liquid
        Double pg_percent = (base1_percent * base1.getPG() + base2_percent * base2.getPG()) / 100;
        Double vg_percent;// = (base1_percent * base1.getVG() + base2_percent * base2.getVG()) / 100;

        // Aromas are pure PG
        Double total_aroma_concentration = aroma1.getConcentration() + aroma2.getConcentration() + aroma3.getConcentration();
        pg_percent += total_aroma_concentration;
        vg_percent = 100 - pg_percent;

        // Save
        base1.setQuantity(base1_quantity);
        base1.setConcentration(base1_percent);
        base2.setQuantity(base2_quantity);
        base2.setConcentration(base2_percent);
        aroma1.setQuantity(aroma1_quantity);
        aroma2.setQuantity(aroma2_quantity);
        aroma3.setQuantity(aroma3_quantity);
        super.setPG(pg_percent);
        super.setVG(vg_percent);
        super.setQuantity(target_quantity);
        super.setNicotine(target_nicotine);
    }
}
