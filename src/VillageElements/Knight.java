package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Knight. It has more damage against defensive units of the enemy and has more hit points.
 * It can be upgraded to increase damage, attacking range, and hit points to a certain level. It can inflict damage
 * to any building including defence units. It can be recruited to the army unit when attacking other village.
 */
public class Knight extends Worker implements Recruitable {

    /**
     * Class constructor to set the attributes of the Knight
     * @param level Level of Knight
     * @param damage damage of Knight
     * @param hitPoints hit points of Knight
     * @param attackRange attack range of Knight
     * @param foodRequired food required to create Knight
     * @param cost cost of creating Knight
     * @param point position of the Knight
     */
    public Knight(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost, Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.setMaxLevel(Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Knight")));
        this.setMaxDamage(Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Knight")));
        this.setMaxAttackRange(Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Knight")));
        this.setMaxHitPoint(Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Knight")));
    }


    public Knight(int level, String className){
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Knight"));
        this.maxDamage      =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Knight"));
        this.maxAttackRange =   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Knight"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Knight"));
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

    public Knight(int level) {
        this(level,"VillageElements.Knight");
    }

    public Knight() {
        this(1,16,10,1,1,new CollectedResources(10,10,10), new Point(0,0));
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Knight{" +
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
