package Game;
import ChallengeDecision.ChallengeResult;
import Models.Village;
import VillageElements.AttackingEntities;
import VillageElements.CollectedResources;
import VillageElements.Recruitable;
import VillageElements.Worker;
import java.awt.*;
import java.io.Serializable;

/**
 * This class represents the arbiter. It will judge an attack so that the output can be measured. To check if the attack
 * was successful or not.
 */
public class AttackManager implements Serializable {
    int totalDamageGiven, totalDamageReceived;

    /**
     * This method judges the attack and makes gives the output of the an attack. It determines how the attack will
     * take place and how much loot the attacker gets, what was the success rate and if the attack was a failure
     *
     * @param attackerArmy Attacking army of the attacker
     * @param defender     Village of the defender
     * @return outcome of the attack
     */
    public ChallengeResult judgeAttack(ArmyUnit attackerArmy, Village defender) {

        int totalInitialHitPointsOfDefender = defender.getVillageMap().getTotalHitPointsOfBuildings();
        int totalInitialHitPointsOfAttacker = attackerArmy.calculateTotalHitPointsOfArmy();

        System.out.println("Attacker total initial hit points ->"+ totalInitialHitPointsOfAttacker +  " defender total initial hit points ->"+ totalInitialHitPointsOfDefender);


        while (attackerArmy.calculateTotalHitPointsOfArmy() >= 0 && defender.getVillageMap().getTotalHitPointsOfBuildings() >= 0) {
            attackerArmy.getArmyUnit().stream().forEach(
                    (member) -> {
                        Worker attackerEntity = (Worker) member;
                        Point positionOfAttackerEntity = attackerEntity.getPoint();

                        defender.getVillageMap().
                                getBuildings().
                                stream().forEach(
                                        (defenderEntity) -> {
                                            Point positionOfDefenderEntity = defenderEntity.getPoint();

                                            if (defenderEntity instanceof AttackingEntities) {
                                                if (positionOfAttackerEntity.distance(positionOfDefenderEntity) <= attackerEntity.getAttackRange()) {
                                                    int newHealthOfDefender = defenderEntity.getHitPoints() - attackerEntity.getDamage();
                                                    int newHealthOfAttacker = attackerEntity.getHitPoints() - ((AttackingEntities) defenderEntity).getDamage();
                                                    defenderEntity.setHitPoints(newHealthOfDefender);
                                                    attackerEntity.setHitPoints(newHealthOfAttacker);
                                                }
                                            } else {
                                                if (positionOfAttackerEntity.distance(positionOfDefenderEntity) <= attackerEntity.getAttackRange()) {
                                                    int newHealthOfDefender = defenderEntity.getHitPoints() - attackerEntity.getDamage();
                                                    defenderEntity.setHitPoints(newHealthOfDefender);
                                                }
                                            }

                                        }
                                );
                    }
            );
        }

        this.totalDamageGiven = totalInitialHitPointsOfDefender-defender.getVillageMap().getTotalHitPointsOfBuildings();
        this.totalDamageReceived = totalInitialHitPointsOfAttacker-attackerArmy.calculateTotalHitPointsOfArmy();

        System.out.println(totalDamageGiven +"<- total damage given   total damage received-> "+totalDamageReceived);

        attackerArmy.getArmyUnit().stream().forEach(
                (fighterEntity) -> {
                    Worker attackerEntity = (Worker) fighterEntity;
                    if (attackerEntity.getHitPoints() == 0) {
                        attackerArmy.remove((Recruitable) attackerEntity);
                    }
                }
        );

        int hitPointsOfDefender = defender.getVillageMap().getTotalHitPointsOfBuildings();
        System.out.println("New hit points of defender =>"+hitPointsOfDefender);
        int damagePercentage = hitPointsOfDefender / totalInitialHitPointsOfDefender * 100;
        System.out.println("total percentage of damage=>"+damagePercentage);
        boolean success = false;
        CollectedResources lootGenerated = new CollectedResources(0, 0, 0);
        if (damagePercentage >= 50) {
            success = true;
            lootGenerated = new CollectedResources(
                    defender.getTreasuryAvailable().getLumber() * damagePercentage / 100,
                    defender.getTreasuryAvailable().getGold() * damagePercentage / 100,
                    defender.getTreasuryAvailable().getIron() * damagePercentage / 100
            );
        }
        //return new AttackOutcome(success, lootGenerated);
        return null;
    }
}
