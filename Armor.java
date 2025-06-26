public class Armor {

    private String name;
    private int defBuff;
    private int spdPen;

    public Armor(String name, int defBuff, int spdPen) {
        this.name = name;
        this.defBuff = defBuff;
        this.spdPen = spdPen;
    }

    /** @return the name of the armor */
    public String getName() {
        return this.name;
    }

    /** @return the defense points to be added to the player */
    public int getDefBuff() {
        return this.defBuff;
    }

    /** @return the speed points to be deducted from the player */
    public int getSpdPen() {
        return this.spdPen;
    }

}
