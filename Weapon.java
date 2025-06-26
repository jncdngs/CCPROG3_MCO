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

    public Weapon(String name, int atkBuff, int spdPen) {
        this.name = name;
        this.atkBuff = atkBuff;
        this.spdPen = spdPen;
    }

    /** @return the name of the weapon */
    public String getName() {
        return this.name;
    }

    /** @return the attack points to be added to the player */
    public int getAtkBuff() {
        return this.atkBuff;
    }

    /** @return the speed points to be deducted from the player */
    public int getSpdPen() {
        return this.spdPen;
    }

}
