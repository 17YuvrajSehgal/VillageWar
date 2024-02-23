package VillageElements;

import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the archer tower defence mechanism. It can be upgraded to increase damage, attacking
 * range, and hit points to a certain level.
 */
public class ArcherTower extends AttackingEntities implements Defender,Building{

    public ArcherTower(int level, int damage, int hitPoints, int attackRange, CollectedResources cost,
                       Point point){
        super(level,damage,hitPoints,attackRange,cost, point);
        this.maxLevel      =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.ArcherTower"));
        this.maxDamage     =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.ArcherTower"));
        this.maxAttackRange=   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.ArcherTower"));
        this.maxHitPoints  =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.ArcherTower"));
    }


    public ArcherTower(int level, String className){
        this.maxLevel      =   Integer.parseInt(readPropertiesFile().getProperty("max.level."+className));
        this.maxDamage     =   Integer.parseInt(readPropertiesFile().getProperty("max.damage."+className));
        this.maxAttackRange=   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange."+className));
        this.maxHitPoints  =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints."+className));
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

    public ArcherTower(int level) {
        this(level,"VillageElements.ArcherTower");
    }

    public ArcherTower() {
        this(1, 10, 10, 10, new CollectedResources(100, 100, 100),
                new Point(0, 0));
    }


    @Override
    public String toString() {
        return "ArcherTower{" +
                "maxLevel=" + this.getMaxLevel() +
                ", maxDamage=" + this.getMaxDamage() +
                ", maxHitPoints=" + this.getMaxHitPoints() +
                ", maxAttackRange=" + this.getMaxAttackRange() +
                ", level=" + this.getLevel() +
                ", damage=" + this.getDamage() +
                ", hitPoints=" + this.getHitPoints() +
                ", attackRange=" + this.getAttackRange() +
                ", productionCost=" + this.getProductionCost() +
                '}';
    }


}
