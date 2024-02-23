package Game;

import Models.Village;

import java.util.Random;

/**
 * This class represents a Player Entity in the game. Each player can have atmost 1 village on the same
 * id.
 */
public class Player {
    Village village;
    int PLAYER_ID;

    /**
     * Class Constructor
     * @param village Player's village
     * @param PLAYER_ID Player's id
     */
    public Player(Village village, int PLAYER_ID) {
        this.village = village;
        this.PLAYER_ID = PLAYER_ID;
    }

    /**
     * If the player is new, it will get a randomly generated ID
     */
    public Player(){
        Random random = new Random();
        this.PLAYER_ID = random.nextInt();
        this.village = new Village();
    }

}
