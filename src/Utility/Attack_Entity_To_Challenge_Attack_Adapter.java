package Utility;

import ChallengeDecision.ChallengeAttack;
import VillageElements.AttackingEntities;

/**
 * This class is an adapter to convert an Attack entity to Challenge Attack entity
 */
public class Attack_Entity_To_Challenge_Attack_Adapter extends ChallengeAttack<Double,Double> {


    AttackingEntities attackingEntities;

    /**
     * Class constructor to create adaptor
     * @param attack attack of the attacking entity
     * @param hit hit points of attacking entity
     */
    public Attack_Entity_To_Challenge_Attack_Adapter(Number attack, Number hit) {
        super((Double) attack, (Double) hit);
    }
    /**
     * Class constructor to create adaptor
     * @param attack attack of the attacking entity
     */
    public Attack_Entity_To_Challenge_Attack_Adapter(Number attack) {
        super((Double) attack);
    }

    /**
     * Class constructor to create adaptor
     */
    public Attack_Entity_To_Challenge_Attack_Adapter(AttackingEntities attackingEntities){
        super((double) attackingEntities.getDamage(), (double) attackingEntities.getHitPoints());
        this.attackingEntities=attackingEntities;
    }

}
