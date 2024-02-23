package Views;

import Game.ArmyUnit;
import VillageElements.CollectedResources;
import VillageElements.VillageMap;
import Game.WorkForce;

import java.io.Serializable;
import java.sql.Time;

public class VillageView implements Serializable {

    /**
     * This method prints the view of the village.
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
    public void printVillage(int level, VillageMap villageMap, WorkForce workForce, ArmyUnit armyUnit, int currentPopulation,
                             int maxPopulationAllowed, int foodAvailable, CollectedResources treasuryAvailable, int totalTrophies,
                             boolean isGuarded, Time guardTime) {
        System.out.println("Village level: "+level);
        System.out.println("Village current population: "+currentPopulation);
        System.out.println("Village max population: "+maxPopulationAllowed);
        System.out.println("Village food: "+foodAvailable);
        System.out.println("Village treasury: "+treasuryAvailable);
        System.out.println("Village trophies: "+totalTrophies);
        System.out.println("Village guard status: "+isGuarded);
        System.out.println("Village guard time: "+guardTime);

        System.out.println("Village Map Items: ");
        villageMap.getBuildings().forEach(
                System.out::println
        );

        System.out.println("Village army:");
        armyUnit.getArmyUnit().forEach(
                System.out::println
        );

        System.out.println("Village workers:");
        workForce.getWorkers().forEach(
                System.out::println
        );
    }

}
