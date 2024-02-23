package VillageElements;

/**
 * This interface represents all the natural resources like farms, lumber mills, iron mine, gold mine etc.
 */
public interface NaturalResource extends VillageEntity {

    /**
     * Set the production capacity
     * @param productionCapacity production capacity
     */
    void setProductionCapacity(int productionCapacity);

    /**
     * Returns production capcity
     * @return production capacity
     */
    int getProductionCapacity();

    /**
     * Sets maximum worker allowed to work on the resource
     * @param maxWorkers max number of worker allowed
     */
    void setMaxWorkers(int maxWorkers);

    /**
     * Returns max number of worker allowed on the resource
     * @return max workers allowed
     */
    int getMaxWorkers();
    int getQuantity();
}
