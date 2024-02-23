package Utility;

import ChallengeDecision.ChallengeResource;
import VillageElements.NaturalResources;

/**
 * This class is an adapter to convert a resource entity to Challenge resource entity
 */
public class Resource_Entity_To_Challenge_Resource_Adapter extends ChallengeResource<Double,Double> {

    NaturalResources resources;

    /**
     * Class constructor to create adaptor
     * @param resource quantity of the resource entity
     * @param hit hit points of attacking entity
     */
    public Resource_Entity_To_Challenge_Resource_Adapter(Number resource, Number hit) {
        super((Double) resource, (Double) hit);
    }
    /**
     * Class constructor to create adaptor
     * @param resource quantity of the resource entity
     */
    public Resource_Entity_To_Challenge_Resource_Adapter(Number resource) {
        super((Double) resource);
    }

    /**
     * Class constructor to create adaptor
     */
    public Resource_Entity_To_Challenge_Resource_Adapter(NaturalResources resourceEntity){
        super((double) resourceEntity.getQuantity(), (double) resourceEntity.getHitPoints());
        this.resources=resourceEntity;
    }

}
