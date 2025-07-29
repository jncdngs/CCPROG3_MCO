/**
 * Thief opponent type.
 * <p>
 * Extends the Opponent class and overrides the think() method based on 
 * predetermined sequence
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
     * Determines the action of the Thief (Faux-AI).
     * <p>
     * Checks the current move number and returns the corresponding action 
     * based on a predetermined sequence.
     * <p>
     * Thief attacks continuously.
     * 
     * @param moveCounter   the current move number of the game
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    public int think(int moveCounter) {
        return 1;
    }

}
