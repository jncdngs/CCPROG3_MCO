/**
 * Character controlled by the opponent.
 * <p>
 * Stores the opponent's name, armor, weapon, and stats. 
 * Handles the actions made by the opponent and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public class Viking extends Opponent {
    
    /**
     * Constructs a Viking opponent object predetermined base stats.
     */
    public Viking() {
        super("Viking", 250, 30, 30, 30);
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
        if(moveCounter % 3 == 2)
            return 2;
        else
            return 1;
    }

}
