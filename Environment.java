public class Environment {

    private String name;
    private int playerAtk;
    private int playerDmg;
    private int oppAtk;
    private int oppDmg;

    public Environment(String name, int playerAtk, int playerDmg, int oppAtk, int oppDmg) {
        this.name = name;
        this.playerAtk = playerAtk;
        this.playerDmg = playerDmg;
        this.oppAtk = oppAtk;
        this.oppDmg = oppDmg;
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

    public int getOppDmg() {
        return this.oppDmg;
    }
    
}
