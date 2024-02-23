/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author robson
 * @param <T>
 */
public class ChallengeAttack <T extends Number, V extends Number> extends ChallengeEntity<T,V> {
    T attack;
    V hit;
    
    public ChallengeAttack( T attack, V hit ) {
        this.attack = attack;
        this.hit = hit;
    }
    
    public ChallengeAttack( T attack ) {
        this.attack = attack;
    }
    
    @Override
    public T getProperty() {
        return this.attack;
    }
    
    @Override
    public void setProperty( T attack ) {
        this.attack = attack;
    }

    @Override
    public V getHitPoints() {
        return hit;
    }
    
    @Override
    public void setHitPoints( V value ) {
        hit = value;
    }

    @Override
    public int compare( ChallengeEntity ce ) {
        double result;
        result = this.attack.doubleValue() - ce.getProperty().doubleValue();
        
        if ( result == 0 ) 
            return 0;
        else if ( result > 0 ) 
            return 1;
        else return -1;
    }

    @Override
    public double checkDifference( ChallengeEntity ce ) {
        return this.attack.doubleValue() - ce.getProperty().doubleValue();
    }
    
    public FightResult fight( ChallengeEntity<T,V> ce ) {
        Boolean fightOutcome = false;
        ChallengeEntity<Double,Double> re;

        //first find the result: total attack + total hit points -(total property of entity + total hit points of entity)
        double result;
        result = ( attack.doubleValue() + hit.doubleValue() ) - ( ce.getProperty().doubleValue() + ce.getHitPoints().doubleValue() );

        //if
        if ( result > 0 ) {
            if ( result / ( attack.doubleValue() + hit.doubleValue() ) > 0.2 ) { // it won by a large difference
                fightOutcome = ThreadLocalRandom.current().nextInt(1, 100) > 10; //attack success
                if ( fightOutcome ) { //attack success -> attacker remains
                    re = new ChallengeAttack<>( attack.doubleValue() );
                    re.setHitPoints( ce.getHitPoints().doubleValue() * 0.75 );
                } else { //attack fail -> defense remains
                    re = new ChallengeDefense<>( ce.getProperty().doubleValue() );
                    re.setHitPoints( ce.getHitPoints().doubleValue() * 0.3 );
                }
            } else { // it won by a small difference
                fightOutcome = ThreadLocalRandom.current().nextInt(1, 100) > 50; //attack success
                if ( fightOutcome ) { //attack success -> attacker remains
                    re = new ChallengeAttack<>( attack.doubleValue() );
                    re.setHitPoints( ce.getHitPoints().doubleValue() * 0.5 );
                } else { //attack fail -> defense remains
                    re = new ChallengeDefense<>( ce.getProperty().doubleValue() );
                    re.setHitPoints( ce.getHitPoints().doubleValue() * 0.5 );
                }
            }
        } else { // if attack fail then the defense entity gets to keep the health accordingly
            re = new ChallengeDefense<>( ce.getProperty().doubleValue() );
            if ( ( result * -1 ) / ( ce.getProperty().doubleValue() + ce.getHitPoints().doubleValue() ) > 0.5 ) { // it defended by a large difference -> it keeps 80% of health
                re.setHitPoints( ce.getHitPoints().doubleValue() * 0.75 );
            } else { // it defended by a small difference -> it keeps 50% of health
                re.setHitPoints( ce.getHitPoints().doubleValue() * 0.5 );
            }
        }
        
        return new FightResult( fightOutcome, re );
    }


    @Override
    public String toString() {
        return "ChallengeAttack{" +
                "attack=" + attack +
                ", hit=" + hit +
                '}';
    }
}
