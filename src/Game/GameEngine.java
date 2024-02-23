package Game;

import AbstractFactory.*;
import AbstractFactory.WorkerFactory;
import ConcurrentAbstractFactory.InvalidVillageEntityTypeException;
import Controllers.VillageController;
import Models.Village;
import Views.VillageView;
import VillageElements.*;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

import static AbstractFactory.WorkerFactory.*;


/**
 * This Game engine controls all game actions and has all the logic for the game. It controls all the attacks, upgrades,
 * constructions, termination time for upgrades and production. It also calculates the success of attacks, calculates the
 * loot and generate possible villages to attack.
 */
public class GameEngine implements Serializable {
    private final AbstractFactory workerFactory, buildingFactory;

    public GameEngine() {
        workerFactory = new WorkerFactory();
        buildingFactory = new BuildingFactory();
    }


    /**
     * This method returns a random unit of army
     *
     * @param size size of required army
     * @return random army unit.
     */
    public ArmyUnit getRandomArmyUnit(int size) {
        ArmyUnit armyUnit = new ArmyUnit();


        Random random = new SecureRandom();

        for (int i = 0; i < size; i++) {
            int randomChoice = random.nextInt(1, 4);
            switch (randomChoice) {
                case 1 -> {
                    try {
                        armyUnit.recruit((Recruitable) workerFactory.getVillageEntity(ARCHER));
                    } catch (ConcurrentAbstractFactory.InvalidVillageEntityTypeException |
                             InvalidBuildingTypeExceptionTypeException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 2 -> {
                    try {
                        armyUnit.recruit((Recruitable) workerFactory.getVillageEntity(SOLDIER));
                    } catch (ConcurrentAbstractFactory.InvalidVillageEntityTypeException |
                             InvalidBuildingTypeExceptionTypeException e) {
                        throw new RuntimeException(e);
                    }
                }

                case 3 -> {
                    try {
                        armyUnit.recruit((Recruitable) workerFactory.getVillageEntity(KNIGHT));
                    } catch (ConcurrentAbstractFactory.InvalidVillageEntityTypeException |
                             InvalidBuildingTypeExceptionTypeException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }

        return armyUnit;
    }

    /**
     * This method creates a new village controller with a random village
     * @param level level of village required
     * @return village controller
     */
    public VillageController getRandomVillage(int level)  {
        Random random = new SecureRandom();
        VillageController randomVillage = new VillageController(new Village(level), new VillageView());
        CollectedResources randomCollectedResource =
                new CollectedResources(random.nextInt(10000,50000),
                random.nextInt(10000,50000),
                random.nextInt(10000,50000));
        randomVillage.setTreasuryAvailable(randomCollectedResource);

        randomVillage.setTotalTrophies(random.nextInt(500));

        //add random number of farm
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.FARM));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Lumber Mill
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.LUMBER_MILL));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Iron Mine
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.IRON_MINE));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Gold Mine
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.GOLD_MINE));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Archer Tower
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.ARCHER_TOWER));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Cannon
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.CANNON));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }
        //add random number of Catapult
        for (int i = 0; i < random.nextInt(0, level+1); i++) {
            try {
                randomVillage.addBuilding((Building) buildingFactory.getVillageEntity(BuildingFactory.CATAPULT));
            } catch (InvalidVillageEntityTypeException | InvalidBuildingTypeExceptionTypeException e) {
                throw new RuntimeException(e);
            }
        }


        return randomVillage;

    }

}
