/**
 * Minotaur opponent type.
 * <p>
 * Extends the Opponent class and overrides the think() method based on 
 * predetermined sequence
 * 
 * @author Jon Chester Donguines
 */

public class Minotaur extends Opponent {
    
    /**
     * Constructs a Minotaur opponent object predetermined base stats.
     */
    public Minotaur() {
        super("Minotaur", 350, 40, 40, 20);
    }
    
    /**
     * Determines the action of the Minotaur (Faux-AI).
     * <p>
     * Checks the current move number and returns the corresponding action 
     * based on a predetermined sequence.
     * <p>
     * Minotaur's pattern is attack, charge, attack
     * 
     * @param moveCounter   the current move number of the game
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    public int think(int moveCounter) {
        if(moveCounter % 3 == 2)
            return 3;
        else
            return 1;
    }

}
