package Utility;

import ChallengeDecision.ChallengeResource;
import ChallengeDecision.ChallengeResult;
import Game.AttackOutcome;

import java.util.List;

public class ChallengeResult_To_AttackOutcome_Adapter extends ChallengeResult {
    AttackOutcome attackOutcome;
    public ChallengeResult_To_AttackOutcome_Adapter(Boolean won, List<ChallengeResource<Double, Double>> loot) {
        super(won, loot);
        loot.forEach(
                (item)->{
                    double resource = item.getProperty();
                    double hitpoints = item.getHitPoints();

                }
        );
        attackOutcome = new AttackOutcome(won,null);
    }


}
