/**
 * Character controlled by the opponent.
 * <p>
 * Stores the opponent's name, armor, weapon, and stats. 
 * Handles the actions made by the opponent and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public class Thief extends Opponent {
    
    /**
     * Constructs a Thief opponent object predetermined base stats.
     */
    public Thief() {
        super("Thief", 150, 20, 20, 40);
    }


    
    /**
     * Determines the action of the opponent (Faux-AI).
     * <p>
     * Checks the current move number and returns the corresponding action 
     * based on a predetermined sequence.
     * 
     * @param moveCounter   the current move number of the game
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    public int think(int moveCounter) {
        return 1;
    }

}
