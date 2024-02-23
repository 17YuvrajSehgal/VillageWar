package VillageElements;



import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Builder. Its main job is to do build and upgrade village entities. It has very less damage
 * against army units of the enemy and can attack. It can be upgraded to increase its production capacity, damage,
 * attacking range, and hit points to a certain level. It cannot be recruited to the army as it can only fight against
 * enemy who is attacking village.
 */
public class Builder extends Worker implements Conditional,Peasant{

    boolean isAvailable;

    /**
     * Class constructor to set the attributes of the Builder
     * @param level Level of Builder
     * @param damage damage of Builder
     * @param hitPoints hit points of Builder
     * @param attackRange attack range of Builder
     * @param foodRequired food required to create Builder
     * @param cost cost of creating Builder
     * @param point position of the Builder
     */
    public Builder(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Builder")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Builder")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Builder")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Builder")));
    }

    public Builder() {
        this(1,1,1,1,1,new CollectedResources(10,10,10), new Point(0,0));
        this.isAvailable=true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Builder{" +
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
                ", isAvailable=" +this.isAvailable+
                '}';
    }

}
