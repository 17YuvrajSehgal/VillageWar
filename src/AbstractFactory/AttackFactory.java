package AbstractFactory;

import ConcurrentAbstractFactory.InvalidDefenceTypeExceptionTypeException;
import VillageElements.*;

/**
 * This class represents a factory that helps in the production of attacking entity objects
 */
public class AttackFactory implements AbstractFactory {
    public static final String CATAPULT= "CATAPULT";
    public static final String CANNON= "CANNON";
    public static final String SOLDIER= "SOLDIER";
    public static final String KNIGHT = "KNIGHT";
    public static final String MINER= "MINER";
    public static final String FARMER= "FARMER";
    public static final String COLLECTOR= "COLLECTOR";
    public static final String BUILDER = "BUILDER";
    public static final String ARCHER_TOWER = "ARCHER TOWER";
    public static final String ARCHER = "ARCHER";


    /**
     * Returns the attacking village entity
     * @param attackType Name of the entity as specified in the implementing factory
     * @return Object of given attacking entity
     * @throws InvalidDefenceTypeExceptionTypeException throws runtime exception if name does not match required entity
     */
    @Override
    public VillageEntity getVillageEntity(String attackType) throws InvalidDefenceTypeExceptionTypeException {
        return switch (attackType.toUpperCase()) {
            case "ARCHER" -> new Archer();
            case "BUILDER" -> new Builder();
            case "COLLECTOR" -> new Collector();
            case "FARMER" -> new Farmer();
            case "KNIGHT" -> new Knight();
            case "MINER" -> new Miner();
            case "SOLDIER" -> new Soldier();
            case "ARCHER TOWER" -> new ArcherTower();
            case "CANNON" -> new Cannon();
            case "CATAPULT" -> new Catapult();
            default -> throw new InvalidDefenceTypeExceptionTypeException();
        };
    }
}
