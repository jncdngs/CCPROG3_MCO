/**
 * Environment where the game takes place.
 * <p>
 * Stores the environments's name and effects to the player and opponent's attack, damage, and defense. 
 * 
 * @author Jon Chester Donguines
 */

public class Environment {

    private String name;
    private int playerAtk;
    private int playerDmg;
    private int oppAtk;
    private int oppDef;

    /**
     * Constructs an environment where the game takes place with given effects to player and opponent.
     * 
     * @param name          the name of the environment
     * @param playerAtk     the attack the player will gain every turn
     * @param playerDmg     the hit points the player will lose every turn
     * @param oppAtk        the attack the opponent will gain every turn
     * @param oppDef        the defense the opponent will lose every turn
     */
    public Environment(String name, int playerAtk, int playerDmg, int oppAtk, int oppDef) {
        this.name = name;
        this.playerAtk = playerAtk;
        this.playerDmg = playerDmg;
        this.oppAtk = oppAtk;
        this.oppDef = oppDef;
        System.out.println("[LOG] Environment \"" + this.name + "\" created");
    }

    /**
     * Returns the name of the environment.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the attack points to be added to the player after every turn.
     * 
     * @return the attack points
     */
    public int getPlayerAtk() {
        return this.playerAtk;
    }

    /**
     * Returns the hit points to be deducted from the player after every turn.
     * 
     * @return the hit points
     */
    public int getPlayerDmg() {
        return this.playerDmg;
    }

    /**
     * Returns the attack points to be added to the opponent after every turn.
     * 
     * @return the attack points
     */
    public int getOppAtk() {
        return this.oppAtk;
    }

    /**
     * Returns the defense points to be deducted from the opponent after every turn.
     * 
     * @return the defense points
     */
    public int getOppDef() {
        return this.oppDef;
    }

}
