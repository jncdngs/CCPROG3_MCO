import javax.swing.*;
import java.awt.event.*;

/**
 * Main controller for the game.
 * <p>
 * Contains and manages the GUI, player, opponent, and environment objects, and runs the main game loop.
 * Handles all game logic including setup, turn order, action execution, buffs, and penalties.
 * 
 * @author Jon Chester Donguines
 */
public class Controller implements ActionListener {

    private GUI gui;
    private Player player;
    private Opponent opp;
    private Environment env;
    
    private int oppAction;
    private int moveCounter;
    private boolean isPlayersTurn;
    private String winner;

    public Controller(GUI gui) {
        this.gui = gui;
        gui.setActionListeners(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gui.getBtnPlay()) {
            System.out.println("[LOG] Play button pressed");

            gui.getMainLayout().show(gui.getMainPanel(), "namePanel");
            System.out.println("[LOG] Switched to name selection panel");
        }
        else if(e.getSource() == gui.getBtnQuit()) {
            System.out.println("[LOG] Quit button pressed");

            int result = JOptionPane.showConfirmDialog(
                gui, 
                "Are you sure you want to quit the game?", 
                "Exit Confirmation", 
                JOptionPane.YES_NO_OPTION);

            if(result == JOptionPane.YES_OPTION) {
                System.out.println("[LOG] Program exited");
                System.exit(0);
            }
        }
        else if(e.getSource() == gui.getBtnName()) {
            System.out.println("[LOG] Enter button pressed");

            if(!(gui.getNameField().getText().trim().equals(""))) {
                player = new Player(gui.getNameField().getText());

                gui.getMainLayout().show(gui.getMainPanel(), "armorPanel");
                System.out.println("[LOG] Switched to armor selection panel");
            }

        }
        else if(e.getSource() == gui.getBtnLight() ||
                e.getSource() == gui.getBtnMedium() ||
                e.getSource() == gui.getBtnHeavy() ||
                e.getSource() == gui.getBtnNoArmor()) {

            Armor armor = null;
            
            if(e.getSource() == gui.getBtnLight())
                armor = new Armor("Light", 20, 5);
            else if(e.getSource() == gui.getBtnMedium())
                armor = new Armor("Medium", 30, 15);
            else if(e.getSource() == gui.getBtnHeavy())
                armor = new Armor("Heavy", 40, 25);
            else if(e.getSource() == gui.getBtnNoArmor())
                armor = new Armor("None", 0, 0);
            
            player.setArmor(armor);
            System.out.println("[LOG] Set player armor to \"" + player.getArmor().getName() + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "weaponPanel");
            System.out.println("[LOG] Switched to weapon selection panel");
        }
        else if(e.getSource() == gui.getBtnDagger() ||
                e.getSource() == gui.getBtnSword() ||
                e.getSource() == gui.getBtnAxe() ||
                e.getSource() == gui.getBtnNoWeapon()) {

            Weapon weapon = null;
            
            if(e.getSource() == gui.getBtnDagger())
                weapon = new Dagger();
            else if(e.getSource() == gui.getBtnSword())
                weapon = new Sword();
            else if(e.getSource() == gui.getBtnAxe())
                weapon = new BattleAxe();
            else if(e.getSource() == gui.getBtnNoWeapon())
                weapon = new Weapon("None", 0, 0);
            
            player.setWeapon(weapon);
            System.out.println("[LOG] Set player weapon to \"" + player.getWeapon().getName() + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "oppPanel");
            System.out.println("[LOG] Switched to opponent selection panel");
        }
        else if(e.getSource() == gui.getBtnThief() ||
                e.getSource() == gui.getBtnViking() ||
                e.getSource() == gui.getBtnMinotaur()) {
            
            if(e.getSource() == gui.getBtnThief())
                opp = new Thief();
            else if(e.getSource() == gui.getBtnViking())
                opp = new Viking();
            else if(e.getSource() == gui.getBtnMinotaur())
                opp = new Minotaur();

            String oppName = opp.getName() + ".png";
            gui.setOppFileName(oppName);
            System.out.println("[LOG] Set opponent sprite to \"" + oppName + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "envPanel");
            System.out.println("[LOG] Switched to environment selection panel");
        }
        else if(e.getSource() == gui.getBtnArena() ||
                e.getSource() == gui.getBtnSwamp() ||
                e.getSource() == gui.getBtnColosseum()) {
            
            if(e.getSource() == gui.getBtnArena())
                env = new Environment("Arena", 0, 0, 0, 0);
            else if(e.getSource() == gui.getBtnSwamp())
                env = new Environment("Swamp", 0, 1, 1, 0);
            else if(e.getSource() == gui.getBtnColosseum())
                env = new Environment("Colosseum", 1, 0, 0, 1);
            
            System.out.println("[LOG] Set environment to \"" + env.getName() + "\"");

            String envName = env.getName() + ".png";
            gui.setEnvironment(envName);
            System.out.println("[LOG] Set game background to \"" + envName + "\"");

            moveCounter = 1;
            System.out.println("[LOG] Reset move counter");
            
            gui.addGamePanel(player, opp);
            gui.getMainPanel().add(gui.getGamePanel(), "gamePanel");

            gui.getMainLayout().show(gui.getMainPanel(), "gamePanel");
            System.out.println("[LOG] Switched to main game panel");

            gui.getBtnAttack().addActionListener(this);
            gui.getBtnDefend().addActionListener(this);
            gui.getBtnCharge().addActionListener(this);
            gui.getBtnReturn().addActionListener(this);

            displayStats();
            gui.revalidate();
            gui.repaint();
        }
        else if(e.getSource() == gui.getBtnAttack() ||
                e.getSource() == gui.getBtnDefend() ||
                e.getSource() == gui.getBtnCharge()) {
            if(e.getSource() == gui.getBtnAttack()) {
                System.out.println("[LOG] Attack pressed");
                nextTurn(1);
                gui.revalidate();
                gui.repaint();
            }
            else if(e.getSource() == gui.getBtnDefend()) {
                System.out.println("[LOG] Defend pressed");
                nextTurn(2);
                gui.revalidate();
                gui.repaint();
            }
            else if(e.getSource() == gui.getBtnCharge()) {
                System.out.println("[LOG] Charge pressed");
                nextTurn(3);
                gui.revalidate();
                gui.repaint();
            }
        }
        else if(e.getSource() == gui.getBtnReturn()) {
            // Remove the old frame
            gui.dispose();
            
            // Create a new GUI object
            gui = new GUI();
            
            // Reset action listeners
            gui.setActionListeners(this);

            System.out.println("[LOG] Returned to start screen");
        }
    }



