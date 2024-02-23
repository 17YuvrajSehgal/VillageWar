/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author robson
 */
public class Arbitrer {
    public static ChallengeResult challengeDecide( ChallengeEntitySet<Double,Double> challenger,
                                                   ChallengeEntitySet<Double,Double> challengee ) {
        ChallengeResult challengeResult = new ChallengeResult( false );
        int i = 0, j = 0, challengerSize, challengeeSize;
        FightResult fr;
        ChallengeEntity tempCE;
        Boolean challengerTurn = true;
        double challengerPower = 0;
        List<ChallengeResource<Double,Double>> resultingResources = new ArrayList<>();
        
        challengerSize = challenger.getEntityAttackList().size();
        challengeeSize = challengee.getEntityDefenseList().size();
        //System.out.println("challengee Size="+challengeeSize+"        challenger Size="+challengerSize);

        for ( ChallengeAttack ce : challenger.getEntityAttackList() )
            challengerPower += ce.getProperty().doubleValue();
        //System.out.println("challengerPower = "+challengerPower);
        
        if ( challengerSize > 0 ) {
            tempCE = challenger.getEntityAttackList().get( i++ );
            
            while ( i < challengerSize && j < challengeeSize ) {
                if ( challengerTurn ) { //tempCE is the challenger
                    fr = tempCE.fight( challengee.entityDefenseList.get( j ) );
                    challengerTurn = fr.getResult();
                    tempCE = fr.getChallengeEntity();
                    if ( challengerTurn )
                        j++;
                    else i++;
                } else { //tempCE is the challengee
                    fr = challenger.getEntityAttackList().get( i ).fight( tempCE );
                    challengerTurn = fr.getResult();
                    tempCE = fr.getChallengeEntity();
                    if ( challengerTurn )
                        j++;
                    else i++;
                }
            }
            
            // check what is remaining
            
            if ( i < challengerSize ) { // 1 - there are still reamaining challengers
                double sum = 0;
                double proportion;
                
                while ( i < challengerSize ) {
                    sum += challenger.getEntityAttackList().get( i++ ).getProperty().doubleValue();
                }

                proportion = sum / challengerPower;

                challengee.getEntityResourceList().forEach((ce) -> {
                    resultingResources.add( new ChallengeResource( ce.getProperty().doubleValue() * ( proportion * getLootChance() ) ) );
                });
                
                challengeResult = new ChallengeResult( true, resultingResources );
            } else if ( j < challengerSize ) { // 2 - there are still reamaining challengees
                // no resources got back from attack
                challengeResult = new ChallengeResult( false );
            }
            
        }
        //System.out.println(true);
        //System.out.println(resultingResources);
        return challengeResult;
    }
    
    private static double getLootChance() {
        return ( ThreadLocalRandom.current().nextInt(1, 10 ) + 10 ) / 20.0;
    }
}
