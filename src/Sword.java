/**
 * Sword weapon type.
 * <p>
 * Extends the Sword class and overrides isSword() to return true.
 * 
 * @author Jon Chester Donguines
 */

public class Sword extends Weapon {

    /**
     * Constructs a sword that the player can equip with predetermined stats.
     */
    public Sword() {
        super("Sword", 30, 10);
    }

    /**
     * Returns true if the instance is of type Sword.
     * 
     * @return true
     */
    public boolean isSword() {
        return true;
    }

}
