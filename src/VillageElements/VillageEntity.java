package VillageElements;

import java.awt.*;
import java.io.Serializable;

/**
 * This class represents every entity in a village. Everything is upgradable, has a cost of production and
 * has a level and a max level.
 */
public interface VillageEntity extends Serializable {

    /**
     * Returns the current level of entity
     * @return current level of entity
     */
    int getLevel();

    /**
     * Sets the current level
     * @param level level to set up
     */
    void setLevel(int level);

    /**
     * Returns cost of production
     * @return total cost of production
     */
    CollectedResources getProductionCost();

    /**
     * Sets cost of production
     * @param cost cost of production
     */
    void setProductionCost(CollectedResources cost);

    /**
     * Returns the hit points of entity
     * @return hit points
     */
    int getHitPoints();

    /**
     * Sets the hit points of entity
     * @param hitPoints hit points
     */
    void setHitPoints(int hitPoints);

    /**
     * Returns max level of entity
     * @return max level
     */
    int getMaxLevel();

    /**
     * Sets the max level of entity
     * @param maxLevel max level allowed
     */
    void setMaxLevel(int maxLevel);

    /**
     * Sets max hit points of the entity
     * @param maxHitPoint max hit points
     */
    void setMaxHitPoint(int maxHitPoint);

    /**
     * Returns max hit points of entity
     * @return max hit points
     */
    int getMaxHitPoints();

    /**
     * Upgrade the entity by one level
     * @return level after upgrade
     */
    int upgrade();

    /**
     * This method returns the point of the given entity on the map
     * @return Current coordinates of the entity
     */
    Point getPoint();

    /**
     * Sets the point of entity to given coordinates
     */
    void setPoint(Point point);
}
