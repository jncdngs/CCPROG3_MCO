/**
 * Sword weapon equipped by the player.
 * <p>
 * Stores the weapon's name, attack buff, and speed penalty. 
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

    public void applyAbility(Player player) {

    }

}
