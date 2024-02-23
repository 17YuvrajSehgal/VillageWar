package VillageElements;


import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents a farm in a village. Each farm has a maximum population feeding capacity
 * which is initially set to 20. It can be increased by 10 by upgrading the farm.
 */
public class Farm extends NaturalResources {

    private int populationFedPerFarm; //max population feeding capacity per farm

    public Farm(int level, int hitPoints, int populationFedPerFarm, CollectedResources cost, Point point, int quantity) {
        super(level,hitPoints,cost, point,quantity);
        this.populationFedPerFarm=populationFedPerFarm;
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Farm"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Farm"));
        this.maxWorkers     =   Integer.parseInt(readPropertiesFile().getProperty("max.workers.VillageElements.Farm"));
    }

    /**
     * This constructor initializes the farm object with the given max population feeding capacity per farm
     * @param populationFedPerFarm max population feeding capacity per farm
     */
    public Farm(int populationFedPerFarm) {
        this(1,5,populationFedPerFarm,new CollectedResources(100,100,100),
                new Point(0,0),100);
    }

    /**
     * This is a default constructor that initializes a farm object with a maximum population
     * feeding capacity of 20 per farm
     */
    public Farm() {
        this(10);
        this.point=new Point(0,0);

    }

    /**
     * This method returns the max population feeding capacity per farm
     * @return  max population feeding capacity per farm
     */
    public int getSizeFedPerFarm() {
        return populationFedPerFarm;
    }

    /**
     * This method sets the max population feeding capacity per farm
     * @param sizeFedPerFarm max population feeding capacity per farm
     */
    public void setSizeFedPerFarm(int sizeFedPerFarm) {
        this.populationFedPerFarm = sizeFedPerFarm;
    }

    /**
     * This method produces food according to its production capacity
     */
    public void produceFood(){

    }

    @Override
    public String toString() {
        return "Farm{" +
                "maxLevel=" + this.getMaxLevel() +
                ", maxHitPoints=" + this.getMaxHitPoints() +
                ", maxWorkers=" + this.getMaxWorkers() +
                ", level=" + this.getLevel() +
                ", hitPoints=" + this.getHitPoints() +
                ", productionCapacity=" + this.getProductionCapacity() +
                ", cost=" + this.getProductionCost() +
                ", populationFedPerFarm=" + this.getSizeFedPerFarm() +
                ", quantity= "+quantity+
                ", position= "+point+
                '}';
    }
}
