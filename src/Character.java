/**
 * Character controlled by the player.
 * <p>
 * Stores the character's name, armor, weapon, and stats. 
 * Handles the actions made by the player and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public abstract class Character {
    
    protected String name;
    protected int hp;
    protected int atk;
    protected int def;
    protected int spd;
    protected double atkMult = 1;
    protected boolean isAtkCharged = false;
    protected boolean isNextCharged = false;
    protected int prevAction = 0;

    /**
     * Constructs a character for the player with given base stats.
     * 
     * @param name  the name of the player
     * @param hp    the base hit points of the player
     * @param atk   the base attack of the player
     * @param def   the base defense of the player
     * @param spd   the base speed of the player
     */
    public Character(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /**
     * Returns the name of the player.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the current hit points of the player.
     * 
     * @return the current HP
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Returns the current attack points of the player.
     * 
     * @return the current attack
     */
    public int getAtk() {
        return this.atk;
    }

    /**
     * Returns the current defense points of the player.
     * 
     * @return the current defense
     */
    public int getDef() {
        return this.def;
    }

    /**
     * Returns the current speed points of the player.
     * 
     * @return the current speed
     */
    public int getSpd() {
        return this.spd;
    }

    /**
     * Returns the current attack multiplier of the player.
     * 
     * @return the current attack multiplier
     */
    public double getAtkMult() {
        return this.atkMult;
    }

    /** 
     * Checks if the current attack of the player is charged.
     * 
     * @return true if the current attack is charged,
     *         false if the current attack is not charged
     */
    public boolean getIsAtkCharged() {
        return this.isAtkCharged;
    }

    /** 
     * Checks if the next attack of the player is charged.
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
     * Sets the current attack points of the player.
     * 
     * @param atk the attack points to be set
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /** 
     * Sets the current attack multiplier of the player.
     * 
     * @param atkMult the multiplier to be applied to the current attack points
     */
    public void setAtkMult(double atkMult) {
        this.atkMult = atkMult;
    }

    /** 
     * Sets the flag indicating if the current attack of the player is charged.
     * 
     * @param isAtkCharged the flag to indicate if the current attack is charged
     */
    public void setIsAtkCharged(boolean isAtkCharged) {
        this.isAtkCharged = isAtkCharged;
    }

    /** 
     * Sets the flag indicating if the next attack of the player is charged.
     * 
     * @param isNextCharged the flag to indicate if the next attack if charged
     */
    public void setIsNextCharged(boolean isNextCharged) {
        this.isNextCharged = isNextCharged;
    }

    /** 
     * Sets the corresponding number for the previously chosen action by the player:
     * 1 for Attack, 2 for Defend, 3 for Charge
     * 
     * @param prevAction the previously chosen action
     */
    public void setPrevAction(int prevAction) {
        this.prevAction = prevAction;
    }



    /** 
     * Deducts hit points from the player.
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
     * Adds attack points to the player.
     * 
     * @param atk the number of attack points to be added
     */
    public void gainAtk(int atk) {
        this.atk += atk;
    }

    /** 
     * Deducts attack points from the player.
     * 
     * @param atk the number of attack points to be deducted
     */
    public void loseAtk(int atk) {
        if(atk >= this.atk)
            this.atk = 0;
        else
            this.atk -= atk;
    }

    /** 
     * Adds defense points to the player.
     * 
     * @param def the number of defense points to be added
     */
    public void gainDef(int def) {
        this.def += def;
    }

    /** 
     * Deducts defense points from the player.
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
     * Adds speed points to the player.
     * 
     * @param spd the number of speed points to be added
     */
    public void gainSpd(int spd) {
        this.spd += spd;
    }

    /** 
     * Deducts speed points from the player.
     * 
     * @param spd the number of speed points to be deducted
     */
    public void loseSpd(int spd) {
        if(spd >= this.spd)
            this.spd = 0;
        else
            this.spd -= spd;
    }

    /** 
     * Resets the attack multiplier of the player to 1.
     */
    public void resetAtkMult() {
        this.atkMult = 1.0;
    }



    /** 
     * Charge the player's next attack.
     * <p>
     * Checks first if the current attack is charged. If not, the attack points 
     * are multiplied by 3 and the next attack charged flag is set to true.
     */
    public void charge() {
        if(!isAtkCharged) {
            atk *= 3;
            isNextCharged = true;

            System.out.println("[LOG] " + name + " charged");
        }
    }



    /**
     * Displays the current player stats.
     * <p>
     * Displays the player's name, armor name, weapon name, hit points, attack, 
     * defense, and speed.
     */
    public abstract void displayStats();

}
