/**
 * Dagger weapon type.
 * <p>
 * Extends the Dagger class and overrides isDagger() to return true.
 * 
 * @author Jon Chester Donguines
 */

public class Dagger extends Weapon {

    /**
     * Constructs a dagger that the player can equip with predetermined stats.
     */
    public Dagger() {
        super("Dagger", 20, 0);
    }

    /**
     * Returns true if the instance is of type Dagger.
     * 
     * @return true
     */
    public boolean isDagger() {
        return true;
    }

}
