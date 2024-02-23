package Models;

import Game.ArmyUnit;
import VillageElements.*;
import Game.WorkForce;

import java.io.Serializable;
import java.sql.Time;

public class Village implements Serializable {
    private int level;
    private VillageMap villageMap;
    private ArmyUnit armyUnit;
    private WorkForce workForce;
    private int currentPopulation;
    private int maxPopulationAllowed;
    private int foodAvailable;
    private CollectedResources treasuryAvailable;
    private int totalTrophies;
    private boolean isGuarded = false;
    private Time guardTime;

    /**
     * Class constructor to create a village
     * @param level level of village
     * @param villageMap map of village
     * @param workForce list of peasants
     * @param armyUnit list of attackers
     * @param currentPopulation number of habitants in village
     * @param maxPopulationAllowed maximum number of people allowed in village
     * @param foodAvailable amount of food available
     * @param treasuryAvailable total treasury available
     * @param totalTrophies total trophies won
     * @param isGuarded true if guard is on false otherwise
     * @param guardTime total guard time
     */
    public Village(int level, VillageMap villageMap, WorkForce workForce, ArmyUnit armyUnit, int currentPopulation,
                   int maxPopulationAllowed, int foodAvailable, CollectedResources treasuryAvailable, int totalTrophies,
                   boolean isGuarded, Time guardTime) {
        this.level = level;
        this.villageMap = villageMap;
        this.armyUnit = armyUnit;
        this.currentPopulation = currentPopulation;
        this.maxPopulationAllowed = maxPopulationAllowed;
        this.foodAvailable = foodAvailable;
        this.treasuryAvailable = treasuryAvailable;
        this.totalTrophies = totalTrophies;
        this.isGuarded = isGuarded;
        this.guardTime = guardTime;
        this.workForce=workForce;
    }

    /**
     * Class constructor that creates a new village with the given village map
     * @param villageMap village map for the village
     */
    public Village(VillageMap villageMap) {
        this(1,villageMap,new WorkForce(),new ArmyUnit(),0,5,500,new CollectedResources(2000,2000,2000),
                0,false,null);
    }

    public Village(int level){
        this(level, new VillageMap(),new WorkForce(),new ArmyUnit(),0,5,500,new CollectedResources(2000,2000,2000),
                0,false,null);
    }

    /**
     * Class constructor
     */
    public Village() {
        this(new VillageMap());
    }


    /**
     * This method return the level of village or the village hall (as level of village hall is the level of village)
     * @return Level of village/village hall
     */
    public int getLevel() {
        return level;
    }

    /**
     * This method sets the level of village to given level
     * @param level level of village
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Returns the village map of the village
     * @return village map of village
     */
    public VillageMap getVillageMap() {
        return villageMap;
    }

    /**
     * Sets the village map of the village
     * @param villageMap village map of village
     */
    public void setVillageMap(VillageMap villageMap) {
        this.villageMap = villageMap;
    }

    /**
     * Returns the list of attacker
     * @return list of attackers
     */
    public ArmyUnit getArmyUnit() {
        return armyUnit;
    }

    /**
     * Sets the army unit to given list
     * @param armyUnit list of attackers
     */
    public void setArmyUnit(ArmyUnit armyUnit) {
        this.armyUnit = armyUnit;
    }

    /**
     * Returns list of peasants in the village
     * @return list of peasants
     */
    public WorkForce getWorkForce() {
        return workForce;
    }

    /**
     * Sets the list of peasants
     * @param workForce list of peasants
     */
    public void setWorkForce(WorkForce workForce) {
        this.workForce = workForce;
    }

    /**
     * Returns current population of village
     * @return total population of village
     */
    public int getCurrentPopulation() {
        return currentPopulation;
    }

    /**
     * Sets current population of the village
     * @param currentPopulation population of village
     */
    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    /**
     * Returns max population allowed in the village according to number of farms available
     * @return max population allowed
     */
    public int getMaxPopulationAllowed() {
        return maxPopulationAllowed;
    }

    /**
     * This method sets the maximum allowed population
     * @param maxPopulationAllowed Max allowed population
     */
    public void setMaxPopulationAllowed(int maxPopulationAllowed) {
        this.maxPopulationAllowed = maxPopulationAllowed;
    }

    /**
     * Returns total food available
     * @return total food available
     */
    public int getFoodAvailable() {
        return foodAvailable;
    }

    /**
     * Sets the food available to given number
     * @param foodAvailable quantity of food available
     */
    public void setFoodAvailable(int foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    /**
     * Returns the treasury available in the village as a Cost object
     * @return treasury available
     */
    public CollectedResources getTreasuryAvailable() {
        return treasuryAvailable;
    }

    /**
     * Sets the treasury to the given value
     * @param treasuryAvailable treasury
     */
    public void setTreasuryAvailable(CollectedResources treasuryAvailable) {
        this.treasuryAvailable = treasuryAvailable;
    }

    /**
     * Returns the number of trophies available
     * @return total number of trophies
     */
    public int getTotalTrophies() {
        return totalTrophies;
    }

    /**
     * This method sets the total trophies to given number
     * @param totalTrophies total number of trophies
     */
    public void setTotalTrophies(int totalTrophies) {
        this.totalTrophies = totalTrophies;
    }

    /**
     * Status of the village if it is guarded or not
     * @return Returns true if village is guarded, otherwise false
     */
    public boolean isGuarded() {
        return isGuarded;
    }

    /**
     * Sets the guard of village true or false
     * @param guarded status of guard
     */
    public void setGuarded(boolean guarded) {
        isGuarded = guarded;
    }

    /**
     * Returns the guard time of the village
     * @return guard time
     */
    public Time getGuardTime() {
        return guardTime;
    }

    /**
     * Sets the guard time
     * @param guardTime guard time
     */
    public void setGuardTime(Time guardTime) {
        this.guardTime = guardTime;
    }
}
