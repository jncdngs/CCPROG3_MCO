/**
 * Dagger weapon equipped by the player.
 * <p>
 * Stores the weapon's name, attack buff, and speed penalty. 
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

    public void applyAbility(Player player) {

    }

}
