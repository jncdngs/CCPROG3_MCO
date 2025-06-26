public class Environment {

    private String name;
    private int playerAtk;
    private int playerDmg;
    private int oppAtk;
    private int oppDef;

    public Environment(String name, int playerAtk, int playerDmg, int oppAtk, int oppDef) {
        this.name = name;
        this.playerAtk = playerAtk;
        this.playerDmg = playerDmg;
        this.oppAtk = oppAtk;
        this.oppDef = oppDef;
    }

    /** @return the name of the environment */
    public String getName() {
        return this.name;
    }

    /** @return the attack points to be added to the player after every turn */
    public int getPlayerAtk() {
        return this.playerAtk;
    }

    /** @return the hit points to be deducted from the player after every turn */
    public int getPlayerDmg() {
        return this.playerDmg;
    }

    /** @return the attack points to be added to the opponent after every turn */
    public int getOppAtk() {
        return this.oppAtk;
    }

    /** @return the defense points to be deducted from the opponent after every turn */
    public int getOppDef() {
        return this.oppDef;
    }

}
