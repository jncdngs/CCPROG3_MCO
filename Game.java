import java.util.Scanner;

/**
 * Main controller for the game.
 * <p>
 * Contains and manages the player, opponent, and environment objects, and runs the main game loop.
 * Handles all game logic including setup, turn order, action execution, buffs, and penalties.
 * 
 * @author Jon Chester Donguines
 */

public class Game {

    private Player player;
    private Environment env;
    private Opponent opp;
    
    /**
     * Displays the stats for the current turn.
     * <p>
     * Displays the actions executed on the previous turn (except during the first turn), 
     * the current stats of the player, and the current stats of the opponent.
     */
    private void displayStats() {
        String[] action = new String[] {"attacked", "defended", "charged"};
        
        System.out.printf("\033[H\033[J\033[3J");

        // Display previous actions executed
        if(player.getPrevAction() != 0 || opp.getPrevAction() != 0) {
            if(compareSpeed(player, opp)) {
                System.out.println(player.getName() + " " + action[player.getPrevAction() - 1] + "!");
                System.out.println(opp.getName() + " " + action[opp.getPrevAction() - 1] + "!\n");
            }
            else {
                System.out.println(opp.getName() + " " + action[opp.getPrevAction() - 1] + "!");
                System.out.println(player.getName() + " " + action[player.getPrevAction() - 1] + "!\n");
            }
        }

        // Display player stats
        player.displayStats();

        // Display opponent stats
        opp.displayStats();
    }

    /** 
     * Displays the name of the winner and the number of moves taken.
     * 
     * @param winner        the name of the winner
     * @param moveCounter   the number of moves taken
     */
    private void displayWinner(String winner, int moveCounter) {
        System.out.println(winner + " won the game in " + moveCounter + " moves!\n");
    }

    /** 
     * Checks if the game is over by checking the hit points of the player and opponent.
     * 
     * @return true if either player or opponent's hit points are zero,
     *         false if both player and opponent's hit points are not zero
     */
    private boolean isGameOver() {
        return player.getHp() == 0 || opp.getHp() == 0;
    }

    /** 
     * Compares speed of player and opponent to determine whose action executes first.
     * 
     * @param player    the player object to compare
     * @param opp       the opponent object to compare
     * @return          true if the player's speed is higher than the opponent's,
     *                  false if the opponent's speed is lower than or equal to the player's
     */
    private boolean compareSpeed(Player player, Opponent opp) {
        return player.getSpd() > opp.getSpd();
    }

    /** 
     * Applies buffs and penalties to the player and opponent from the chosen environment.
     */
    private void applyEnvEffects() {
        player.loseHp(env.getPlayerDmg());
        player.gainAtk(env.getPlayerAtk());
        opp.gainAtk(env.getOppAtk());
        opp.loseDef(env.getOppDef());
    }

    /** 
     * Asks the player/opponent to choose an action.
     * 
     * @param currentTurn   the name of the player/opponent to choose
     * @param sc            the scanner object for user input
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    private int askAction(String currentTurn, Scanner sc) {
        int action;
        int chargeFlag = 0;

        if(this.player.getIsAtkCharged())
            chargeFlag = 1;

        do {
            displayStats();
            System.out.println(currentTurn + "'s turn!\n");
            System.out.println("[1] Attack");
            System.out.println("[2] Defend");
            
            if(chargeFlag == 0)
                System.out.println("[3] Charge\n");
            else
                System.out.println();
            
            System.out.print("Choose an action: ");
            action = sc.nextInt();
        }
        while(action < 1 || action > 3 - chargeFlag);

        return action;
    }

    /** 
     * Sets up the game by asking the player for their name, armor, weapon, environment, and opponent.
     * <p>
     * Armor, Weapon, Environment, and Opponent objects are only created after user input.
     * 
     * @param sc the scanner object for user input
     */
    public void setup(Scanner sc) {
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

    /** 
     * Starts the main game loop.
     * <p>
     * The game starts by comparing the speeds of the player and the opponent. 
     * Afterwards, it asks them which action to execute in order. Then the game 
     * checks if someone chose to defend. If so, the defender will have action 
     * execution priority. If someone chose charge, their next attack will be 
     * flagged as charged. If someone currently has a charged attack, the flag 
     * will be set to uncharged for the next turn. The game then checks if the 
     * game is over. If so, check for the winner. If not, apply the environmental 
     * effects and increment move counter by 1. Repeat.
     * 
     * @param sc the scanner object for user input
     */
    public void start(Scanner sc) {
        int playerAction, oppAction, moveCounter = 1;
        boolean isPlayersTurn;
        String winner = null;
        
        while(!isGameOver()) {
            // Compare speed of player and opponent
            isPlayersTurn = compareSpeed(player, opp);
            
            // Ask #1 then #2 for action
            if(isPlayersTurn) {
                playerAction = askAction("Player", sc);
                oppAction = opp.think(moveCounter);
            }
            else {
                oppAction = opp.think(moveCounter);
                playerAction = askAction("Player", sc);
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
            if(player.getIsAtkCharged()) {
                player.setAtk(player.getAtk() / 3);
                player.setIsAtkCharged(false);
            }
            // If charge selected, set flag to true
            if(player.getIsNextCharged()) {
                player.setIsAtkCharged(true);
                player.setIsNextCharged(false);
            }

            // If charge selected, set flag to true
            if(opp.getIsAtkCharged()) {
                opp.setAtk(opp.getAtk() / 3);
                opp.setIsAtkCharged(false);
            }
            // If charge selected, set flag to true
            if(opp.getIsNextCharged()) {
                opp.setIsAtkCharged(true);
                opp.setIsNextCharged(false);
            }
            
            // If game is over, check winner based on turn order
            if(isGameOver()) {
                if(compareSpeed(player, opp)) {
                    if(opp.getHp() == 0)
                        winner = player.getName();
                    else if(player.getHp() == 0)
                        winner = opp.getName();
                }
                else {
                    if(player.getHp() == 0)
                        winner = opp.getName();
                    else if(opp.getHp() == 0)
                        winner = player.getName();
                }
            }       
            else {
                // Apply environment effects
                applyEnvEffects();
                
                // Increment move counter
                moveCounter++;
            }
        }

        // Display the final stats and declare winner
        displayStats();
        displayWinner(winner, moveCounter);
    }
    
}
