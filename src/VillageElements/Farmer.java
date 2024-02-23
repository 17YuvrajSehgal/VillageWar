package VillageElements;
import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Farmer. Its main job is to do farming. It has very less damage against army units of the
 * enemy and can attack. It can be upgraded to increase its production capacity, damage, attacking range, and hit points
 * to a certain level. It cannot be recruited to the army as it can only fight against enemy who is attacking village.
 */
public class Farmer extends Worker implements Peasant {


    /**
     * Class constructor to set the attributes of the Farmer
     * @param level Level of Farmer
     * @param damage damage of Farmer
     * @param hitPoints hit points of Farmer
     * @param attackRange attack range of Farmer
     * @param foodRequired food required to create Farmer
     * @param cost cost of creating Farmer
     * @param point position of the Farmer
     */
    public Farmer(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Farmer")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Farmer")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Farmer")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Farmer")));
    }

    public Farmer() {
        this(1,1,1,1,1,new CollectedResources(10,10,10), new Point(0,0));
    }

    /**
     * This method makes a farmer do farming on the assigned Farm.
     * @param farm Farm on which farmer should work.
     */
    public void doFarming(Farm farm){    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Farmer{" +
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
