package Controllers;

import Game.ArmyUnit;
import Game.WorkForce;
import Models.Village;
import Views.VillageView;
import VillageElements.*;

import javax.naming.InsufficientResourcesException;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import static VillageElements.PropertyReader.readPropertiesFile;

public class VillageController implements Serializable {

    private Village village;
    private VillageView villageView;

    /**
     * Class constructor to create a controller
     * @param village village model
     * @param villageView village view
     */
    public VillageController(Village village, VillageView villageView) {
        this.village = village;
        this.villageView=villageView;
    }

    /**
     * This method prints the updated view of the village.
     */
    public void updateView(){
        villageView.printVillage(village.getLevel(), village.getVillageMap(), village.getWorkForce(), village.getArmyUnit(),
                village.getCurrentPopulation(), village.getMaxPopulationAllowed(), village.getFoodAvailable(),
                village.getTreasuryAvailable(), village.getTotalTrophies(), village.isGuarded(),
                village.getGuardTime());
    }

    public VillageView getVillageView(){
        return this.villageView;
    }


    /**
     * This method return the level of village or the village hall (as level of village hall is the level of village)
     * @return Level of village/village hall
     */
    public int getLevel() {
        return village.getLevel();
    }

    /**
     * This method sets the level of village to given level
     * @param level level of village
     */
    public void setLevel(int level) {
        this.village.getLevel();
    }

    /**
     * Returns the village map of the village
     * @return village map of village
     */
    public VillageMap getVillageMap() {
        return village.getVillageMap();
    }

    /**
     * Sets the village map of the village
     * @param villageMap village map of village
     */
    public void setVillageMap(VillageMap villageMap) {
        village.setVillageMap(villageMap);
    }

    /**
     * Returns the list of attacker
     * @return list of attackers
     */
    public ArmyUnit getArmyUnit() {
        return village.getArmyUnit();
    }

    /**
     * Sets the army unit to given list
     * @param armyUnit list of attackers
     */
    public void setArmyUnit(ArmyUnit armyUnit) {
        village.setArmyUnit(armyUnit);
    }

    /**
     * Returns list of peasants in the village
     * @return list of peasants
     */
    public WorkForce getWorkForce() {
        return village.getWorkForce();
    }

    /**
     * Sets the list of peasants
     * @param workForce list of peasants
     */
    public void setWorkForce(WorkForce workForce) {
        village.setWorkForce(workForce);
    }

    /**
     * Returns current population of village
     * @return total population of village
     */
    public int getCurrentPopulation() {
        return village.getCurrentPopulation();
    }

    /**
     * Sets current population of the village
     * @param currentPopulation population of village
     */
    public void setCurrentPopulation(int currentPopulation) {
        village.setCurrentPopulation(currentPopulation);
    }

    /**
     * Returns max population allowed in the village according to number of farms available
     * @return max population allowed
     */
    public int getMaxPopulationAllowed() {
        return village.getMaxPopulationAllowed();
    }

    /**
     * This method sets the maximum allowed population
     * @param maxPopulationAllowed Max allowed population
     */
    public void setMaxPopulationAllowed(int maxPopulationAllowed) {
        village.setMaxPopulationAllowed(maxPopulationAllowed);
    }

    /**
     * Returns total food available
     * @return total food available
     */
    public int getFoodAvailable() {
        return village.getFoodAvailable();
    }

    /**
     * Sets the food available to given number
     * @param foodAvailable quantity of food available
     */
    public void setFoodAvailable(int foodAvailable) {
        village.setFoodAvailable(foodAvailable);
    }

    /**
     * Returns the treasury available in the village as a Cost object
     * @return treasury available
     */
    public CollectedResources getTreasuryAvailable() {
        return village.getTreasuryAvailable();
    }

    /**
     * Sets the treasury to the given value
     * @param treasuryAvailable treasury
     */
    public void setTreasuryAvailable(CollectedResources treasuryAvailable) {
        village.setTreasuryAvailable(treasuryAvailable);
    }

