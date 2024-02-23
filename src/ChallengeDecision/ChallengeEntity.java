/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengeDecision;

import java.io.Serializable;

/**
 *
 * @author robson
 */
public abstract class ChallengeEntity<T extends Number, V extends Number> implements Serializable {
    
    public abstract T getProperty();
    
    public abstract void setProperty( T property );
    
    public abstract V getHitPoints();
    
    public abstract void setHitPoints( V value );

    public abstract int compare( ChallengeEntity ce );

    public abstract FightResult fight( ChallengeEntity<T,V> ce );
    
    public abstract double checkDifference( ChallengeEntity ce );


}
