public class Game {

    private String playerName;
    private int armorOpt;
    private int weaponOpt;
    private int envOpt;
    private int oppOpt;

    private Player player;
    private Armor armor;
    private Weapon weapon;
    private Environment env;
    private Opponent opp;

    // public Game(String playerName, int armorOpt, int weaponOpt, int envOpt, int oppOpt) {
    //     this.playerName = playerName;
    //     this.armorOpt = armorOpt;
    //     this.weaponOpt = weaponOpt;
    //     this.envOpt = envOpt;
    //     this.oppOpt = oppOpt;
    // }

    // public Player getPlayer() {
    //     return this.player;
    // }

    // public Armor getArmor() {
    //     return this.armor;
    // }

    // public Weapon getWeapon() {
    //     return this.weapon;
    // }

    // public Environment getEnv() {
    //     return this.env;
    // }

    // public Opponent getOpp() {
    //     return this.opp;
    // }


    
    public void displayPlayerStats() {
        System.out.println("\nPlayer");
        System.out.println("Name:    " + player.getName());
        System.out.println("Armor:   " + player.getArmor().getName());
        System.out.println("Weapon:  " + player.getWeapon().getName());
        System.out.println("HP:      " + player.getHp());
        System.out.println("Attack:  " + player.getAtk());
        System.out.println("Defense: " + player.getDef());
        System.out.println("Speed:   " + player.getSpd());
    }

    public void displayOppStats() {
        System.out.println("\nOpponent");
        System.out.println("Name:    " + opp.getName());
        System.out.println("HP:      " + opp.getHp());
        System.out.println("Attack:  " + opp.getAtk());
        System.out.println("Defense: " + opp.getDef());
        System.out.println("Speed:   " + opp.getSpd());
    }

    public void setup(String playerName, int armorOpt, int weaponOpt, int envOpt, int oppOpt) {
        player = new Player(playerName, 100, 1, 1, 50);

        switch(armorOpt) {
            case 1:
                armor = new Armor("Light", 20, 5);
                break;
        
            case 2:
                armor = new Armor("Medium", 30, 15);
                break;
        
            case 3:
                armor = new Armor("Heavy", 40, 25);
                break;        
        }

        switch(weaponOpt) {
            case 1:
                weapon = new Weapon("Dagger", 20, 0);
                break;
        
            case 2:
                weapon = new Weapon("Sword", 30, 10);
                break;
        
            case 3:
                weapon = new Weapon("Battle Axe", 40, 20);
                break;        
        }

        switch(envOpt) {
            case 1:
                env = new Environment("Arena", 0, 0, 0, 0);
                break;
        
            case 2:
                env = new Environment("Swamp", 0, 1, 1, 0);
                break;
        
            case 3:
                env = new Environment("Colosseum", 1, 0, 0, 1);
                break;        
        }

        switch(oppOpt) {
            case 1:
                opp = new Opponent("Thief", 150, 20, 20, 40);
                break;
        
            case 2:
                opp = new Opponent("Viking", 250, 30, 30, 30);
                break;
        
            case 3:
                opp = new Opponent("Minotaur", 350, 40, 40, 20);
                break;        
        }

        player.setArmor(armor);
        player.setWeapon(weapon);

        displayPlayerStats();
        displayOppStats();
    }

    // private Armor light = new Armor("Light", 20, 5);
    // private Armor medium = new Armor("Medium", 30, 15);
    // private Armor heavy = new Armor("Heavy", 40, 25);
    
    // private Weapon dagger = new Weapon("Dagger", 20, 0);
    // private Weapon sword = new Weapon("Sword", 30, 10);
    // private Weapon axe = new Weapon("Battle Axe", 40, 20);
    
    // private Opponent thief = new Opponent("Thief", 150, 20, 20, 40);
    // private Opponent viking = new Opponent("Viking", 250, 30, 30, 30);
    // private Opponent minotaur = new Opponent("Minotaur", 350, 40, 40, 20);
    
}
