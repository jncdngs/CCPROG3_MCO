import javax.swing.*;
import java.awt.*;

public class WeaponPanel {

    private JPanel weaponPanel;

    private JButton btnDagger;
    private JButton btnSword;
    private JButton btnAxe;
    private JButton btnNoWeapon;

    public WeaponPanel() {
        this.weaponPanel = new JPanel();
    }

    public void addWeaponPanel() {
        weaponPanel.setLayout(new BorderLayout());
        
        // NORTH PANEL
        JPanel weaponNorth = new JPanel(new FlowLayout());
        weaponNorth.setOpaque(false);
        
        JLabel weaponHeader = new JLabel("Pick a weapon", SwingConstants.CENTER);
        weaponHeader.setFont(new Font("Arial", Font.BOLD, 30));
        weaponHeader.setPreferredSize(new Dimension(300, 100));

        weaponNorth.add(weaponHeader);

        // SOUTH PANEL
        JPanel weaponSouth = new JPanel(new FlowLayout());
        weaponSouth.setOpaque(false);

        btnNoWeapon = new JButton("No weapon");
        btnNoWeapon.setFont(new Font("Arial", Font.BOLD, 20));
        btnNoWeapon.setPreferredSize(new Dimension(200, 50));

        weaponSouth.add(btnNoWeapon);

        // WEST PANEL
        JPanel weaponWest = new JPanel(new GridLayout(3, 1));
        weaponWest.setOpaque(false);
        weaponWest.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon westIcon = new ImageIcon("Dagger.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        westIconLabel.setPreferredSize(new Dimension(250, 275));
        
        JPanel westIconFlow = new JPanel(new FlowLayout());
        westIconFlow.setPreferredSize(new Dimension(130, 240));
        westIconFlow.add(westIconLabel);

        // Add stats
        JPanel westStats = new JPanel(new GridLayout(3,1));
        westStats.setPreferredSize(new Dimension(600, 700));

        JLabel westAtk = new JLabel("Attack: +20", JLabel.CENTER);
        westAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        westAtk.setPreferredSize(new Dimension(200, 100));

        JLabel westSpd = new JLabel("Speed:   0", JLabel.CENTER);
        westSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        westSpd.setPreferredSize(new Dimension(200, 100));
        
        JLabel westAbility = new JLabel("When defending, every other defend will become a 100% evade", 
                                        JLabel.CENTER);
        westAbility.setFont(new Font("Arial", Font.PLAIN, 14));
        westAbility.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnDagger = new JButton("Dagger");
        btnDagger.setFont(new Font("Arial", Font.BOLD, 20));
        btnDagger.setPreferredSize(new Dimension(200, 50));

        JPanel btnDaggerFlow = new JPanel(new FlowLayout());
        btnDaggerFlow.add(btnDagger);

        // Add to stats panel
        westStats.add(westAtk);
        westStats.add(westSpd);
        westStats.add(westAbility);

        // Add to west panel
        weaponWest.add(westIconFlow);
        weaponWest.add(westStats);
        weaponWest.add(btnDaggerFlow);

        // CENTER PANEL
        JPanel weaponCenter = new JPanel(new GridLayout(3, 1));
        weaponCenter.setOpaque(false);
        weaponCenter.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon centerIcon = new ImageIcon("Sword.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);
        centerIconLabel.setPreferredSize(new Dimension(250, 275));

        JPanel centerIconFlow = new JPanel(new FlowLayout());
        centerIconFlow.setPreferredSize(new Dimension(130, 240));
        centerIconFlow.add(centerIconLabel);

        // Add stats
        JPanel centerStats = new JPanel(new GridLayout(3,1));
        centerStats.setPreferredSize(new Dimension(600, 700));

        JLabel centerAtk = new JLabel("Attack: +30", JLabel.CENTER);
        centerAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        centerAtk.setPreferredSize(new Dimension(200, 100));

        JLabel centerSpd = new JLabel("Speed:   -10", JLabel.CENTER);
        centerSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        centerSpd.setPreferredSize(new Dimension(200, 100));

        JLabel centerAbility = new JLabel("When attacking, gain an additional +10 attack", 
                                          JLabel.CENTER);
        centerAbility.setFont(new Font("Arial", Font.PLAIN, 14));
        centerAbility.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnSword = new JButton("Sword");
        btnSword.setFont(new Font("Arial", Font.BOLD, 20));
        btnSword.setPreferredSize(new Dimension(200, 50));

        JPanel btnSwordFlow = new JPanel(new FlowLayout());
        btnSwordFlow.add(btnSword);

        // Add to stats panel
        centerStats.add(centerAtk);
        centerStats.add(centerSpd);
        centerStats.add(centerAbility);

        // Add to center panel
        weaponCenter.add(centerIconFlow);
        weaponCenter.add(centerStats);
        weaponCenter.add(btnSwordFlow);

        // EAST PANEL
        JPanel weaponEast = new JPanel(new GridLayout(3, 1));
        weaponEast.setOpaque(false);
        weaponEast.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon eastIcon = new ImageIcon("BattleAxe.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);
        eastIconLabel.setPreferredSize(new Dimension(250, 275));

        JPanel eastIconFlow = new JPanel(new FlowLayout());
        eastIconFlow.setPreferredSize(new Dimension(130, 240));
        eastIconFlow.add(eastIconLabel);

        // Add stats
        JPanel eastStats = new JPanel(new GridLayout(3,1));
        eastStats.setPreferredSize(new Dimension(600, 700));

        JLabel eastAtk = new JLabel("Attack: +40", JLabel.CENTER);
        eastAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        eastAtk.setPreferredSize(new Dimension(200, 100));

        JLabel eastSpd = new JLabel("Speed:   -20", JLabel.CENTER);
        eastSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        eastSpd.setPreferredSize(new Dimension(200, 100));

        JLabel eastAbility = new JLabel("When charging, gain 5 speed and 5 attack in the next turn", 
                                        JLabel.CENTER);
        eastAbility.setFont(new Font("Arial", Font.PLAIN, 14));
        eastAbility.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnAxe = new JButton("Battle Axe");
        btnAxe.setFont(new Font("Arial", Font.BOLD, 20));
        btnAxe.setPreferredSize(new Dimension(200, 50));

        JPanel btnAxeFlow = new JPanel(new FlowLayout());
        btnAxeFlow.add(btnAxe);

        // Add to stats panel
        eastStats.add(eastAtk);
        eastStats.add(eastSpd);
        eastStats.add(eastAbility);

        // Add to east panel
        weaponEast.add(eastIconFlow);
        weaponEast.add(eastStats);
        weaponEast.add(btnAxeFlow);

        // Add to weapon panel
        weaponPanel.add(weaponNorth, BorderLayout.NORTH);
        weaponPanel.add(weaponSouth, BorderLayout.SOUTH);
        weaponPanel.add(weaponWest, BorderLayout.WEST);
        weaponPanel.add(weaponCenter, BorderLayout.CENTER);
        weaponPanel.add(weaponEast, BorderLayout.EAST);

        System.out.println("[LOG] Weapon panel created");
    }



    public JPanel getWeaponPanel() {
        return this.weaponPanel;
    }
    
    public JButton getBtnDagger() {
        return this.btnDagger;
    }

    public JButton getBtnSword() {
        return this.btnSword;
    }

    public JButton getBtnAxe() {
        return this.btnAxe;
    }

    public JButton getBtnNoWeapon() {
        return this.btnNoWeapon;
    }
    
}
