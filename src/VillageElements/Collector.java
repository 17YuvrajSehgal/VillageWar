package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;
/**
 * This class represents the Collector. Its main job is to collect lumber and every collector has a maximum production capacity after
 * which it won't work for a couple of hours. It has very less damage against army units of the enemy and can attack. It
 * can be upgraded to increase its production capacity, damage, attacking range, and hit points to a certain level.
 * It cannot be recruited to the army as it can only fight against enemy who is attacking village.
 */
public class Collector extends Worker implements Peasant {


    private static final int maxProductionCapacity = 100;   //maximum production capacity of miner

    /**
     * Class constructor to set the attributes of the Collector
     * @param level Level of Collector
     * @param damage damage of Collector
     * @param hitPoints hit points of Collector
     * @param attackRange attack range of Collector
     * @param foodRequired food required to create Collector
     * @param cost cost of creating Collector
     * @param point position of the Collector
     */
    public Collector(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Collector")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Collector")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Collector")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Collector")));
    }

    /**
     * Class constructor
     */
    public Collector() {
        this(1,1,1,1,1,new CollectedResources(10,10,10), new Point(0,0));
    }


    /**
     * This method returns the maximum production capacity of the collector
     * @return The maximum production capacity of the collector
     */
    public int getMaxProductionCapacity(){
        return maxProductionCapacity;
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Collector{" +
                "maxLevel=" + this.getMaxLevel() +
                ", maxDamage=" + this.getMaxDamage() +
                ", maxHitPoints=" + this.getMaxHitPoints() +
                ", maxAttackRange=" + this.getMaxAttackRange() +
                ", level=" + this.getLevel() +
                ", damage=" + this.getDamage() +
                ", hitPoints=" + this.getHitPoints() +
                ", productionCost=" + this.getProductionCost() +
                ", attackRange=" + this.getAttackRange() +
                ", feedingQuantity=" + this.getFeedingQuantity() +
                '}';
    }


}
