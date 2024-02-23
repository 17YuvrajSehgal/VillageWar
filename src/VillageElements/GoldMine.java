package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents a Gold mine. Every gold mine has a production capacity of 1,000,000 units
 * of gold after which it depletes.
 */
public class GoldMine extends ExhaustibleNaturalResource implements Conditional {

    private static final int maxProduction=1000000;  //max production after which resource depletes

    public GoldMine(int level, int hitPoints, CollectedResources cost, Point point, int quantity) {
        super(level,hitPoints,cost, point, quantity);
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.GoldMine"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.GoldMine"));
        this.maxWorkers     =   Integer.parseInt(readPropertiesFile().getProperty("max.workers.VillageElements.GoldMine"));
    }

    public GoldMine(){
        this(1,5,new CollectedResources(100,100,100),new Point(0,0),10000);
    }

    public GoldMine(int quantity){
        super(quantity);
    }

    /**
     * This method tells if the gold mine is depleted or not.
     * @return Returns true if it is depleted otherwise false
     */
    @Override
    boolean isDepleted() {
        return this.getMaxProduction()>=maxProduction;
    }

    /**
     * This method returns the max production capacity of the gold mine
     * @return Returns max production capacity of the iron ore
     */
    @Override
    int getMaxProduction() {
        return maxProduction;
    }

    /**
     * This method produces gold according to the production capacity of the mine
     */
    public void produceGold(){

    }

    @Override
    public String toString() {
        return "GoldMine{" +
                "maxLevel=" + maxLevel +
                ", maxHitPoints=" + maxHitPoints +
                ", maxWorkers=" + maxWorkers +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", productionCapacity=" + productionCapacity +
                ", point=" + point +
                ", cost=" + cost +
                ", maxProduction= " + maxProduction +
                ", quantity= "+quantity+
                '}';
    }
}
