/**
 * Armor equipped by the player.
 * <p>
 * Stores the armor's name, defense buff, and speed penalty.
 * 
 * @author Jon Chester Donguines
 */

public class Armor {

    private String name;
    private int defBuff;
    private int spdPen;

    /**
     * Constructs an armor that the player can equip with given stats.
     * 
     * @param name      the name of the armor
     * @param defBuff   the defense points to be added to the player
     * @param spdPen    the speed points to be deducted from the player
     */
    public Armor(String name, int defBuff, int spdPen) {
        this.name = name;
        this.defBuff = defBuff;
        this.spdPen = spdPen;
        System.out.println("[LOG] Armor \"" + this.name + "\" created");
    }

    /**
     * Returns the name of the armor.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the defense points to be added to the player.
     * 
     * @return the defense points
     */
    public int getDefBuff() {
        return this.defBuff;
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
