import java.util.Scanner;

public class Game {

    private Player player;
    private Environment env;
    private Opponent opp;

    Scanner sc = new Scanner(System.in);
    
    public void displayStats() {
        String[] action = new String[] {"attacked", "defended", "charged"};
        
        System.out.printf("\033[H\033[J\033[3J");

        if(player.getPrevAction() != 0 || opp.getPrevAction() != 0) {
            System.out.println(player.getName() + " " + action[player.getPrevAction() - 1] + "!");
            System.out.println(opp.getName() + " " + action[opp.getPrevAction() - 1] + "!");
        }

        System.out.println("\n=========== Player ===========");
        System.out.println("Name:    " + player.getName());
        System.out.println("Armor:   " + player.getArmor().getName());
        System.out.println("Weapon:  " + player.getWeapon().getName());
        System.out.println("HP:      " + player.getHp());
        System.out.println("Attack:  " + player.getAtk());
        System.out.println("Defense: " + player.getDef());
        System.out.println("Speed:   " + player.getSpd() + "\n");

        System.out.println("========== Opponent ==========");
        System.out.println("Name:    " + opp.getName());
        System.out.println("HP:      " + opp.getHp());
        System.out.println("Attack:  " + opp.getAtk());
        System.out.println("Defense: " + opp.getDef());
        System.out.println("Speed:   " + opp.getSpd() + "\n");
    }

    public void displayWinner(String winner, int moveCounter) {
        System.out.println(winner + " won the game in " + moveCounter + " moves!\n");
    }

    public boolean isGameOver() {
        if(player.getHp() == 0 || opp.getHp() == 0)
            return true;
        else
            return false;
    }

    public boolean compareSpeed(Player player, Opponent opp) {
        return player.getSpd() > opp.getSpd();
    }

    public void applyEnvEffects(Environment env) {
        player.loseHp(env.getPlayerDmg());
        player.gainAtk(env.getPlayerAtk());
        opp.gainAtk(env.getOppAtk());
        opp.loseDef(env.getOppDef());
    }

    public int askAction(String currentTurn) {
        int action;

        do {   
            displayStats();
            System.out.println(currentTurn + "'s turn!\n");
            System.out.println("[1] Attack");
            System.out.println("[2] Defend");
            System.out.println("[3] Charge\n");
            System.out.print("Choose an action: ");
            action = sc.nextInt();
        }
        while(action < 1 || action > 3);

        return action;
    }

    public void setup() {
        Armor armor = null;
        Weapon weapon = null;
        String playerName = null;
        int armorOpt, weaponOpt, envOpt, oppOpt;
        
        System.out.printf("\033[H\033[J\033[3J");
        System.out.print("Enter name of player: ");
        playerName = sc.nextLine();

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tDefense\t\tSpeed");
            System.out.println("[1] Light Armor\t\t+20\t\t-5");
            System.out.println("[2] Medium Armor\t+30\t\t-15");
            System.out.println("[3] Heavy Armor\t\t+40\t\t-25");
            System.out.println("[4] None\t\t0\t\t0\n");
            System.out.print("Choose an armor: ");
            armorOpt = sc.nextInt();
        }
        while(armorOpt < 1 || armorOpt > 4);

        do {
            System.out.printf("\033[H\033[J\033[3J");
            System.out.println("Name\t\t\tAttack\t\tSpeed");
            System.out.println("[1] Dagger\t\t+20\t\t0");
            System.out.println("[2] Sword\t\t+30\t\t-10");
            System.out.println("[3] Battle Axe\t\t+40\t\t-20");
            System.out.println("[4] None\t\t0\t\t0\n");
            System.out.print("Choose a weapon: ");
            weaponOpt = sc.nextInt();
        }
        while(weaponOpt < 1 || weaponOpt > 4);

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
            case 4:
                armor = new Armor("None", 0, 0);
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
            case 4:
                weapon = new Weapon("None", 0, 0);
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
    }

    public void start() {   
        int playerAction, oppAction, moveCounter = 1;
        int prevPlayerAction = 0, prevOppAction = 0;
        boolean isPlayersTurn;
        String winner = null;
        
        while(!isGameOver()) {                       
            // Compare speed of player and opponent
            isPlayersTurn = compareSpeed(player, opp);
            
            // Ask #1 then #2 for action
            if(isPlayersTurn) {
                playerAction = askAction("Player");
                oppAction = askAction("Opponent");
            }
            else {
                oppAction = askAction("Opponent");
                playerAction = askAction("Player");
            }
            
            // Check if someone defended
            if(playerAction == 2)
                isPlayersTurn = true;
            else if(oppAction == 2)
                isPlayersTurn = false;
            
            // Execute actions in order
            if(isPlayersTurn) {
                switch(playerAction) {
                    case 1:
                        player.attack(opp);
                        break;
                    case 2:
                        player.defend(opp);
                        break;
                    case 3:
                        player.charge();
                        break;
                }

                switch(oppAction) {
                    case 1:
                        opp.attack(player);
                        break;
                    case 2:
                        opp.defend(player);
                        break;
                    case 3:
                        opp.charge();
                        break;
                }

                player.setPrevAction(playerAction);
                opp.setPrevAction(oppAction);
                opp.resetAtkMult();
            }
            else {
                switch(oppAction) {
                    case 1:
                        opp.attack(player);
                        break;
                    case 2:
                        opp.defend(player);
                        break;
                    case 3:
                        opp.charge();
                        break;
                }

                switch(playerAction) {
                    case 1:
                        player.attack(opp);
                        break;
                    case 2:
                        player.defend(opp);
                        break;
                    case 3:
                        player.charge();
                        break;
                }

                player.setPrevAction(playerAction);
                opp.setPrevAction(oppAction);
                player.resetAtkMult();
            }

            // If charge selected, set flag to true
            if(player.getIsAttackCharged()){
                player.setAtk(player.getAtk() / 3);
                player.setIsAttackCharged(false);
            }
            // If charge selected, set flag to true
            if(player.getIsNextCharged()) {
                player.setIsAttackCharged(true);
                player.setIsNextCharged(false);
            }

            // If charge selected, set flag to true
            if(opp.getIsAttackCharged()){
                opp.setAtk(opp.getAtk() / 3);
                opp.setIsAttackCharged(false);
            }
            // If charge selected, set flag to true
            if(opp.getIsNextCharged()) {
                opp.setIsAttackCharged(true);
                opp.setIsNextCharged(false);
            }
            
            // If game is over, check winner
            if(isGameOver()) {
                if(player.getHp() == 0)
                    winner = opp.getName();
                else if(opp.getHp() == 0)
                    winner = player.getName();
            }
            
            // Apply environment effects
            applyEnvEffects(env);

            // Increment move counter
            moveCounter++;
        }

        // Display the final stats and declare winner
        displayStats();
        displayWinner(winner, moveCounter);

        
    }    
}