    /**
     * Returns the number of trophies available
     * @return total number of trophies
     */
    public int getTotalTrophies() {
        return village.getTotalTrophies();
    }

    /**
     * This method sets the total trophies to given number
     * @param totalTrophies total number of trophies
     */
    public void setTotalTrophies(int totalTrophies) {
        village.setTotalTrophies(totalTrophies);
    }

    /**
     * Status of the village if it is guarded or not
     * @return Returns true if village is guarded, otherwise false
     */
    public boolean isGuarded() {
        return village.isGuarded();
    }

    /**
     * Sets the guard of village true or false
     * @param guarded status of guard
     */
    public void setGuarded(boolean guarded) {
        village.setGuarded(guarded);
    }

    /**
     * Returns the guard time of the village
     * @return guard time
     */
    public Time getGuardTime() {
        return village.getGuardTime();
    }

    /**
     * Sets the guard time
     * @param guardTime guard time
     */
    public void setGuardTime(Time guardTime) {
        village.setGuardTime(guardTime);
    }


    /**
     * This method adds the peasant to the village work force
     * @param worker peasant
     */
    public void addWorker(Peasant worker){
        //village.setCurrentPopulation(village.getCurrentPopulation()+1);
        //village.getWorkForce().addWorker(worker);
        Worker worker1 = (Worker) worker;
        try {
            addHabitant(worker1);
        } catch (InsufficientResourcesException e) {
            System.out.println("Cannot add work force due to insufficient resources or max allowed population reached");
        }
    }

    /**
     * This method add attacker to the army unit
     * @param recruitable attacker
     */
    public void addArmy(Recruitable recruitable){
        //village.setCurrentPopulation(village.getCurrentPopulation()+1);
        //village.getArmyUnit().recruit(recruitable);\
        Worker worker1 = (Worker) recruitable;

        try {
            addHabitant( worker1);
        } catch (InsufficientResourcesException e) {
            System.out.println("Cannot add to army due to insufficient resources or max allowed population reached");
        }
    }

    /**
     * this method adds a new building to the map
     * @param building building
     */
    public boolean addBuilding(Building building){
        return addBuilding2(building);
    }

    /**
     * This method adds the Worker entity to the village only if it is possible to do so(depend on the number of farms
     * available and if sufficient funds are available).
     * @param worker Worker to be added
     * @param <T>
     * @return
     */
    public <T extends Worker> boolean addHabitant(T worker) throws InsufficientResourcesException {
        CollectedResources entityCost = worker.getProductionCost();
        int foodAvailable = village.getFoodAvailable();
        int foodRequiredForProduction = worker.getFeedingQuantity();
        int currentPopulation= village.getCurrentPopulation();
        int maxPopulationAllowed = village.getMaxPopulationAllowed();

//        System.out.println();
//        System.out.println(foodAvailable+" food available");
//        System.out.println(foodRequiredForProduction+" required for production");
//        System.out.println("Current population: "+currentPopulation+" Max population is:"+maxPopulationAllowed);
//        System.out.println();

        if(currentPopulation<maxPopulationAllowed && foodAvailable>=foodRequiredForProduction){
            if( entityCost.compareTo(village.getTreasuryAvailable())<=0){
                System.out.println(entityCost);

                village.setFoodAvailable(foodAvailable-foodRequiredForProduction);
                village.setTreasuryAvailable(village.getTreasuryAvailable().subCost(entityCost));

                if(worker instanceof Recruitable) village.getArmyUnit().recruit((Recruitable) worker);

                village.setCurrentPopulation(++currentPopulation);

                return true;
            }
            else {
                throw new InsufficientResourcesException();
            }
        }
        else {
          throw new InsufficientResourcesException();
        }
    }