    /**
     * Displays the stats for the current turn.
     * <p>
     * Displays the actions executed on the previous turn (except during the first turn), 
     * the current stats of the player, and the current stats of the opponent.
     */
    private void displayStats() {
        String[] action = new String[] {"attacked", "defended", "charged"};
        
        // System.out.printf("\033[H\033[J\033[3J");
        System.out.println();

        // Display previous actions executed
        if(player.getPrevAction() != 0 || opp.getPrevAction() != 0) {
            if(compareSpeed(player, opp)) {
                System.out.println("[LOG] " + player.getName() + " " + action[player.getPrevAction() - 1] + "!");
                System.out.println("[LOG] " + opp.getName() + " " + action[opp.getPrevAction() - 1] + "!\n");
            } else {
                System.out.println("[LOG] " + opp.getName() + " " + action[opp.getPrevAction() - 1] + "!");
                System.out.println("[LOG] " + player.getName() + " " + action[player.getPrevAction() - 1] + "!\n");
            }
        }

        System.out.println("[LOG] ===================================\n");

        // Display player stats
        player.displayStats();
        // Display opponent stats
        opp.displayStats();

        System.out.println("=========================================\n");
    }

    public String getPrevOppAction() {
        String prevAction;
        String[] action = new String[] {"attacked", "defended", "charged"};

        prevAction = opp.getName() + " " + action[opp.getPrevAction() - 1] + "!";

        return prevAction;
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
     */
    public void nextTurn(int playerAction) {
        
        displayStats();
        gui.revalidate();
        gui.repaint();

        // Compare speed of player and opponent
        isPlayersTurn = compareSpeed(player, opp);
        
        // Determine opponent's action
        // this.playerAction = playerAction;
        oppAction = opp.think(moveCounter);

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
        } else {
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

        // If player selected charge, set flag to true
        if(player.getIsAtkCharged()) {
            player.setAtk(player.getAtk() / 3);
            gui.setIsAtkCharged(false);
            player.setIsAtkCharged(false);

            if(player.getWeapon().isBattleAxe()) {
                player.loseSpd(5);
                player.loseAtk(5);

                System.out.println("[LOG] Temporary battle axe buff removed");
            }
        }
        if(player.getIsNextCharged()) {
            player.setIsAtkCharged(true);
            gui.setIsAtkCharged(true);
            player.setIsNextCharged(false);
            
            if(player.getWeapon().isBattleAxe()) {
                player.gainSpd(5);
                player.gainAtk(5);

                System.out.println("[LOG] Temporary battle axe buff applied");
            }
        }

        // If opponent selected charge, set flag to true
        if(opp.getIsAtkCharged()) {
            opp.setAtk(opp.getAtk() / 3);
            opp.setIsAtkCharged(false);
        }
        if(opp.getIsNextCharged()) {
            opp.setIsAtkCharged(true);
            opp.setIsNextCharged(false);
        }
        
        // If player defend is evade, set flag to true
        if(player.getIsDefEvade()) {
            opp.resetAtkMult();
            player.setIsDefEvade(false);
        }
        if(player.getIsNextNotEvade()) {
            player.setIsDefEvade(true);
            player.setIsNextNotEvade(false);
        }

        // If game is over, check winner based on turn order
        if(isGameOver()) {
            if(compareSpeed(player, opp)) {
                if(opp.getHp() == 0)
                    winner = player.getName();
                else if(player.getHp() == 0)
                    winner = opp.getName();
            } else {
                if(player.getHp() == 0)
                    winner = opp.getName();
                else if(opp.getHp() == 0)
                    winner = player.getName();
            }
            
            System.out.println("[LOG] Final stats below");
            gui.displayWinPanel(winner, moveCounter);
            gui.getBtnReturn().addActionListener(this);
            gui.revalidate();
            gui.repaint();
        } else {
            // Apply environment effects
            applyEnvEffects();
            System.out.println("[LOG] " + env.getName() + " effects applied");
            
            // Increment move counter
            moveCounter++;
            System.out.println("[LOG] Updated move count: " + moveCounter);
        }

        displayStats();
        gui.updateStats(player, opp, isGameOver(), getPrevOppAction());
        gui.updateButtons(player);
        gui.revalidate();
        gui.repaint();
    }

}
