package Game;

import VillageElements.Recruitable;
import VillageElements.Worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ArmyUnit represents the troops available to attack on other villages. It is a list of Recruitable items that can be
 * recruited to the troops for attack
 */
public class ArmyUnit implements Serializable {

    private List<Recruitable> armyUnit; //list of army entities

    /**
     * Class constructor to set the army to given list of recruitable.
     * @param armyUnit list of recruitable
     */
    public ArmyUnit(List<Recruitable> armyUnit){
        this.armyUnit = armyUnit;
    }

    /**
     * Class constructor
     */
    public ArmyUnit(){
        this.armyUnit = new ArrayList<>();
    }

    /**
     * Adds the given recruitable entity to the army
     * @param recruitable recruitable entity to be added
     * @return true if added successfully false otherwise
     */
    public boolean recruit(Recruitable recruitable){
        int size = this.armyUnit.size();
        this.armyUnit.add(recruitable);
        if(armyUnit.size()>size) return true;
        return false;
    }

    /**
     * Removes the given recruitable entity from the army
     * @param recruitable recruitable entity to be removed
     */
    public void remove(Recruitable recruitable){
    }

    /**
     * Calculates total damage that the given army can do.
     * @return total army's damage
     */
    public int calculateTotalDamageOfArmy(){
        AtomicInteger totalDamage=new AtomicInteger();
        this.armyUnit.stream().forEach(worker->{
            Worker worker1 = (Worker)worker;
            totalDamage.addAndGet(worker1.getDamage());
        });
        return totalDamage.intValue();
    }

    /**
     * Calculate total hit points of army
     * @return total army's hit points
     */
    public int calculateTotalHitPointsOfArmy(){
        AtomicInteger totalHitPoints=new AtomicInteger();
        this.armyUnit.stream().forEach(worker->{
            Worker worker1 = (Worker)worker;
            totalHitPoints.addAndGet(worker1.getHitPoints());
        });
        return totalHitPoints.intValue();
    }

    /**
     * This method returns the list of members of army
     * @return list of members of army
     */
    public List<Recruitable> getArmyUnit() {
        return armyUnit;
    }

    /**
     * This method sets the list of members of army to given list
     * @param armyUnit list of recruitable workers
     */
    public void setArmyUnit(List<Recruitable> armyUnit) {
        this.armyUnit = armyUnit;
    }

    /**
     * Remove all the entities from the army unit list
     * @return true if successful, false otherwise
     */
    public boolean removeArmy(){
        return armyUnit.removeAll(this.armyUnit);
    }

    @Override
    public String toString() {
        return "ArmyUnit{" +
                "armyUnit=" + armyUnit +
                '}';
    }
}
