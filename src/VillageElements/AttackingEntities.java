package VillageElements;

import java.awt.*;

/**
 * This is an abstract class that implements VillageEntity and Fightable interface. It gives the concrete implementation
 * of the methods that are shared by defence entities like getters and setter, but it also has some abstract methods that
 * the inheritors must implement because it is specific to that entity
 *
 */
public abstract class AttackingEntities implements VillageEntity {

    //instance variables
    protected int maxLevel, maxDamage, maxHitPoints, maxAttackRange;
    private int level, damage, hitPoints, attackRange;
    public CollectedResources cost;
    public Point point;


    /**
     * Class constructor that initializes the Defence object to given state.
     * @param maxLevel max level of defence entity
     * @param maxDamage max damage of defence entity
     * @param maxHitPoints max hit points of defence entity
     * @param maxAttackRange max attack range of defence entity
     * @param level level of defence entity
     * @param damage damage of defence entity
     * @param hitPoints hit points of defence entity
     * @param attackRange attack range of defence entity
     * @param cost cost of defence entity
     */
    public AttackingEntities(int maxLevel, int maxDamage, int maxHitPoints, int maxAttackRange, int level, int damage, int hitPoints, int attackRange, CollectedResources cost, Point point) {
        this.maxLevel = maxLevel;
        this.maxDamage = maxDamage;
        this.maxHitPoints = maxHitPoints;
        this.maxAttackRange = maxAttackRange;
        this.level = level;
        this.damage = damage;
        this.hitPoints = hitPoints;
        this.attackRange = attackRange;
        this.cost = cost;
        this.point = point;
    }
    public AttackingEntities(int level, int damage, int hitPoints, int attackRange, CollectedResources cost, Point point) {
        this.level = level;
        this.damage = damage;
        this.hitPoints = hitPoints;
        this.attackRange = attackRange;
        this.cost = cost;
        this.point = point;
    }
    public AttackingEntities(){
        this(10,1,1,1,1,1,1,1,
                new CollectedResources(100,100,100), new Point(0,0));
    }


    /**
     * This method sets the damage level of entity
     * @param damage Entity's damage
     */
    public void setDamage(int damage) {
        this.damage=damage;
    }

    /**
     * Returns the entity's damage
     * @return Entity's damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the attack range of the entity
     * @param attackRange attack range
     */
    public void setAttackRange(int attackRange) {
        this.attackRange=attackRange;
    }

    /**
     * Returns the entity's attack range
     * @return attack range
     */
    public int getAttackRange() {
        return attackRange;
    }

    /**
     * Sets entity's max damage
     * @param maxDamage max damage
     */
    public void setMaxDamage(int maxDamage) {
        this.maxDamage=maxDamage;
    }

    /**
     * Returns entity's max damage
     * @return max damage
     */
    public int getMaxDamage() {
        return this.maxDamage;
    }

    /**
     * Sets the max attack range of the entity
     * @param attackRange max attack range
     */
    public void setMaxAttackRange(int attackRange) {
        this.maxAttackRange=attackRange;
    }

    /**
     * Returns max attack range
     * @return max attack range
     */
    public int getMaxAttackRange() {
        return this.maxAttackRange;
    }

    /**
     * This method returns the max hit points of the current worker
     * @param maxHitPoints max hit points
     */
    public void setMaxHitPoint(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    /**
     * This method returns the cost required to generate a worker
     * @return cost of worker
     */
    public CollectedResources getCost() {
        return cost;
    }

    /**
     * This method sets the cost of the worker to generate a worker
     * @param cost cost of worker
     */
    public void setCost(CollectedResources cost) {
        this.cost = cost;
    }

    /**
     * Returns max hit points of entity
     * @return max hit points
     */
    @Override
    public int getMaxHitPoints() {
        return this.maxHitPoints;
    }

    /**
     * Returns the current level of entity
     * @return current level of entity
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Sets the current level
     * @param level level to set up
     */
    @Override
    public void setLevel(int level) {
        this.level=level;
    }

    /**
     * Returns cost of production
     * @return total cost of production
     */
    @Override
    public CollectedResources getProductionCost() {
        return cost;
    }

    /**
     * Sets cost of production
     * @param cost cost of production
     */
    @Override
    public void setProductionCost(CollectedResources cost) {
        this.cost = cost;
    }

    /**
     * Sets the hit points of entity
     * @param hitPoints hit points
     */
    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints=hitPoints;
    }

    /**
     * Sets the max level of entity
     * @param maxLevel max level allowed
     */
    @Override
    public void setMaxLevel(int maxLevel) {
        this.maxLevel=maxLevel;
    }

    /**
     * Returns max level of entity
     * @return max level
     */
    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    /**
     * Returns the hit points of entity
     * @return hit points
     */
    @Override
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * This method upgrade the worker entity level. Each upgrade equally increases the damage, hit points and the
     * attack range of the entity at each upgrade.
     * @return New level of the entity
     */
    @Override
    public int upgrade() {
        ++level;

        if(level>maxLevel){
            --level;
        }

        if(level==maxLevel){
            damage=maxDamage;
            hitPoints=maxHitPoints;
            attackRange=maxAttackRange;
        }

        else{
            damage++;
            hitPoints++;
        }
        return level;
    }

    /**
     *Returns the position of the current object
     * @return position of object
     */
    @Override
    public Point getPoint() {
        return this.point;
    }

    /**
     * Sets the position to given point
     * @param point position
     */
    @Override
    public void setPoint(Point point) {
        this.point=point;
    }
}
