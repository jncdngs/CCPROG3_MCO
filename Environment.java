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

    public String getName() {
        return this.name;
    }

    public int getPlayerAtk() {
        return this.playerAtk;
    }

    public int getPlayerDmg() {
        return this.playerDmg;
    }

    public int getOppAtk() {
        return this.oppAtk;
    }

    public int getOppDef() {
        return this.oppDef;
    }

}
