/**
 * Weapon equipped by the player.
 * <p>
 * Stores the weapon's name, attack buff, and speed penalty. 
 * 
 * @author Jon Chester Donguines
 */

public class Weapon {

    private String name;
    private int atkBuff;
    private int spdPen;

    /**
     * Constructs a weapon that the player can equip with given stats.
     * 
     * @param name      the name of the armor
     * @param atkBuff   the attack points to be added to the player
     * @param spdPen    the speed points to be deducted from the player
     */
    public Weapon(String name, int atkBuff, int spdPen) {
        this.name = name;
        this.atkBuff = atkBuff;
        this.spdPen = spdPen;
        System.out.println("[LOG] Weapon \"" + this.name + "\" created");
    }

    public void applyAbility(Player player) {
        
    }



    /**
     * Returns the name of the weapon.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the attack points to be added to the player.
     * 
     * @return the attack points
     */
    public int getAtkBuff() {
        return this.atkBuff;
    }

    /**
     * Returns the speed points to be deducted from the player.
     * 
     * @return the speed points
     */
    public int getSpdPen() {
        return this.spdPen;
    }

}
