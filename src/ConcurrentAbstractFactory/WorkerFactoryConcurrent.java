package ConcurrentAbstractFactory;

import VillageElements.*;

import java.io.Serializable;

/**
 * This class represents a factory that helps in the production of worker entity objects
 */
public class WorkerFactoryConcurrent implements AbstractFactoryConcurrent, Runnable {
    public static final String SOLDIER = "SOLDIER";
    public static final String KNIGHT = "KNIGHT";
    public static final String MINER = "MINER";
    public static final String FARMER = "FARMER";
    public static final String COLLECTOR = "COLLECTOR";
    public static final String BUILDER = "BUILDER";
    public static final String ARCHER = "ARCHER";

    private final String workerType;
    private VillageEntity villageEntity;

    public WorkerFactoryConcurrent(String workerType) {
        this.workerType = workerType;
    }


    @Override
    public void run() {
        switch (workerType.toUpperCase()) {
            case "ARCHER" -> villageEntity = new Archer();
            case "BUILDER" -> villageEntity = new Builder();
            case "COLLECTOR" -> villageEntity = new Collector();
            case "FARMER" -> villageEntity = new Farmer();
            case "KNIGHT" -> villageEntity = new Knight();
            case "MINER" -> villageEntity = new Miner();
            case "SOLDIER" -> villageEntity = new Soldier();
            default -> villageEntity = null;
        }
    }

    public Worker getWorker() {
        return (Worker) villageEntity;
    }


    /**
     * Returns the attacking village entity
     *
     * @param workerType Name of the entity as specified in the implementing factory
     * @return Object of given worker entity
     */
    @Override
    public VillageEntity getVillageEntity(String workerType) {
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return villageEntity;
    }

}
