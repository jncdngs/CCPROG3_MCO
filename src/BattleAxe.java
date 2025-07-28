/**
 * Battle Axe weapon type.
 * <p>
 * Extends the Weapon class and overrides isBattleAxe() to return true.
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

    /**
     * Returns true if the instance is of type BattleAxe.
     * 
     * @return true
     */
    public boolean isBattleAxe() {
        return true;
    }

}
