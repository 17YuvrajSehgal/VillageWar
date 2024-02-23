package VillageElements;


import java.awt.*;

/**
 * This abstract class represents all the workers in the village. It gives the concrete implementation for the
 * Inhabitant interface and extends Defence as all the inhabitants can defend the village during the attack.
 */
public abstract class Worker extends AttackingEntities {

    protected int feedingQuantity;    //feeding quantity required to produce worker

    /**
     * Class constructor to instantiate a worker with level, damage, hitPoints, attack range, feeding quantity, cost and its position
     * @param level level of worker
     * @param damage damage of worker
     * @param hitPoints hit points of worker
     * @param attackRange attack range of worker
     * @param feedingQuantity feeding quantity of worker
     * @param cost cost of worker
     * @param point point of worker
     */
    public Worker(int level, int damage, int hitPoints, int attackRange, int feedingQuantity, CollectedResources cost, Point point) {
        super(level, damage, hitPoints, attackRange, cost, point);
        this.feedingQuantity=feedingQuantity;
    }

    public Worker(){
        this(1,1,1,1,10,new CollectedResources(100,100,100),new Point(0,0));
    }



    /**
     * Sets the feeding quantity required by entity
     * @param feedingQuantity feeding quantity of entity from the farm
     */
    public void setFeedingQuantity(int feedingQuantity) {
        this.feedingQuantity=feedingQuantity;
    }

    /**
     * Returns the feeding quantity of the entity.
     * @return feeding quantity of entity
     */
    public int getFeedingQuantity() {
        return feedingQuantity;
    }

}
