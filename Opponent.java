public class Opponent {
    
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float atkMult;
    private boolean isAttackCharged = false;
    private boolean isNextCharged = false;

    public Opponent(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    public String getName() {
        return this.name;
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



    public void loseHp(int hp) {
        if(hp >= this.hp)
            this.hp = 0;
        else
            this.hp -= hp;
    }

    public void gainAtk(int atk) {
        this.atk += atk;
    }

    public void loseDef(int def) {
        if(def >= this.def)
            this.def = 0;
        else
            this.def -= def;
    }

    public void resetAtkMult() {
        this.atkMult = 1;
    }



    public void attack(Player player) {
        int dmg = (int)(atk * atkMult - player.getDef());
        if(dmg < 0)
            dmg = 0;
        
        player.loseHp(dmg);
    }

    public void defend(Player player) {
        player.setAtkMult(0.5f);
    }

    public void charge() {
        if(!isAttackCharged) {
            atk *= 3;
            isNextCharged = true;
        }
    }        
}
