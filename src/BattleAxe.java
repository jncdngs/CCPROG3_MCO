/**
 * Battle Axe weapon equipped by the player.
 * <p>
 * Stores the weapon's name, attack buff, and speed penalty. 
 * 
 * @author Jon Chester Donguines
 */

public class BattleAxe extends Weapon {

    /**
     * Constructs a battle axe that the player can equip with predetermined stats.
     */
    public BattleAxe() {
        super("Battle Axe", 40, 20);
    }

    public void applyAbility(Player player) {

    }

}
