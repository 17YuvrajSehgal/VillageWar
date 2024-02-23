package VillageElements;

import static VillageElements.PropertyReader.readPropertiesFile;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a village map. It consists of all the entities that a village holds and its village hall.
 *
 */
public class VillageMap implements Serializable {
    public final VillageHall villageHall;
    private List<Building> buildings;

    /**
     * Class constructor to set village map with given entities and creates a new village hall
     * @param buildings list of village entities
     */
    public VillageMap(List<Building> buildings) {
        this.villageHall = new VillageHall();
        this.buildings = buildings;
        this.buildings.add(villageHall);
    }

    /**
     * class constructor that sets the village entities to empty list and creates a new village hall
     */
    public VillageMap(){
        this.buildings = new ArrayList<>();
        this.villageHall = new VillageHall();
        this.buildings.add(villageHall);
    }

    /**
     * This is an inner class that represents a Village hall. As a village hall cannot be created without a village
     * and vice versa. A village map can have at most 1 village hall that also determines the upgrade for other buildings.
     * A village hall is inbuilt in a village and is free for production but its upgrades are not free.
     */
    public static class VillageHall implements VillageEntity,Building {

        //instance variables
        private int maxLevel, maxHitPoints;
        private int level, hitPoints;
        private CollectedResources productionCost;
        private Point position;

        public VillageHall(){
            this.maxLevel= Integer.parseInt(readPropertiesFile().getProperty("max.level.VillageElements.TownHall"));
            this.maxHitPoints=Integer.parseInt(readPropertiesFile().getProperty("max.hitPoints.VillageElements.TownHall"));
            this.level=1;
            this.hitPoints=30;
            this.position=new Point(0,0);
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
         * Returns cost of production
         * @return total cost of production
         */
        @Override
        public CollectedResources getProductionCost() {
            return this.productionCost;
        }

        /**
         * Sets cost of production
         * @param cost cost of production
         */
        @Override
        public void setProductionCost(CollectedResources cost) {
            this.productionCost=cost;
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
         * Sets the hit points of entity
         * @param hitPoints hit points
         */
        @Override
        public void setHitPoints(int hitPoints) {
            this.hitPoints=hitPoints;
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
         * Sets the max level of entity
         * @param maxLevel max level allowed
         */
        @Override
        public void setMaxLevel(int maxLevel) {
            this.maxLevel=maxLevel;
        }

        /**
         * Sets max hit points of the entity
         * @param maxHitPoint max hit points
         */
        @Override
        public void setMaxHitPoint(int maxHitPoint) {
            this.maxHitPoints=maxHitPoint;
        }

        /**
         * Returns max hit points of entity
         * @return max hit points
         */
        @Override
        public int getMaxHitPoints() {
            return 0;
        }

        /**
         * Upgrade the entity by one level
         * @return level after upgrade
         */
        @Override
        public int upgrade() {
            if(this.level>=maxLevel){
                return this.level;
            }
            return ++level;
        }

        @Override
        public Point getPoint() {
            return this.position;
        }

        @Override
        public void setPoint(Point position) {
            this.position=position;
        }

        /**
         * Returns the string representation of the object
         * @return String representation of object
         */
        @Override
        public String toString() {
            float productionCost = 0;
            return "VillageHall{" +
                    "maxLevel=" + maxLevel +
                    ", maxHitPoints=" + maxHitPoints +
                    ", level=" + level +
                    ", hitPoints=" + hitPoints +
                    ", productionCost=" + productionCost +
                    '}';
        }

    }


    /**
     * This method adds an entity to the village map
     * @param building entity to be added
     */
    public void addBuilding(Building building){
        if(buildings!=null){
            buildings.add(building);
        }
        else {
            buildings = new ArrayList<>();
            buildings.add(building);
        }
    }

    /**
     * This method returns the list of all entities of the village.
     * @return List of all entities in the village
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    /**
     * This method sets the entities of the village to the given list of village entities
     * @param buildings List of village entities
     */
    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * Returns the village hall of the village map
     * @return village hall of map
     */
    public VillageHall getVillageHall() {
        return this.villageHall;
    }

    /**
     * upgrades the village hall of the map.
     * @return returns the upgraded level of village
     */
    public int upgradeMap(){
        return this.villageHall.upgrade();
    }

    /**
     * Print all entities of village
     */
    public void printAllEntities(){
        System.out.println(this.villageHall);
        this.buildings.forEach(
                System.out::println
        );
    }

    /**
     * returns total hit points of village
     * @return total hit points of village
     */
    public int getTotalHitPointsOfBuildings() {
        int totalHitPoints=0;
        for(Building village: buildings){
            totalHitPoints+=village.getHitPoints();
        }
        return totalHitPoints;
    }

    /**
     * Returns the string representation of the object
     * @return String representation of object
     */
    @Override
    public String toString() {
        return "VillageMap{" +
                "villageHall=" + villageHall +
                ", entities=" + buildings +
                '}';
    }
}
