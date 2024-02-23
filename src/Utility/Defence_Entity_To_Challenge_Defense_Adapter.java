package Utility;

import ChallengeDecision.ChallengeDefense;
import VillageElements.AttackingEntities;

/**
 * This class is an adapter to convert an Attack entity to Challenge Defense entity
 */
public class Defence_Entity_To_Challenge_Defense_Adapter extends ChallengeDefense<Double,Double> {

    AttackingEntities defenceEntities;

    /**
     * Class constructor to create adaptor
     * @param defense attack of the defence entity
     * @param hit hit points of attacking entity
     */
    public Defence_Entity_To_Challenge_Defense_Adapter(Number defense, Number hit) {
        super((Double) defense, (Double) hit);
    }
    /**
     * Class constructor to create adaptor
     * @param defense defence of the attacking entity
     */
    public Defence_Entity_To_Challenge_Defense_Adapter(Number defense) {
        super((Double) defense);
    }

    /**
     * Class constructor to create adaptor
     */
    public Defence_Entity_To_Challenge_Defense_Adapter(AttackingEntities defenceEntities){
        super((double) defenceEntities.getDamage(), (double) defenceEntities.getHitPoints());
        this.defenceEntities=defenceEntities;
    }



}
