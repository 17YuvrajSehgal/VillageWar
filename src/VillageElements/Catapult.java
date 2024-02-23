package VillageElements;


import java.awt.*;

import static VillageElements.PropertyReader.readPropertiesFile;

/**
 * This class represents the catapult defence mechanism. It can be upgraded to increase damage, attacking
 * range, and hit points to a certain level.
 */
public class Catapult extends AttackingEntities implements Defender,Building {

    public Catapult(int level, int damage, int hitPoints, int attackRange, CollectedResources cost,
                       Point point){
        super(level,damage,hitPoints,attackRange,cost, point);
        this.maxLevel      =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Catapult"));
        this.maxDamage     =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Catapult"));
        this.maxAttackRange=   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Catapult"));
        this.maxHitPoints  =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Catapult"));
    }

    public Catapult(int level, String className){
        this.maxLevel       =   Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.Catapult"));
        this.maxDamage      =   Integer.parseInt(readPropertiesFile().getProperty("max.damage.VillageElements.Catapult"));
        this.maxAttackRange =   Integer.parseInt(readPropertiesFile().getProperty("max.attackRange.VillageElements.Catapult"));
        this.maxHitPoints   =   Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.Catapult"));
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

    public Catapult(int level) {
        this(level,"VillageElements.Catapult");
    }

    public Catapult(){
        this(1,10,10,10,new CollectedResources(100,100,100),
                new Point(0,0));
    }


    @Override
    public String toString() {
        return "Catapult{" +
                "maxLevel=" + this.getMaxLevel() +
                ", maxDamage=" + this.getMaxDamage() +
                ", maxHitPoints=" + this.getMaxHitPoints() +
                ", maxAttackRange=" + this.getMaxAttackRange() +
                ", level=" + this.getLevel() +
                ", damage=" + this.getDamage() +
                ", hitPoints=" + this.getHitPoints() +
                ", productionCost=" + this.getProductionCost() +
                ", attackRange=" + this.getAttackRange() +
                '}';
    }

}
