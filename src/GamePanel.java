import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JPanel panelButtons;

    private JLabel envBackground;

    private JLabel playerArmorValue;
    private JLabel playerWeaponValue;
    private JLabel playerHPValue;
    private JLabel playerAtkValue;
    private JLabel playerDefValue;
    private JLabel playerSpdValue;
    private JLabel oppHPValue;
    private JLabel oppAtkValue;
    private JLabel oppDefValue;
    private JLabel oppSpdValue;
    private JLabel gameHeader;

    private JButton btnAttack;
    private JButton btnDefend;
    private JButton btnCharge;
    private JButton btnReturn;

    private ImageIcon gameBackground;

    private String oppFileName;
    private String envFileName;

    public GamePanel() {
        
    }

    public void addGamePanel(GUI gui, Player player, Opponent opp) {
        gui.getGamePanel().setLayout(new BorderLayout());

        // CENTER PANEL
        gameBackground = new ImageIcon(envFileName);
        envBackground = new JLabel(gameBackground);
        envBackground.setLayout(new BorderLayout());
        
        // NORTH PANEL
        JPanel panelStats = new JPanel(new BorderLayout());
        panelStats.setOpaque(false);
        panelStats.setPreferredSize(new Dimension(1600, 200));

        // Add game header panel
        gameHeader = new JLabel("FIGHT!", SwingConstants.CENTER);
        gameHeader.setFont(new Font("Arial", Font.BOLD, 16));
        gameHeader.setForeground(Color.WHITE);

        // Add player stats panel
        JPanel playerStats = new JPanel(new GridLayout(3, 1));
        playerStats.setOpaque(false);
        playerStats.setPreferredSize(new Dimension(700, 200));

        // Add player name
        JLabel playerNameLabel = new JLabel(player.getName(), SwingConstants.CENTER);
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        playerNameLabel.setForeground(Color.WHITE);

        // Add player stat labels
        JPanel playerLabels = new JPanel(new GridLayout(1, 6));
        playerLabels.setOpaque(false);
        
        JLabel playerArmorLabel = new JLabel("Armor", SwingConstants.CENTER);
        playerArmorLabel.setForeground(Color.WHITE);
        playerArmorLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel playerWeaponLabel = new JLabel("Weapon", SwingConstants.CENTER);
        playerWeaponLabel.setForeground(Color.WHITE);
        playerWeaponLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel playerHPLabel = new JLabel("HP", SwingConstants.CENTER);
        playerHPLabel.setForeground(Color.WHITE);
        playerHPLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel playerAtkLabel = new JLabel("Attack", SwingConstants.CENTER);
        playerAtkLabel.setForeground(Color.WHITE);
        playerAtkLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel playerDefLabel = new JLabel("Defense", SwingConstants.CENTER);
        playerDefLabel.setForeground(Color.WHITE);
        playerDefLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel playerSpdLabel = new JLabel("Speed", SwingConstants.CENTER);
        playerSpdLabel.setForeground(Color.WHITE);
        playerSpdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        playerLabels.add(playerArmorLabel);
        playerLabels.add(playerWeaponLabel);
        playerLabels.add(playerHPLabel);
        playerLabels.add(playerAtkLabel);
        playerLabels.add(playerDefLabel);
        playerLabels.add(playerSpdLabel);
        
        // Add player stat values
        JPanel playerValues = new JPanel(new GridLayout(1, 6));      
        // playerValues.setFont(new Font("Arial", Font.PLAIN, 12));
        playerValues.setOpaque(false);

        playerArmorValue = new JLabel(player.getArmor().getName(), SwingConstants.CENTER);
        playerArmorValue.setForeground(Color.WHITE);
        playerArmorValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerWeaponValue = new JLabel(player.getWeapon().getName(), SwingConstants.CENTER);
        playerWeaponValue.setForeground(Color.WHITE);
        playerWeaponValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerHPValue = new JLabel(String.valueOf(player.getHp()), SwingConstants.CENTER);
        playerHPValue.setForeground(Color.WHITE);
        playerHPValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerAtkValue = new JLabel(String.valueOf(player.getAtk()), SwingConstants.CENTER);
        playerAtkValue.setForeground(Color.WHITE);
        playerAtkValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerDefValue = new JLabel(String.valueOf(player.getDef()), SwingConstants.CENTER);
        playerDefValue.setForeground(Color.WHITE);
        playerDefValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerSpdValue = new JLabel(String.valueOf(player.getSpd()), SwingConstants.CENTER);
        playerSpdValue.setForeground(Color.WHITE);
        playerSpdValue.setFont(new Font("Arial", Font.PLAIN, 16));

        playerValues.add(playerArmorValue);
        playerValues.add(playerWeaponValue);
        playerValues.add(playerHPValue);
        playerValues.add(playerAtkValue);
        playerValues.add(playerDefValue);
        playerValues.add(playerSpdValue);

        playerStats.add(playerNameLabel);
        playerStats.add(playerLabels);
        playerStats.add(playerValues);
        
        // Add opponent stats panel
        JPanel oppStats = new JPanel(new GridLayout(3, 1));
        oppStats.setOpaque(false);
        oppStats.setPreferredSize(new Dimension(700, 200));

        // Add opponent name
        JLabel oppNameLabel = new JLabel(opp.getName(), SwingConstants.CENTER);
        oppNameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        oppNameLabel.setForeground(Color.WHITE);

        // Add opponent stat labels
        JPanel oppLabels = new JPanel(new GridLayout(1, 4));
        oppLabels.setOpaque(false);

        JLabel oppHPLabel = new JLabel("HP", SwingConstants.CENTER);
        oppHPLabel.setForeground(Color.WHITE);
        oppHPLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel oppAtkLabel = new JLabel("Attack", SwingConstants.CENTER);
        oppAtkLabel.setForeground(Color.WHITE);
        oppAtkLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel oppDefLabel = new JLabel("Defense", SwingConstants.CENTER);
        oppDefLabel.setForeground(Color.WHITE);
        oppDefLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel oppSpdLabel = new JLabel("Speed", SwingConstants.CENTER);
        oppSpdLabel.setForeground(Color.WHITE);
        oppSpdLabel.setFont(new Font("Arial", Font.BOLD, 16));

        oppLabels.add(oppHPLabel);
        oppLabels.add(oppAtkLabel);
        oppLabels.add(oppDefLabel);
        oppLabels.add(oppSpdLabel);

        // Add opponent stat values
        JPanel oppValues = new JPanel(new GridLayout(1, 4));
        oppValues.setOpaque(false);

        oppHPValue = new JLabel(String.valueOf(opp.getHp()), SwingConstants.CENTER);
        oppHPValue.setForeground(Color.WHITE);
        oppHPValue.setFont(new Font("Arial", Font.PLAIN, 16));
        oppAtkValue = new JLabel(String.valueOf(opp.getAtk()), SwingConstants.CENTER);
        oppAtkValue.setForeground(Color.WHITE);
        oppAtkValue.setFont(new Font("Arial", Font.PLAIN, 16));
        oppDefValue = new JLabel(String.valueOf(opp.getDef()), SwingConstants.CENTER);
        oppDefValue.setForeground(Color.WHITE);
        oppDefValue.setFont(new Font("Arial", Font.PLAIN, 16));
        oppSpdValue = new JLabel(String.valueOf(opp.getSpd()), SwingConstants.CENTER);
        oppSpdValue.setForeground(Color.WHITE);
        oppSpdValue.setFont(new Font("Arial", Font.PLAIN, 16));

        oppValues.add(oppHPValue);
        oppValues.add(oppAtkValue);
        oppValues.add(oppDefValue);
        oppValues.add(oppSpdValue);

        oppStats.add(oppNameLabel);
        oppStats.add(oppLabels);
        oppStats.add(oppValues);

        // Add player and opponent stats to north panel
        panelStats.add(gameHeader, BorderLayout.CENTER);

        panelStats.add(playerStats, BorderLayout.WEST);
        panelStats.add(oppStats, BorderLayout.EAST);

        envBackground.add(panelStats, BorderLayout.NORTH);

        // SOUTH PANEL
        panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setOpaque(false);

        // Add attack button
        btnAttack = new JButton("Attack");
        btnAttack.setPreferredSize(new Dimension(200, 50));
        btnAttack.setFont(new Font("Arial", Font.BOLD, 20));

        // Add defend button
        btnDefend = new JButton("Defend");
        btnDefend.setPreferredSize(new Dimension(200, 50));
        btnDefend.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Add charge button
        btnCharge = new JButton("Charge");
        btnCharge.setPreferredSize(new Dimension(200, 50));
        btnCharge.setFont(new Font("Arial", Font.BOLD, 20));

        // Add buttons to button panel
        panelButtons.add(btnAttack);
        panelButtons.add(btnDefend);
        panelButtons.add(btnCharge);

        // WEST PANEL
        // Add player sprite
        ImageIcon playerSprite = new ImageIcon("Player.png");
        JLabel playerLabel = new JLabel(playerSprite, JLabel.CENTER);
        playerLabel.setPreferredSize(new Dimension(260, 480));
        
        JPanel playerLabelFlow = new JPanel(new GridLayout(1,1));
        playerLabelFlow.setOpaque(false);
        playerLabelFlow.setPreferredSize(new Dimension(700, 500));
        playerLabelFlow.add(playerLabel);
        
        // EAST PANEL
        // Add opponent sprite
        ImageIcon oppSprite = new ImageIcon(oppFileName);
        JLabel oppLabel = new JLabel(oppSprite, JLabel.CENTER);
        oppLabel.setPreferredSize(new Dimension(260, 480));
        
        JPanel oppLabelFlow = new JPanel(new GridLayout(1,1));
        oppLabelFlow.setOpaque(false);
        oppLabelFlow.setPreferredSize(new Dimension(700, 500));
        oppLabelFlow.add(oppLabel);
        
        envBackground.add(playerLabelFlow, BorderLayout.WEST);
        envBackground.add(oppLabelFlow, BorderLayout.EAST);
        envBackground.add(panelButtons, BorderLayout.SOUTH);

        gui.getGamePanel().add(envBackground, BorderLayout.CENTER);

        System.out.println("[LOG] Game panel created");
    }

    public void updateButtons(Player player) {
        // Remove all action buttons
        panelButtons.removeAll();

        // Add attack and defend buttons
        panelButtons.add(btnAttack);
        panelButtons.add(btnDefend);

        // Add charge button if player attack is not charged
        if(!player.isAtkCharged)
            panelButtons.add(btnCharge);
        
        panelButtons.revalidate();
        panelButtons.repaint();
    }

    public void updateStats(Player player, Opponent opp, boolean isGameOver, String prevOppAction) {
        // Update values of player stats
        playerArmorValue.setText(String.valueOf(player.getArmor().getName()));
        playerWeaponValue.setText(String.valueOf(player.getWeapon().getName()));
        playerHPValue.setText(String.valueOf(player.getHp()));
        playerAtkValue.setText(String.valueOf(player.getAtk()));
        playerDefValue.setText(String.valueOf(player.getDef()));
        playerSpdValue.setText(String.valueOf(player.getSpd()));

        // Update values of opponent stats
        oppHPValue.setText(String.valueOf(opp.getHp()));
        oppAtkValue.setText(String.valueOf(opp.getAtk()));
        oppDefValue.setText(String.valueOf(opp.getDef()));
        oppSpdValue.setText(String.valueOf(opp.getSpd()));

        // Update previous opponent action header
        gameHeader.setText(prevOppAction);

        System.out.println("[LOG] Updated game stats");
    }

    public JButton getBtnAttack() {
        return this.btnAttack;
    }
    
    public JButton getBtnDefend() {
        return this.btnDefend;
    }
    
    public JButton getBtnCharge() {
        return this.btnCharge;
    }

    public JButton getBtnReturn() {
        return this.btnReturn;
    }


    public void setBtnReturn(JButton btnReturn) {
        this.btnReturn = btnReturn;
    }

    public void setOppFileName(String oppFileName) {
        this.oppFileName = oppFileName;
    }

    public void setEnvironment(String envFileName) {
        this.envFileName = envFileName;
    }

}
