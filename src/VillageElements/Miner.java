package VillageElements;


import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Miner. Its main job is to do mining and every miner has a maximum production capacity after
 * which it won't work for a couple of hours. Its initial capacity is 100. It has very less damage against army units of
 * the enemy and can attack. It can be upgraded to increase its production capacity, damage, attacking range, and hit
 * points to a certain level. It cannot be recruited to the army as it can only fight against enemy who is attacking village.
 */
public class Miner extends Worker implements Peasant {
    private static int maxProductionCapacity = 100; //maximum production capacity of miner

    public Miner(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Miner")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Miner")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Miner")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Miner")));
    }

    public Miner() {
        this(1,1,1,1,1,new CollectedResources(10,10,10), new Point(0,0));
    }

    /**
     * This method returns the maximum production capacity of the miner
     * @return The maximum production capacity of the miner
     */
    public int getMaxProductionCapacity(){
        return maxProductionCapacity;
    }

    /**
     * This method sets the maximum production capacity to the given unit
     * @param maxProductionCapacity New maximum production capacity
     */
    public static void setMaxProductionCapacity(int maxProductionCapacity) {
        Miner.maxProductionCapacity = maxProductionCapacity;
    }

    /**
     * This method makes a miner do mining on the assigned mine.
     * @param naturalResource Mine on which miner should work.
     */
    public void doMining(ExhaustibleNaturalResource naturalResource){    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Miner{" +
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
