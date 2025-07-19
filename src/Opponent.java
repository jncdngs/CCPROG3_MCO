/**
 * Character controlled by the opponent.
 * <p>
 * Stores the opponent's name, armor, weapon, and stats. 
 * Handles the actions made by the opponent and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public class Opponent {
    
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float atkMult = 1;
    private boolean isAtkCharged = false;
    private boolean isNextCharged = false;
    private int prevAction = 0;

    /**
     * Constructs a character for the opponent with given stats.
     * 
     * @param name  the name of the opponent
     * @param hp    the hit points of the opponent
     * @param atk   the attack of the opponent
     * @param def   the defense of the opponent
     * @param spd   the speed of the opponent
     */
    public Opponent(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /**
     * Returns the name of the opponent.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the current hit points of the opponent.
     * 
     * @return the current HP
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Returns the current attack points of the opponent.
     * 
     * @return the current attack
     */
    public int getAtk() {
        return this.atk;
    }

    /**
     * Returns the current defense points of the opponent.
     * 
     * @return the current defense
     */
    public int getDef() {
        return this.def;
    }

    /**
     * Returns the current speed points of the opponent.
     * 
     * @return the current speed
     */
    public int getSpd() {
        return this.spd;
    }

    /**
     * Returns the current attack multiplier of the opponent.
     * 
     * @return the current attack multiplier
     */
    public float getAtkMult() {
        return this.atkMult;
    }

    /** 
     * Checks if the current attack of the opponent is charged.
     * 
     * @return true if the current attack is charged,
     *         false if the current attack is not charged
     */
    public boolean getIsAtkCharged() {
        return this.isAtkCharged;
    }

    /** 
     * Checks if the next attack of the opponent is charged.
     * 
     * @return true if the next attack is charged,
     *         false if the next attack is not charged
     */
    public boolean getIsNextCharged() {
        return this.isNextCharged;
    }

    /** 
     * Returns the corresponding number for the previously chosen action.
     * 
     * @return 1 for Attack, 2 for Defend, 3 for Charge
     */
    public int getPrevAction() {
        return this.prevAction;
    }



    /** 
     * Sets the current attack points of the opponent.
     * 
     * @param atk the attack points to be set
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /** 
     * Sets the current attack multiplier of the opponent.
     * 
     * @param atkMult the multiplier to be applied to the current attack points
     */
    public void setAtkMult(float atkMult) {
        this.atkMult = atkMult;
    }

    /** 
     * Sets the flag indicating if the current attack of the opponent is charged.
     * 
     * @param isAtkCharged the flag to indicate if the current attack is charged
     */
    public void setIsAtkCharged(boolean isAtkCharged) {
        this.isAtkCharged = isAtkCharged;
    }

    /** 
     * Sets the flag indicating if the next attack of the opponent is charged.
     * 
     * @param isNextCharged the flag to indicate if the next attack if charged
     */
    public void setIsNextCharged(boolean isNextCharged) {
        this.isNextCharged = isNextCharged;
    }

    /** 
     * Sets the corresponding number for the previously chosen action by the opponent:
     * 1 for Attack, 2 for Defend, 3 for Charge
     *         
     * @param prevAction the previously chosen action
     */
    public void setPrevAction(int prevAction) {
        this.prevAction = prevAction;
    }



    /** 
     * Deducts hit points from the opponent.
     * 
     * @param hp the number of hit points to be deducted
     */
    public void loseHp(int hp) {
        if(hp >= this.hp)
            this.hp = 0;
        else
            this.hp -= hp;
    }

    /** 
     * Adds attack points to the opponent.
     * 
     * @param atk the number of attack points to be added
     */
    public void gainAtk(int atk) {
        this.atk += atk;
    }

    /** 
     * Deducts defense points from the opponent.
     * 
     * @param def the number of defense points to be deducted
     */
    public void loseDef(int def) {
        if(def >= this.def)
            this.def = 0;
        else
            this.def -= def;
    }

    /** 
     * Resets the attack multiplier of the opponent to 1.
     */
    public void resetAtkMult() {
        this.atkMult = 1;
    }



    /** 
     * Deducts hit points from the player. 
     * <p>
     * The damage to be dealt is calculated by multiplying the current attack
     * points of the opponent with the attack multiplier (0.5 if the player 
     * defended, 1 otherwise) and subtracting the current defense points of the 
     * player.
     * 
     * @param player the player object to be attacked
     */
    public void attack(Player player) {
        int dmg = (int)(atk * atkMult - player.getDef());
        if(dmg < 0)
            dmg = 0;
        
        player.loseHp(dmg);
    }

    /** 
     * Multiply player's attack by half.
     * 
     * @param player the player object to defend from
     */
    public void defend(Player player) {
        player.setAtkMult(0.5f);
    }

    /** 
     * Charge the opponent's next attack.
     * <p>
     * Checks first if the current attack is charged. If not, the attack points 
     * are multiplied by 3 and the next attack charged flag is set to true.
     */
    public void charge() {
        if(!isAtkCharged) {
            atk *= 3;
            isNextCharged = true;
        }
    }
    
    /**
     * Determines the action of the opponent (Faux-AI).
     * <p>
     * Checks the current move number and the name of the opponent and returns 
     * the corresponding action based on a predetermined sequence.
     * 
     * @param moveCounter   the current move number of the game
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    public int think(int moveCounter) {
        if(moveCounter % 3 == 2) {
            if(name.equals("Viking"))
                return 2;
            else if(name.equals("Minotaur"))
                return 3;
        }

        return 1;
    }



    /**
     * Displays the current opponent stats.
     * <p>
     * Displays the opponent's name, hit points, attack, defense, and speed.
     */
    public void displayStats() {
        System.out.println("========== Opponent ==========");
        System.out.println("Name:    " + getName());
        System.out.println("HP:      " + getHp());
        System.out.println("Attack:  " + getAtk());
        System.out.println("Defense: " + getDef());
        System.out.println("Speed:   " + getSpd());
        System.out.println();
    }

}
