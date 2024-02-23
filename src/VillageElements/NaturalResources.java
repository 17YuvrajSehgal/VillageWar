package VillageElements;


import java.awt.*;

/**
 * This abstract class implements VillageEntity and NaturalResource interface. It gives the concrete implementation for
 * the common methods among inheritors like the getters and setters.
 */
public abstract class NaturalResources implements NaturalResource, Building {

    //instance variables
    protected int maxLevel, maxHitPoints, maxWorkers;
    protected int level, hitPoints, productionCapacity, quantity;
    Point point;
    CollectedResources cost;

    public NaturalResources(int maxLevel, int maxHitPoints, int maxWorkers, int level, int hitPoints,
                            int productionCapacity, Point point, CollectedResources cost, int quantity) {
        this.maxLevel = maxLevel;
        this.maxHitPoints = maxHitPoints;
        this.maxWorkers = maxWorkers;
        this.level = level;
        this.hitPoints = hitPoints;
        this.productionCapacity = productionCapacity;
        this.point = point;
        this.cost = cost;
        this.quantity=quantity;
    }


    public NaturalResources(int level, int hitPoints, CollectedResources cost, Point point, int quantity) {
        this.level = level;
        this.hitPoints = hitPoints;
        this.cost = cost;
        this.point = point;
        this.quantity=quantity;
    }

    public NaturalResources(int quantity){
        this(1,10,new CollectedResources(100,100,100),new Point(0,0),quantity );
    }

    /**
     * Set the production capacity
     * @param productionCapacity production capacity
     */
    @Override
    public void setProductionCapacity(int productionCapacity) {
        this.productionCapacity=productionCapacity;
    }

    /**
     * Returns production capacity
     * @return production capacity
     */
    @Override
    public int getProductionCapacity() {
        return this.productionCapacity;
    }

    /**
     * Sets maximum worker allowed to work on the resource
     * @param maxWorkers max number of worker allowed
     */
    @Override
    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers=maxWorkers;
    }

    /**
     * Returns max number of worker allowed on the resource
     * @return max workers allowed
     */
    @Override
    public int getMaxWorkers() {
        return this.maxWorkers;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns the current level of entity
     * @return current level of entity
     */
    @Override
    public int getLevel() {
        return this.level;
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
     * Returns max level of entity
     * @return max level of the defence
     */
    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    /**
     * Sets max hit points of the entity
     * @param maxHitPoints max hit points
     */
    @Override
    public void setMaxHitPoint(int maxHitPoints) {
        this.maxHitPoints=maxHitPoints;
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
     * Upgrade the entity by one level
     * @return level after upgrade
     */
    @Override
    public int upgrade() {
        return 0;
    }

    /**
     * Returns the position of object
     * @return position of object
     */
    @Override
    public Point getPoint() {
        return null;
    }

    /**
     * Sets the position of object
     * @param point position of entity
     */
    @Override
    public void setPoint(Point point) {
        this.point=point;
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
     * Returns cost of production
     * @return total cost of production
     */
    @Override
    public CollectedResources getProductionCost() {
        return this.cost;
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
     * Returns the hit points of entity
     * @return hit points
     */
    @Override
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * This method prints the Natural Resource Object.
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "NaturalResources{" +
                "maxLevel=" + maxLevel +
                ", maxHitPoints=" + maxHitPoints +
                ", maxWorkers=" + maxWorkers +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", productionCapacity=" + productionCapacity +
                ", cost=" + cost +
                ", quantity= "+ quantity +
                '}';
    }
}
