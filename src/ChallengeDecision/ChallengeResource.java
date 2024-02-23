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
 * @param <T>
 */
public class ChallengeResource <T extends Number, V extends Number> extends ChallengeEntity<T,V>  {
    T resource;
    V hit;
    
    public ChallengeResource() {
    }
    
    public ChallengeResource( T resource ) {
        this.resource = resource;
    }
    
    public ChallengeResource( T resource, V hit ) {
        this.resource = resource;
        this.hit = hit;
    }
    
    @Override
    public T getProperty() {
        return this.resource;
    }
    
    @Override
    public void setProperty( T resource ) {
        this.resource = resource;
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
        result = this.resource.doubleValue() - ce.getProperty().doubleValue();
        
        if ( result == 0 ) 
            return 0;
        else if ( result > 0 ) 
            return 1;
        else return -1;
    }

    @Override
    public double checkDifference( ChallengeEntity ce ) {
        return this.resource.doubleValue() - ce.getProperty().doubleValue();
    }

    @Override
    public FightResult fight(ChallengeEntity<T, V> ce) {
        return new FightResult( false, new ChallengeDefense( 0 ) );
    }
    
    public void print() {
        System.out.println( "Resource: " + resource + " / Hit: " + hit );
    }
}
