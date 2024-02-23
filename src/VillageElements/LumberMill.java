package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents a lumber mill. It is independent and can be planted without the presence of other
 * entity. It has unlimited production capacity
 */
public class LumberMill extends NaturalResources {


    public LumberMill(int level, int hitPoints, CollectedResources cost, Point point, int quantity) {
        super(level,hitPoints,cost, point,quantity);
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.LumberMill"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.LumberMill"));
        this.maxWorkers     =   Integer.parseInt(readPropertiesFile().getProperty("max.workers.VillageElements.LumberMill"));
    }

    /**
     * This constructor initializes the farm object with the given max population feeding capacity per farm
     */
    public LumberMill() {
        this(1,5,new CollectedResources(100,100,100),
                new Point(0,0),10000);
    }

    /**
     * This method produces lumber according to the capacity of the lumber mill.
     */
    void produceLumber(){
    }

    @Override
    public String toString() {
        return "LumberMill{" +
                "maxLevel=" + maxLevel +
                ", maxHitPoints=" + maxHitPoints +
                ", maxWorkers=" + maxWorkers +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", productionCapacity=" + productionCapacity +
                ", point=" + point +
                ", cost=" + cost +
                ", quantity= "+quantity+
                '}';
    }
}
