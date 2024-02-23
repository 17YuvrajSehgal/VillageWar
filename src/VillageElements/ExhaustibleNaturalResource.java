package VillageElements;


import java.awt.*;

/**
 * This is an abstract class that represents all the exhaustible natural resources which gets depleted after a fixed
 * amount of extraction. It has abstract methods like isDepleted and getMaxProduction that every inheritor must implement,
 * as every inheritor has its own depletion limit so this method is specific to that entity.
 */
public abstract class ExhaustibleNaturalResource extends NaturalResources {

    public ExhaustibleNaturalResource(int level, int hitPoints, CollectedResources cost, Point point, int quantity) {
        super(level,hitPoints,cost, point,quantity);
    }

    public ExhaustibleNaturalResource(int quantity) {
        super(quantity);
    }

    /**
     * Shows if the resource is depleted or not
     * @return true if it is depleted false otherwise
     */
    abstract boolean isDepleted();

    /**
     * Returns maximum production capacity of the resource
     * @return max production capacity
     */
    abstract int getMaxProduction();

}