    /**
     * This method adds the entities like new infrastructure, defence, resources etc. (everything except Workers)
     * to the village only if it is possible to do so(town hall level check and funds are available).
     * @param building Entity to be added
     * @return true if it was added successfully false otherwise.
     */
    private boolean addBuilding2(Building building){
        try {
            String className = getFullyQualifiedClassName(building);
            CollectedResources entityCost = building.getProductionCost();
            if(!isMaxPossibleCountReached(className)){
                if( entityCost.compareTo(village.getTreasuryAvailable())<=0){
                    village.getVillageMap().addBuilding((Building) building);
                    village.getTreasuryAvailable().subCost(entityCost);
                    if(building instanceof Farm farm){
                        village.setFoodAvailable(farm.getQuantity()+ village.getFoodAvailable());
                        village.setMaxPopulationAllowed(village.getMaxPopulationAllowed()+farm.getSizeFedPerFarm());
                    }
                    return true;
                }
                else {
                    System.out.println("Cannot add given entity: "+building+" due to Insufficient funds");
                    return false;
                }
            }
            else {
                System.out.println("Cannot add given entity: "+building+" as you have reached maximum holding at this town hall level");
                return false;
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method returns the fully qualified class name of the passed object
     * @param obj Object for which qualified name is required
     * @return fully qualified name of the class of object
     */
    public static String getFullyQualifiedClassName(Object obj) {
        return obj.getClass().getName();
    }

    /**
     * This method checks if the maximum limit to have a particular entity has already reached.
     * @param className fully qualified name of the class ex. VillageElements.Farm
     * @return true if the capacity has reached false otherwise
     * @throws ClassNotFoundException This method throws ClassNotFoundException if the passed string name of class is not found
     */
    public <T extends VillageEntity> boolean isMaxPossibleCountReached(String className) throws ClassNotFoundException, IOException {
        int villageHallLevel = village.getLevel();
        String propertyName = "max."+className+".at.level."+villageHallLevel;
        int maxEntityAllowedAtThisVillageHallLevel = Integer.parseInt(readPropertiesFile().getProperty(propertyName));
        return containsElementOfType(village.getVillageMap().getBuildings(), className) >= maxEntityAllowedAtThisVillageHallLevel;
    }

    /**
     * This method returns the number of times an object of given class type exists in the given list of village entities
     * if no object of such type exist then it returns 0.
     * @param entities list of Village Entities
     * @param className absolute name of the class
     * @param <T> The type of class modeled by the list (subtypes of village entity)
     * @return number of times the object of given type appears in the given list
     * @throws ClassNotFoundException Throws ClassNotFoundException if the parsed string does not match any class name of VillageEntity type.
     */
    public <T extends VillageEntity> int containsElementOfType(List<T> entities, String className) throws ClassNotFoundException {
        Class<?> classType = Class.forName(className);
        int counter = 0;
        for (VillageEntity item : entities) {
            if (item != null && item.getClass().equals(classType)) {
                counter++;
            }
        }
        return counter;
    }
    /**
     * This method upgrades the level of village
     */
    public boolean upgradeVillage() throws UpgradeCancelledDueToMaxedOutException {
        if(village.getTreasuryAvailable().compareTo(new CollectedResources(100,100,100)) <= 0){
            System.out.println("Insufficient funds");
            return false;

        }else {
            if (village.getVillageMap().villageHall.getLevel()>=village.getVillageMap().villageHall.getMaxLevel()) {
                throw new UpgradeCancelledDueToMaxedOutException();
            }
                village.setTreasuryAvailable(new CollectedResources(
                    village.getTreasuryAvailable().getLumber()-100,
                    village.getTreasuryAvailable().getIron()-100,
                    village.getTreasuryAvailable().getGold()-100
            ));
            village.setLevel(village.getLevel()+1);
            village.getVillageMap().villageHall.upgrade();
            return true;
        }
    }

    public Village getVillage(){return this.village;}

}
