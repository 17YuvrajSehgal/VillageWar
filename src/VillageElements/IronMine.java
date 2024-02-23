package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents an Iron mine. It depends on the presence of a lumber mill
 * Every iron mine has a production capacity of 10,000,000 units of iron after which it depletes.
 */
public class IronMine extends ExhaustibleNaturalResource implements Conditional {

    private static final int maxProduction=10000000;  //max production after which resource depletes

    public IronMine(int level, int hitPoints, CollectedResources cost, Point point, int quantity) {
        super(level,hitPoints,cost, point,quantity);
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.IronMine"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.IronMine"));
        this.maxWorkers     =   Integer.parseInt(readPropertiesFile().getProperty("max.workers.VillageElements.IronMine"));
    }

    public IronMine(){
        this(1,5,new CollectedResources(100,100,100),new Point(0,0),10000);
    }

    /**
     * This method tells if the iron mine is depleted or not.
     * @return Returns true if it is depleted otherwise false
     */
    @Override
    boolean isDepleted() {
        return this.getMaxProduction()>=maxProduction;
    }

    /**
     * This method returns the max production capacity of the iron mine
     * @return Returns max production capacity of the iron ore
     */
    @Override
    int getMaxProduction() {
        return maxProduction;
    }

    /**
     * This method produces iron according to the production capacity of the mine
     */
    void produceIron(){

    }

    @Override
    public String toString() {
        return "IronMine{" +
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
