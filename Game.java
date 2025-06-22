import java.util.Scanner;

public class Game {

    private Player player;
    private Armor armor;
    private Weapon weapon;
    private Environment env;
    private Opponent opp;

    private int currentTurn;

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
        System.out.println("Player");
        System.out.println("Name:    " + player.getName());
        System.out.println("Armor:   " + player.getArmor().getName());
        System.out.println("Weapon:  " + player.getWeapon().getName());
        System.out.println("HP:      " + player.getHp());
        System.out.println("Attack:  " + player.getAtk());
        System.out.println("Defense: " + player.getDef());
        System.out.println("Speed:   " + player.getSpd());
    }

    public void displayOppStats() {
        System.out.println("Opponent");
        System.out.println("Name:    " + opp.getName());
        System.out.println("HP:      " + opp.getHp());
        System.out.println("Attack:  " + opp.getAtk());
        System.out.println("Defense: " + opp.getDef());
        System.out.println("Speed:   " + opp.getSpd());
    }

    public boolean isGameOver() {
        if(player.getHp() == 0 || opp.getHp() == 0)
            return true;
        else
            return false;
    }

    public void applyEnvEffects(Environment env) {
        player.loseHp(env.getPlayerDmg());
        player.gainAtk(env.getPlayerAtk());
        opp.gainAtk(env.getOppAtk());
        opp.loseDef(env.getOppDef());
    }   

    public void setup() {
        String playerName;
        int armorOpt;
        int weaponOpt;
        int envOpt;
        int oppOpt;
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("\033[H\033[J\033[3J");
        System.out.print("Enter name of player: ");
        playerName = sc.nextLine();

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tDefense\t\tSpeed");
            System.out.println("[1] Light Armor\t\t+20\t\t-5");
            System.out.println("[2] Medium Armor\t+30\t\t-15");
            System.out.println("[3] Heavy Armor\t\t+40\t\t-25\n");
            System.out.print("Choose an armor: ");
            armorOpt = sc.nextInt();
        }
        while(armorOpt < 1 || armorOpt > 3);

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tDefense\t\tSpeed");
            System.out.println("[1] Dagger\t\t+20\t\t0");
            System.out.println("[2] Sword\t\t+30\t\t-10");
            System.out.println("[3] Battle Axe\t\t+40\t\t-20\n");
            System.out.print("Choose a weapon: ");
            weaponOpt = sc.nextInt();
        }
        while(weaponOpt < 1 || weaponOpt > 3);

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tPlayer\t\tOpponent");
            System.out.println("[1] Arena\t\tNone\t\tNone");
            System.out.println("[2] Swamp\t\t-1 dmg/turn\t+1 atk/turn");
            System.out.println("[3] Colosseum\t\t+1 atk/turn\t-1 def/turn\n");
            System.out.print("Choose an environment: ");
            envOpt = sc.nextInt();
        }
        while(envOpt < 1 || envOpt > 3);

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tHP\t\tAttack\t\tDefense\t\tSpeed");
            System.out.println("[1] Thief\t\t150\t\t20\t\t20\t\t40");
            System.out.println("[2] Viking\t\t250\t\t30\t\t30\t\t30");
            System.out.println("[3] Minotaur\t\t350\t\t40\t\t40\t\t20\n");
            System.out.print("Choose an opponent: ");
            oppOpt = sc.nextInt();
        }
        while(oppOpt < 1 || oppOpt > 3);
        
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
        player.setAtkMult(1);
        opp.setAtkMult(1);

        displayPlayerStats();
        displayOppStats();
    }

    public void start() {   
        currentTurn = 0;
        
        while(!isGameOver()) {
            // ask player for action
            // ask opp for action
            // check if defend
            // compare speed
            // execute actions in order
            // check if game is over
                // if over, check winner
            // move turn
        }
    }    
}
