package AbstractFactory;

import ConcurrentAbstractFactory.InvalidWorkerTypeExceptionTypeException;
import VillageElements.*;

/**
 * This class represents a factory that helps in the production of worker entity objects
 */
public class WorkerFactory implements AbstractFactory {
    public static final String SOLDIER= "SOLDIER";
    public static final String KNIGHT = "KNIGHT";
    public static final String MINER= "MINER";
    public static final String FARMER= "FARMER";
    public static final String COLLECTOR= "COLLECTOR";
    public static final String BUILDER = "BUILDER";
    public static final String ARCHER = "ARCHER";


    /**
     * Returns the attacking village entity
     * @param workerType Name of the entity as specified in the implementing factory
     * @return Object of given worker entity
     */
    @Override
    public VillageEntity getVillageEntity(String workerType) throws InvalidWorkerTypeExceptionTypeException {
        return switch (workerType.toUpperCase()) {
            case "ARCHER" -> new Archer();
            case "BUILDER" -> new Builder();
            case "COLLECTOR" -> new Collector();
            case "FARMER" -> new Farmer();
            case "KNIGHT" -> new Knight();
            case "MINER" -> new Miner();
            case "SOLDIER" -> new Soldier();
            default -> throw new InvalidWorkerTypeExceptionTypeException();
        };
    }
}
