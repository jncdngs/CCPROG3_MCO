import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    
    private CardLayout mainLayout;

    private JPanel mainPanel;
    
    private JPanel startPanel;
    private JPanel menuBtnPanel;
    private JPanel namePanel;
    private JPanel armorPanel;
    private JPanel weaponPanel;
    private JPanel oppPanel;
    private JPanel envPanel;
    private JPanel gamePanel;
    
    private JLabel startBackground;
    private JLabel nameBackground;
    private JLabel namePrompt;
    
    private JButton btnPlay;
    private JButton btnQuit;

    private JButton btnName;

    private JButton btnLight;
    private JButton btnMedium;
    private JButton btnHeavy;
    private JButton btnNoArmor;

    private JButton btnDagger;
    private JButton btnSword;
    private JButton btnAxe;
    private JButton btnNoWeapon;

    private JButton btnThief;
    private JButton btnViking;
    private JButton btnMinotaur;

    private JButton btnArena;
    private JButton btnSwamp;
    private JButton btnColosseum;

    private JTextField nameField;

    private ImageIcon icon;
    private ImageIcon BackgroundImg;
    
    public GUI() {
        super("Warrior");
                
        icon = new ImageIcon("Icon.png");
        setIconImage(icon.getImage());
        
        setLayout(new BorderLayout());
        setSize(1600, 900);
        
        addMainPanel();
        
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addMainPanel() {      
        startPanel = new JPanel();
        gamePanel = new JPanel();
        namePanel = new JPanel();
        armorPanel = new JPanel();
        weaponPanel = new JPanel();
        oppPanel = new JPanel();
        envPanel = new JPanel();

        // Main card container panel
        mainLayout = new CardLayout(); 
        mainPanel = new JPanel(mainLayout);

        // Start menu panel
        addStartPanel();
        mainPanel.add(startPanel, "startPanel");

        // Name input panel
        addNamePanel();
        mainPanel.add(namePanel, "namePanel");

        // Armor selection panel
        addArmorPanel();
        mainPanel.add(armorPanel, "armorPanel");

        // Weapon selection panel
        addWeaponPanel();
        mainPanel.add(weaponPanel, "weaponPanel");

        // Opponent selection panel

        // Environment selection panel

        // Main game panel
        addGamePanel();
        mainPanel.add(gamePanel, "gamePanel");

        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void addStartPanel() {
        // startPanel = new JPanel(new BorderLayout());
        startPanel.setLayout(new BorderLayout());
        
        // Center panel
        BackgroundImg = new ImageIcon("Background.png");
        startBackground = new JLabel(BackgroundImg);
        startBackground.setLayout(new BorderLayout());
        
        // South panel
        menuBtnPanel = new JPanel(new FlowLayout());
        menuBtnPanel.setOpaque(false);
        menuBtnPanel.setPreferredSize(new Dimension(300, 300));

        btnPlay = new JButton("Play game");
        btnPlay.setPreferredSize(new Dimension(200, 50));
        btnPlay.setFont(new Font("Arial", Font.PLAIN, 20));
        
        btnQuit = new JButton("Quit game");
        btnQuit.setPreferredSize(new Dimension(200, 50));
        btnQuit.setFont(new Font("Arial", Font.PLAIN, 20));

        menuBtnPanel.add(btnPlay);
        menuBtnPanel.add(btnQuit);

        // Add buttons to background
        startBackground.add(menuBtnPanel, BorderLayout.SOUTH);

        // Add background to panel
        startPanel.add(startBackground, BorderLayout.CENTER);

        System.out.println("[LOG] Start panel created");
    }

    private void addNamePanel() {
        namePanel.setLayout(new BorderLayout());
        
        // Center panel
        namePrompt = new JLabel("Enter your name:");
        nameField = new JTextField(16);
        btnName = new JButton("Enter");

        namePrompt.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(100, 20));
        btnName.setPreferredSize(new Dimension(100, 50));

        JPanel nameMenu = new JPanel(new FlowLayout());
        nameMenu.setOpaque(false);
        nameMenu.setPreferredSize(new Dimension(300, 300));

        nameMenu.add(namePrompt);
        nameMenu.add(nameField);
        nameMenu.add(btnName);

        // Background
        nameBackground = new JLabel(BackgroundImg);
        nameBackground.setLayout(new BorderLayout());

        nameBackground.add(nameMenu, BorderLayout.SOUTH);

        namePanel.add(nameBackground, BorderLayout.CENTER);

        System.out.println("[LOG] Name panel created");
    }

    private void addArmorPanel() {
        armorPanel.setLayout(new BorderLayout());
        
        // North panel
        JPanel armorNorth = new JPanel(new FlowLayout());
        armorNorth.setOpaque(false);
        
        JLabel armorHeader = new JLabel("Pick an armor");
        armorHeader.setFont(new Font("Arial", Font.BOLD, 30));
        armorHeader.setPreferredSize(new Dimension(250, 200));

        armorNorth.add(armorHeader);

        // South panel
        JPanel armorSouth = new JPanel(new FlowLayout());
        armorSouth.setOpaque(false);

        btnNoArmor = new JButton("No armor");
        btnNoArmor.setFont(new Font("Arial", Font.BOLD, 20));
        btnNoArmor.setPreferredSize(new Dimension(200, 50));

        armorSouth.add(btnNoArmor);

        // West panel
        JPanel armorWest = new JPanel(new GridBagLayout());
        armorWest.setOpaque(false);
        armorWest.setPreferredSize(new Dimension(530, 700));

        ImageIcon westIcon = new ImageIcon("Light.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        
        JPanel westStats = new JPanel(new GridLayout(4,1));

        JLabel westDef = new JLabel("Defense: +20", JLabel.CENTER);
        westDef.setFont(new Font("Arial", Font.PLAIN, 20));
        westDef.setPreferredSize(new Dimension(200, 100));

        JLabel westSpd = new JLabel("Speed:   -5", JLabel.CENTER);
        westSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        westSpd.setPreferredSize(new Dimension(200, 100));

        btnLight = new JButton("Light");
        btnLight.setFont(new Font("Arial", Font.BOLD, 20));
        btnLight.setPreferredSize(new Dimension(200, 50));

        westStats.add(westIconLabel);
        westStats.add(westDef);
        westStats.add(westSpd);
        westStats.add(btnLight);

        armorWest.add(westStats);

        // Center panel
        JPanel armorCenter = new JPanel(new GridBagLayout());
        armorCenter.setOpaque(false);
        armorCenter.setPreferredSize(new Dimension(530, 700));

        ImageIcon centerIcon = new ImageIcon("Medium.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);

        JPanel centerStats = new JPanel(new GridLayout(4,1));

        JLabel centerDef = new JLabel("Defense: +30", JLabel.CENTER);
        centerDef.setFont(new Font("Arial", Font.PLAIN, 20));
        centerDef.setPreferredSize(new Dimension(200, 100));

        JLabel centerSpd = new JLabel("Speed:   -15", JLabel.CENTER);
        centerSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        centerSpd.setPreferredSize(new Dimension(200, 100));

        btnMedium = new JButton("Medium");
        btnMedium.setFont(new Font("Arial", Font.BOLD, 20));
        btnMedium.setPreferredSize(new Dimension(200, 50));

        centerStats.add(centerIconLabel);
        centerStats.add(centerDef);
        centerStats.add(centerSpd);
        centerStats.add(btnMedium);

        armorCenter.add(centerStats);

        // East panel
        JPanel armorEast = new JPanel(new GridBagLayout());
        armorEast.setOpaque(false);
        armorEast.setPreferredSize(new Dimension(530, 700));

        ImageIcon eastIcon = new ImageIcon("Medium.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);

        JPanel eastStats = new JPanel(new GridLayout(4,1));

        JLabel eastDef = new JLabel("Defense: +40", JLabel.CENTER);
        eastDef.setFont(new Font("Arial", Font.PLAIN, 20));
        eastDef.setPreferredSize(new Dimension(200, 100));

        JLabel eastSpd = new JLabel("Speed:   -25", JLabel.CENTER);
        eastSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        eastSpd.setPreferredSize(new Dimension(200, 100));

        btnHeavy = new JButton("Heavy");
        btnHeavy.setFont(new Font("Arial", Font.BOLD, 20));
        btnHeavy.setPreferredSize(new Dimension(200, 50));

        eastStats.add(eastIconLabel);
        eastStats.add(eastDef);
        eastStats.add(eastSpd);
        eastStats.add(btnHeavy);

        armorEast.add(eastStats);

        // Add to armor panel
        armorPanel.add(armorNorth, BorderLayout.NORTH);
        armorPanel.add(armorSouth, BorderLayout.SOUTH);
        armorPanel.add(armorWest, BorderLayout.WEST);
        armorPanel.add(armorCenter, BorderLayout.CENTER);
        armorPanel.add(armorEast, BorderLayout.EAST);

        System.out.println("[LOG] Armor panel created");
    }

    private void addWeaponPanel() {
        weaponPanel.setLayout(new BorderLayout());
        
        // North panel
        JPanel weaponNorth = new JPanel(new FlowLayout());
        weaponNorth.setOpaque(false);
        
        JLabel weaponHeader = new JLabel("Pick a weapon");
        weaponHeader.setFont(new Font("Arial", Font.BOLD, 30));
        weaponHeader.setPreferredSize(new Dimension(250, 200));

        weaponNorth.add(weaponHeader);

        // South panel
        JPanel weaponSouth = new JPanel(new FlowLayout());
        weaponSouth.setOpaque(false);

        btnNoWeapon = new JButton("No weapon");
        btnNoWeapon.setFont(new Font("Arial", Font.BOLD, 20));
        btnNoWeapon.setPreferredSize(new Dimension(200, 50));

        weaponSouth.add(btnNoWeapon);

        // West panel
        JPanel weaponWest = new JPanel(new GridBagLayout());
        weaponWest.setOpaque(false);
        weaponWest.setPreferredSize(new Dimension(530, 700));

        ImageIcon westIcon = new ImageIcon("Dagger.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        
        JPanel westStats = new JPanel(new GridLayout(4,1));

        JLabel westAtk = new JLabel("Attack: +20", JLabel.CENTER);
        westAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        westAtk.setPreferredSize(new Dimension(200, 100));

        JLabel westSpd = new JLabel("Speed:   0", JLabel.CENTER);
        westSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        westSpd.setPreferredSize(new Dimension(200, 100));

        btnDagger = new JButton("Dagger");
        btnDagger.setFont(new Font("Arial", Font.BOLD, 20));
        btnDagger.setPreferredSize(new Dimension(200, 50));

        westStats.add(westIconLabel);
        westStats.add(westAtk);
        westStats.add(westSpd);
        westStats.add(btnDagger);

        weaponWest.add(westStats);

        // Center panel
        JPanel weaponCenter = new JPanel(new GridBagLayout());
        weaponCenter.setOpaque(false);
        weaponCenter.setPreferredSize(new Dimension(530, 700));

        ImageIcon centerIcon = new ImageIcon("Sword.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);

        JPanel centerStats = new JPanel(new GridLayout(4,1));

        JLabel centerAtk = new JLabel("Attack: +30", JLabel.CENTER);
        centerAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        centerAtk.setPreferredSize(new Dimension(200, 100));

        JLabel centerSpd = new JLabel("Speed:   -10", JLabel.CENTER);
        centerSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        centerSpd.setPreferredSize(new Dimension(200, 100));

        btnSword = new JButton("Sword");
        btnSword.setFont(new Font("Arial", Font.BOLD, 20));
        btnSword.setPreferredSize(new Dimension(200, 50));

        centerStats.add(centerIconLabel);
        centerStats.add(centerAtk);
        centerStats.add(centerSpd);
        centerStats.add(btnSword);

        weaponCenter.add(centerStats);

        // East panel
        JPanel weaponEast = new JPanel(new GridBagLayout());
        weaponEast.setOpaque(false);
        weaponEast.setPreferredSize(new Dimension(530, 700));

        ImageIcon eastIcon = new ImageIcon("Axe.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);

        JPanel eastStats = new JPanel(new GridLayout(4,1));

        JLabel eastAtk = new JLabel("Attack: +40", JLabel.CENTER);
        eastAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        eastAtk.setPreferredSize(new Dimension(200, 100));

        JLabel eastSpd = new JLabel("Speed:   -20", JLabel.CENTER);
        eastSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        eastSpd.setPreferredSize(new Dimension(200, 100));

        btnAxe = new JButton("Battle Axe");
        btnAxe.setFont(new Font("Arial", Font.BOLD, 20));
        btnAxe.setPreferredSize(new Dimension(200, 50));

        eastStats.add(eastIconLabel);
        eastStats.add(eastAtk);
        eastStats.add(eastSpd);
        eastStats.add(btnAxe);

        weaponEast.add(eastStats);

        // Add to weapon panel
        weaponPanel.add(weaponNorth, BorderLayout.NORTH);
        weaponPanel.add(weaponSouth, BorderLayout.SOUTH);
        weaponPanel.add(weaponWest, BorderLayout.WEST);
        weaponPanel.add(weaponCenter, BorderLayout.CENTER);
        weaponPanel.add(weaponEast, BorderLayout.EAST);

        System.out.println("[LOG] Weapon panel created");
    }

    private void addGamePanel() {
        gamePanel.setLayout(new BorderLayout());
        
        // North panel
        JPanel panelStats = new JPanel(new FlowLayout());
        panelStats.setOpaque(false);
        // panelStats.setBackground(Color.GRAY);

        JLabel gameHeader = new JLabel("North Panel");
        gameHeader.setForeground(Color.WHITE);
        gameHeader.setFont(new Font("Arial", Font.BOLD, 30));
        panelStats.add(gameHeader);

        gamePanel.add(panelStats, BorderLayout.NORTH);

        // South Panel
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setOpaque(false);
        // panelButtons.setBackground(Color.GRAY);

        JButton btnAttack = new JButton("Attack");
        btnAttack.setPreferredSize(new Dimension(200, 50));
        btnAttack.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton btnDefend = new JButton("Defend");
        btnDefend.setPreferredSize(new Dimension(200, 50));
        btnDefend.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton btnCharge = new JButton("Charge");
        btnCharge.setPreferredSize(new Dimension(200, 50));
        btnCharge.setFont(new Font("Arial", Font.PLAIN, 20));

        panelButtons.add(btnAttack);
        panelButtons.add(btnDefend);
        panelButtons.add(btnCharge);

        gamePanel.add(panelButtons, BorderLayout.SOUTH);

        System.out.println("[LOG] Game panel created");
    }

    public void setActionListeners(ActionListener l) {
        btnPlay.addActionListener(l);
        btnQuit.addActionListener(l);
        btnName.addActionListener(l);

        btnLight.addActionListener(l);
        btnMedium.addActionListener(l);
        btnHeavy.addActionListener(l);
        btnNoArmor.addActionListener(l);

        btnDagger.addActionListener(l);
        btnSword.addActionListener(l);
        btnAxe.addActionListener(l);
        btnNoWeapon.addActionListener(l);

        // btnThief.addActionListener(l);
        // btnViking.addActionListener(l);
        // btnMinotaur.addActionListener(l);

        // btnArena.addActionListener(l);
        // btnSwamp.addActionListener(l);
        // btnColosseum.addActionListener(l);
    }



    public CardLayout getMainLayout() {
        return this.mainLayout;
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JPanel getStartPanel() {
        return this.startPanel;
    }
    
    public JPanel getMenuBtnPanel() {
        return this.menuBtnPanel;
    }

    public JLabel getstartBackground() {
        return this.startBackground;
    }

    public JButton getBtnPlay() {
        return this.btnPlay;
    }

    public JButton getBtnQuit() {
        return this.btnQuit;
    }

    public JButton getBtnName() {
        return this.btnName;
    }

    public JButton getBtnLight() {
        return this.btnLight;
    }

    public JButton getBtnMedium() {
        return this.btnMedium;
    }

    public JButton getBtnHeavy() {
        return this.btnHeavy;
    }

    public JButton getBtnNoArmor() {
        return this.btnNoArmor;
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

    public JTextField getNameField() {
        return this.nameField;
    }



    public void setMainLayout(CardLayout mainLayout) {
        this.mainLayout = mainLayout;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    public void setStartPanel(JPanel startPanel) {
        this.startPanel = startPanel;
    }            

    public void setMenuBtnPanel(JPanel menuBtnPanel) {
        this.menuBtnPanel = menuBtnPanel;
    }            

    public void setstartBackground(JLabel startBackground) {
        this.startBackground = startBackground;
    }        

    public void setBtnPlay(JButton btnPlay) {
        this.btnPlay = btnPlay;
    }    

    public void setBtnQuit(JButton btnQuit) {
        this.btnQuit = btnQuit;
    }

    public void setBtnLight(JButton btnLight) {
        this.btnLight = btnLight;
    }

    public void setBtnMedium(JButton btnMedium) {
        this.btnMedium = btnMedium;
    }

    public void setBtnHeavy(JButton btnHeavy) {
        this.btnHeavy = btnHeavy;
    }

    public void setBtnNoArmor(JButton btnNoArmor) {
        this.btnNoArmor = btnNoArmor;
    }

    public void setBtnDagger(JButton btnDagger) {
        this.btnDagger = btnDagger;
    }

    public void setBtnSword(JButton btnSword) {
        this.btnSword = btnSword;
    }

    public void setBtnAxe(JButton btnAxe) {
        this.btnAxe = btnAxe;
    }

    public void setBtnNoWeapon(JButton btnNoWeapon) {
        this.btnNoWeapon = btnNoWeapon;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

}
