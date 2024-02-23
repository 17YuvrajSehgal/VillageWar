package VillageElements;


import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Soldier. It has equal damage against all defensive units of the enemy. It can be upgraded
 * to increase damage, attacking range, and hit points to a certain level. It can inflict damage to any building
 * including defence units. It can be recruited to the army unit when attacking other village.
 */
public class Soldier extends Worker implements Recruitable {


    /**
     * Class constructor to set the attributes of the Soldier
     * @param level Level of Soldier
     * @param damage damage of Soldier
     * @param hitPoints hit points of Soldier
     * @param attackRange attack range of Soldier
     * @param foodRequired food required to create Soldier
     * @param cost cost of creating Soldier
     * @param point position of the Soldier
     */
    public Soldier(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Soldier")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Soldier")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Soldier")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Soldier")));
    }

    public Soldier(int level, String className){
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Soldier"));
        this.maxDamage      =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Soldier"));
        this.maxAttackRange =   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Soldier"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Soldier"));
        this.setLevel(level);

        try {
            this.setDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.at.level." + level + "."+className)));
            this.setHitPoints(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.at.level." + level + "."+className)));
            this.setAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.range.at.level." + level + "."+className)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        this.point= new Point(0,0);
        this.cost = new CollectedResources(100,100,100);

    }

    public Soldier(int level) {
        this(level,"VillageElements.Soldier");
    }

    public Soldier() {
        this(1,1,1,1,1,new CollectedResources(10,10,10), new Point(0,0));
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Soldier{" +
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
