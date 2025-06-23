public class Player {
    
    private String name;
    private Armor armor;
    private Weapon weapon;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float atkMult = 1;
    private boolean isAttackCharged = false;
    private boolean isNextCharged = false;
    private int prevAction = 0;

    public Player(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    public String getName() {
        return this.name;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getSpd() {
        return this.spd;
    }

    public float getAtkMult() {
        return this.atkMult;
    }

    public boolean getIsAttackCharged() {
        return this.isAttackCharged;
    }

    public boolean getIsNextCharged() {
        return this.isNextCharged;
    }

    public int getPrevAction() {
        return this.prevAction;
    }

    
    public void setArmor(Armor armor) {
        this.armor = armor;
        gainDef(armor.getDefBuff());
        loseSpd(armor.getSpdPen());
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        gainAtk(weapon.getAtkBuff());
        loseSpd(weapon.getSpdPen());
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public void setAtkMult(float atkMult) {
        this.atkMult = atkMult;
    }

    public void setIsAttackCharged(boolean isAttackCharged) {
        this.isAttackCharged = isAttackCharged;
    }

    public void setIsNextCharged(boolean isNextCharged) {
        this.isNextCharged = isNextCharged;
    }

    public void setPrevAction(int prevAction) {
        this.prevAction = prevAction;
    }



    public void loseHp(int hp) {
        if(hp >= this.hp)
            this.hp = 0;
        else
            this.hp -= hp;
    }

    public void gainAtk(int atk) {
        this.atk += atk;
    }

    public void loseAtk(int atk) {
        if(atk >= this.atk)
            this.atk = 0;
        else
            this.atk -= atk;
    }

    public void gainDef(int def) {
        this.def += def;
    }

    public void loseDef(int def) {
        if(def >= this.def)
            this.def = 0;
        else
            this.def -= def;
    }
    
    public void gainSpd(int spd) {
        this.spd += spd;
    }

    public void loseSpd(int spd) {
        if(spd >= this.spd)
            this.spd = 0;
        else
            this.spd -= spd;
    }

    public void resetAtkMult() {
        this.atkMult = 1;
    }



    public void attack(Opponent opp) {
        int dmg = (int)(atk * atkMult - opp.getDef());
        if(dmg < 0)
            dmg = 0;
        
        opp.loseHp(dmg);
    }

    public void defend(Opponent opp) {
        opp.setAtkMult(0.5f);
    }

    public void charge() {
        if(!isAttackCharged) {
            atk *= 3;
            isNextCharged = true;
        }
    }
}
