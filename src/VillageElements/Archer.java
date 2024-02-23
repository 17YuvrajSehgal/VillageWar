package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the Archer. It has more damage against defensive units of the enemy and can attack from
 * some distance. It can be upgraded to increase damage, attacking range, and hit points to a certain level.
 * It can inflict damage to any building, including defence units. It can be recruited to the army
 * unit when attacking other village.
 */
public class Archer extends Worker implements Recruitable {

    /**
     * Class constructor to set the attributes of the Archer
     * @param level Level of Archer
     * @param damage damage of archer
     * @param hitPoints hit points of archer
     * @param attackRange attack range of archer
     * @param foodRequired food required to create archer
     * @param cost cost of creating archer
     * @param point position of the archer
     */
    public Archer(int level, int damage, int hitPoints, int attackRange, int foodRequired, CollectedResources cost,
                  Point point){
        super(level,damage,hitPoints,attackRange,foodRequired,cost, point);
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Archer"));
        this.maxDamage      =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Archer"));
        this.maxAttackRange =   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Archer"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Archer"));
    }

    public Archer(int level, String className){
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Archer"));
        this.maxDamage      =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Archer"));
        this.maxAttackRange =   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Archer"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Archer"));
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

    public Archer(int level) {
        this(level,"VillageElements.Archer");
    }

    public Archer(){
        this(1,10,10,10,10,new CollectedResources(100,
                100,100), new Point(0,0));
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "Archer{" +
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
                ", point=" + point +
                '}';
    }

}
