import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    
    private GamePanel gamePanel;

    private CardLayout mainLayout;

    private JPanel mainPanel;
    
    private JPanel startPanel;
    private JPanel menuBtnPanel;
    private JPanel namePanel;
    private JPanel armorPanel;
    private JPanel weaponPanel;
    private JPanel oppPanel;
    private JPanel envPanel;
    // private JPanel gamePanel;
    private JPanel winPanel;
    
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
    private ImageIcon startImg;
    
    public GUI() {
        // Set window name
        super("Warrior");

        // Set window icon
        icon = new ImageIcon("Icon.png");
        setIconImage(icon.getImage());
        
        // Set size and layout
        setLayout(new BorderLayout());
        setSize(1600, 900);
        
        addSetupPanel();
        
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addSetupPanel() {
        startPanel = new JPanel();
        gamePanel = new GamePanel();
        namePanel = new JPanel();
        armorPanel = new JPanel();
        weaponPanel = new JPanel();
        oppPanel = new JPanel();
        envPanel = new JPanel();
        winPanel = new JPanel();

        // Main card container panel
        mainLayout = new CardLayout(); 
        mainPanel = new JPanel(mainLayout);

        // Start menu panel
        addStartPanel();
        mainPanel.add(startPanel, "startPanel");
        System.out.println("[LOG] Added start panel to container");

        // Name input panel
        addNamePanel();
        mainPanel.add(namePanel, "namePanel");
        System.out.println("[LOG] Added name panel to container");

        // Armor selection panel
        addArmorPanel();
        mainPanel.add(armorPanel, "armorPanel");
        System.out.println("[LOG] Added armor panel to container");

        // Weapon selection panel
        addWeaponPanel();
        mainPanel.add(weaponPanel, "weaponPanel");
        System.out.println("[LOG] Added weapon panel to container");

        // Opponent selection panel
        addOppPanel();
        mainPanel.add(oppPanel, "oppPanel");
        System.out.println("[LOG] Added opp panel to container");

        // Environment selection panel
        addEnvPanel();
        mainPanel.add(envPanel, "envPanel");
        System.out.println("[LOG] Added env panel to container");

        // Winner panel return button
        // gamePanel.getBtnReturn() = new JButton("Return to main menu");
        gamePanel.setBtnReturn(new JButton("Return to main menu"));
        
        gamePanel.getBtnReturn().setPreferredSize(new Dimension(300, 50));
        gamePanel.getBtnReturn().setFont(new Font("Arial", Font.BOLD, 20));

        // Add to frame
        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void addStartPanel() {
        startPanel.setLayout(new BorderLayout());
        
        // CENTER PANEL
        // Set background image
        startImg = new ImageIcon("Background.png");
        startBackground = new JLabel(startImg);
        startBackground.setLayout(new BorderLayout());
        
        // SOUTH PANEL
        // Set layout for buttons
        menuBtnPanel = new JPanel(new FlowLayout());
        menuBtnPanel.setOpaque(false);
        menuBtnPanel.setPreferredSize(new Dimension(300, 300));

        // Add play button
        btnPlay = new JButton("Play");
        btnPlay.setPreferredSize(new Dimension(200, 50));
        btnPlay.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // Add quit button
        btnQuit = new JButton("Quit");
        btnQuit.setPreferredSize(new Dimension(200, 50));
        btnQuit.setFont(new Font("Arial", Font.PLAIN, 20));

        // Add buttons to button panel
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
        
        // CENTER PANEL
        // Add prompt
        namePrompt = new JLabel("Enter your name:");
        namePrompt.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // Add text box
        nameField = new JTextField(12);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(100, 40));
        
        // Add enter button
        btnName = new JButton("Enter");
        btnName.setFont(new Font("Arial", Font.PLAIN, 20));
        btnName.setPreferredSize(new Dimension(100, 40));

        JPanel nameMenu = new JPanel(new FlowLayout());
        nameMenu.setOpaque(false);
        nameMenu.setPreferredSize(new Dimension(300, 300));

        // Add prompt, text box, and button to panel
        nameMenu.add(namePrompt);
        nameMenu.add(nameField);
        nameMenu.add(btnName);

        // Set background image
        nameBackground = new JLabel(startImg);
        nameBackground.setLayout(new BorderLayout());

        nameBackground.add(nameMenu, BorderLayout.SOUTH);

        namePanel.add(nameBackground, BorderLayout.CENTER);

        System.out.println("[LOG] Name panel created");
    }

    private void addArmorPanel() {
        armorPanel.setLayout(new BorderLayout());
        
        // NORTH PANEL
        JPanel armorNorth = new JPanel(new FlowLayout());
        armorNorth.setOpaque(false);
        
        JLabel armorHeader = new JLabel("Pick an armor", SwingConstants.CENTER);
        armorHeader.setFont(new Font("Arial", Font.BOLD, 30));
        armorHeader.setPreferredSize(new Dimension(300, 100));

        armorNorth.add(armorHeader);

        // SOUTH PANEL
        JPanel armorSouth = new JPanel(new FlowLayout());
        armorSouth.setOpaque(false);

        btnNoArmor = new JButton("No armor");
        btnNoArmor.setFont(new Font("Arial", Font.BOLD, 20));
        btnNoArmor.setPreferredSize(new Dimension(200, 50));

        armorSouth.add(btnNoArmor);

        // WEST PANEL
        JPanel armorWest = new JPanel();
        armorWest.setLayout(new BoxLayout(armorWest, BoxLayout.PAGE_AXIS));
        armorWest.setOpaque(false);
        armorWest.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon westIcon = new ImageIcon("Light.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        westIconLabel.setPreferredSize(new Dimension(250, 275));
        
        JPanel westIconFlow = new JPanel(new FlowLayout());
        westIconFlow.setPreferredSize(new Dimension(250, 300));
        westIconFlow.add(westIconLabel);

        // Add stats
        JPanel westStats = new JPanel(new GridLayout(2,1));
        westStats.setPreferredSize(new Dimension(300, 200));

        JLabel westDef = new JLabel("Defense: +20", JLabel.CENTER);
        westDef.setFont(new Font("Arial", Font.PLAIN, 20));
        westDef.setPreferredSize(new Dimension(200, 100));

        JLabel westSpd = new JLabel("Speed:   -5", JLabel.CENTER);
        westSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        westSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnLight = new JButton("Light");
        btnLight.setFont(new Font("Arial", Font.BOLD, 20));
        btnLight.setPreferredSize(new Dimension(200, 50));

        JPanel btnLightFlow = new JPanel(new FlowLayout());
        btnLightFlow.add(btnLight);

        // Add to stats panel
        westStats.add(westDef);
        westStats.add(westSpd);

        // Add to west panel
        armorWest.add(westIconFlow);
        armorWest.add(westStats);
        armorWest.add(btnLightFlow);

        // CENTER PANEL
        JPanel armorCenter = new JPanel();
        armorCenter.setLayout(new BoxLayout(armorCenter, BoxLayout.PAGE_AXIS));
        armorCenter.setOpaque(false);
        armorCenter.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon centerIcon = new ImageIcon("Medium.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);
        centerIconLabel.setPreferredSize(new Dimension(250, 275));

        JPanel centerIconFlow = new JPanel(new FlowLayout());
        centerIconFlow.setPreferredSize(new Dimension(250, 300));
        centerIconFlow.add(centerIconLabel);

        // Add stats
        JPanel centerStats = new JPanel(new GridLayout(2,1));
        centerStats.setPreferredSize(new Dimension(300, 200));

        JLabel centerDef = new JLabel("Defense: +30", JLabel.CENTER);
        centerDef.setFont(new Font("Arial", Font.PLAIN, 20));
        centerDef.setPreferredSize(new Dimension(200, 100));

        JLabel centerSpd = new JLabel("Speed:   -15", JLabel.CENTER);
        centerSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        centerSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnMedium = new JButton("Medium");
        btnMedium.setFont(new Font("Arial", Font.BOLD, 20));
        btnMedium.setPreferredSize(new Dimension(200, 50));

        JPanel btnMediumFlow = new JPanel(new FlowLayout());
        btnMediumFlow.add(btnMedium);

        // Add to stats panel
        centerStats.add(centerDef);
        centerStats.add(centerSpd);

        // Add to center panel
        armorCenter.add(centerIconFlow);
        armorCenter.add(centerStats);
        armorCenter.add(btnMediumFlow);

        // EAST PANEL
        JPanel armorEast = new JPanel(new GridBagLayout());
        armorEast.setLayout(new BoxLayout(armorEast, BoxLayout.PAGE_AXIS));
        armorEast.setOpaque(false);
        armorEast.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon eastIcon = new ImageIcon("Heavy.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);
        eastIconLabel.setPreferredSize(new Dimension(250, 275));

        JPanel eastIconFlow = new JPanel(new FlowLayout());
        eastIconFlow.setPreferredSize(new Dimension(250, 300));
        eastIconFlow.add(eastIconLabel);

        // Add stats
        JPanel eastStats = new JPanel(new GridLayout(2,1));
        eastStats.setPreferredSize(new Dimension(300, 200));

        JLabel eastDef = new JLabel("Defense: +40", JLabel.CENTER);
        eastDef.setFont(new Font("Arial", Font.PLAIN, 20));
        eastDef.setPreferredSize(new Dimension(200, 100));

        JLabel eastSpd = new JLabel("Speed:   -25", JLabel.CENTER);
        eastSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        eastSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnHeavy = new JButton("Heavy");
        btnHeavy.setFont(new Font("Arial", Font.BOLD, 20));
        btnHeavy.setPreferredSize(new Dimension(200, 50));

        JPanel btnHeavyFlow = new JPanel(new FlowLayout());
        btnHeavyFlow.add(btnHeavy);

        // Add to stats panel
        eastStats.add(eastDef);
        eastStats.add(eastSpd);

        // Add to east panel
        armorEast.add(eastIconFlow);
        armorEast.add(eastStats);
        armorEast.add(btnHeavyFlow);

        // Add all panels to armor panel
        armorPanel.add(armorNorth, BorderLayout.NORTH);
        armorPanel.add(armorSouth, BorderLayout.SOUTH);
        armorPanel.add(armorWest, BorderLayout.WEST);
        armorPanel.add(armorCenter, BorderLayout.CENTER);
        armorPanel.add(armorEast, BorderLayout.EAST);

        System.out.println("[LOG] Armor panel created");
    }

    private void addWeaponPanel() {
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

    private void addOppPanel() {
        oppPanel.setLayout(new BorderLayout());
        
        // NORTH PANEL
        JPanel oppNorth = new JPanel(new FlowLayout());
        oppNorth.setOpaque(false);
        
        JLabel oppHeader = new JLabel("Pick an opponent", SwingConstants.CENTER);
        oppHeader.setFont(new Font("Arial", Font.BOLD, 30));
        oppHeader.setPreferredSize(new Dimension(300, 100));

        oppNorth.add(oppHeader);

        // WEST PANEL
        JPanel oppWest = new JPanel(new GridLayout(3, 1));
        oppWest.setOpaque(false);
        oppWest.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon westIcon = new ImageIcon("ThiefThumb.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        westIconLabel.setPreferredSize(new Dimension(250, 275));

        JPanel westIconFlow = new JPanel(new FlowLayout());
        westIconFlow.setPreferredSize(new Dimension(130, 240));
        westIconFlow.add(westIconLabel);
        
        // Add stats
        JPanel westStats = new JPanel(new GridLayout(4, 1));
        westStats.setPreferredSize(new Dimension(600, 700));

        JLabel westHp = new JLabel("HP: 150", JLabel.CENTER);
        westHp.setFont(new Font("Arial", Font.PLAIN, 20));
        westHp.setPreferredSize(new Dimension(200, 100));

        JLabel westAtk = new JLabel("Attack: 20", JLabel.CENTER);
        westAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        westAtk.setPreferredSize(new Dimension(200, 100));

        JLabel westDef = new JLabel("Defense: 20", JLabel.CENTER);
        westDef.setFont(new Font("Arial", Font.PLAIN, 20));
        westDef.setPreferredSize(new Dimension(200, 100));

        JLabel westSpd = new JLabel("Speed: 40", JLabel.CENTER);
        westSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        westSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnThief = new JButton("Thief");
        btnThief.setFont(new Font("Arial", Font.BOLD, 20));
        btnThief.setPreferredSize(new Dimension(200, 50));

        JPanel btnThiefFlow = new JPanel(new FlowLayout());
        btnThiefFlow.add(btnThief);

        // Add to stats panel
        westStats.add(westHp);
        westStats.add(westAtk);
        westStats.add(westDef);
        westStats.add(westSpd);

        // Add to west panel
        oppWest.add(westIconFlow);
        oppWest.add(westStats);
        oppWest.add(btnThiefFlow);

        // CENTER PANEL
        JPanel oppCenter = new JPanel(new GridLayout(3, 1));
        oppCenter.setOpaque(false);
        oppCenter.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon centerIcon = new ImageIcon("VikingThumb.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);
        centerIconLabel.setPreferredSize(new Dimension(250, 275));
        
        JPanel centerIconFlow = new JPanel(new FlowLayout());
        centerIconFlow.setPreferredSize(new Dimension(130, 240));
        centerIconFlow.add(centerIconLabel);

        // Add stats
        JPanel centerStats = new JPanel(new GridLayout(4,1));
        centerStats.setPreferredSize(new Dimension(600, 700));

        JLabel centerHp = new JLabel("HP: 250", JLabel.CENTER);
        centerHp.setFont(new Font("Arial", Font.PLAIN, 20));
        centerHp.setPreferredSize(new Dimension(200, 100));

        JLabel centerAtk = new JLabel("Attack: 30", JLabel.CENTER);
        centerAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        centerAtk.setPreferredSize(new Dimension(200, 100));

        JLabel centerDef = new JLabel("Defense: 30", JLabel.CENTER);
        centerDef.setFont(new Font("Arial", Font.PLAIN, 20));
        centerDef.setPreferredSize(new Dimension(200, 100));

        JLabel centerSpd = new JLabel("Speed: 30", JLabel.CENTER);
        centerSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        centerSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnViking = new JButton("Viking");
        btnViking.setFont(new Font("Arial", Font.BOLD, 20));
        btnViking.setPreferredSize(new Dimension(200, 50));

        JPanel btnVikingFlow = new JPanel(new FlowLayout());
        btnVikingFlow.add(btnViking);

        // Add to stats panel
        centerStats.add(centerHp);
        centerStats.add(centerAtk);
        centerStats.add(centerDef);
        centerStats.add(centerSpd);

        // Add to center panel
        oppCenter.add(centerIconFlow);
        oppCenter.add(centerStats);
        oppCenter.add(btnVikingFlow);
        
        // EAST PANEL
        JPanel oppEast = new JPanel(new GridLayout(3, 1));
        oppEast.setOpaque(false);
        oppEast.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon eastIcon = new ImageIcon("MinotaurThumb.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);
        eastIconLabel.setPreferredSize(new Dimension(250, 275));
        
        JPanel eastIconFlow = new JPanel(new FlowLayout());
        eastIconFlow.setPreferredSize(new Dimension(130, 240));
        eastIconFlow.add(eastIconLabel);

        // Add stats
        JPanel eastStats = new JPanel(new GridLayout(4,1));
        eastStats.setPreferredSize(new Dimension(600, 700));

        JLabel eastHp = new JLabel("HP: 350", JLabel.CENTER);
        eastHp.setFont(new Font("Arial", Font.PLAIN, 20));
        eastHp.setPreferredSize(new Dimension(200, 100));

        JLabel eastAtk = new JLabel("Attack: 40", JLabel.CENTER);
        eastAtk.setFont(new Font("Arial", Font.PLAIN, 20));
        eastAtk.setPreferredSize(new Dimension(200, 100));

        JLabel eastDef = new JLabel("Defense: 40", JLabel.CENTER);
        eastDef.setFont(new Font("Arial", Font.PLAIN, 20));
        eastDef.setPreferredSize(new Dimension(200, 100));

        JLabel eastSpd = new JLabel("Speed: 20", JLabel.CENTER);
        eastSpd.setFont(new Font("Arial", Font.PLAIN, 20));
        eastSpd.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnMinotaur = new JButton("Minotaur");
        btnMinotaur.setFont(new Font("Arial", Font.BOLD, 20));
        btnMinotaur.setPreferredSize(new Dimension(200, 50));

        JPanel btnMinotaurFlow = new JPanel(new FlowLayout());
        btnMinotaurFlow.add(btnMinotaur);

        // Add to stats panel
        eastStats.add(eastHp);
        eastStats.add(eastAtk);
        eastStats.add(eastDef);
        eastStats.add(eastSpd);

        // Add to east panel
        oppEast.add(eastIconFlow);
        oppEast.add(eastStats);
        oppEast.add(btnMinotaurFlow);

        // Add all panels to opponent panel
        oppPanel.add(oppNorth, BorderLayout.NORTH);
        oppPanel.add(oppWest, BorderLayout.WEST);
        oppPanel.add(oppCenter, BorderLayout.CENTER);
        oppPanel.add(oppEast, BorderLayout.EAST);

        System.out.println("[LOG] Opponent panel created");
    }

    private void addEnvPanel() {
        envPanel.setLayout(new BorderLayout());
        
        // NORTH PANEL
        JPanel envNorth = new JPanel(new FlowLayout());
        envNorth.setOpaque(false);
        
        JLabel envHeader = new JLabel("Pick an environment", SwingConstants.CENTER);
        envHeader.setFont(new Font("Arial", Font.BOLD, 30));
        envHeader.setPreferredSize(new Dimension(300, 100));

        envNorth.add(envHeader);

        // WEST PANEL
        JPanel envWest = new JPanel();
        envWest.setLayout(new BoxLayout(envWest, BoxLayout.PAGE_AXIS));
        envWest.setOpaque(false);
        envWest.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon westIcon = new ImageIcon("ArenaThumb.png");
        JLabel westIconLabel = new JLabel(westIcon, JLabel.CENTER);
        westIconLabel.setPreferredSize(new Dimension(400, 300));
        
        JPanel westIconFlow = new JPanel(new FlowLayout());
        westIconFlow.setPreferredSize(new Dimension(300, 300));
        westIconFlow.add(westIconLabel);

        // Add stats
        JPanel westStats = new JPanel(new GridLayout(2,1));
        westStats.setPreferredSize(new Dimension(300, 200));

        JLabel westPlayer = new JLabel("Player: No Penalty", JLabel.CENTER);
        westPlayer.setFont(new Font("Arial", Font.PLAIN, 20));
        westPlayer.setPreferredSize(new Dimension(200, 100));

        JLabel westOpp = new JLabel("Opponent: No Penalty", JLabel.CENTER);
        westOpp.setFont(new Font("Arial", Font.PLAIN, 20));
        westOpp.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnArena = new JButton("Arena");
        btnArena.setFont(new Font("Arial", Font.BOLD, 20));
        btnArena.setPreferredSize(new Dimension(200, 50));

        JPanel btnArenaFlow = new JPanel(new FlowLayout());
        btnArenaFlow.add(btnArena);

        // Add to stats panel
        westStats.add(westPlayer);
        westStats.add(westOpp);
        
        // Add to west panel
        envWest.add(westIconFlow);
        envWest.add(westStats);
        envWest.add(btnArenaFlow);
        
        // CENTER PANEL
        JPanel envCenter = new JPanel();
        envCenter.setLayout(new BoxLayout(envCenter, BoxLayout.PAGE_AXIS));
        envCenter.setOpaque(false);
        envCenter.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon centerIcon = new ImageIcon("SwampThumb.png");
        JLabel centerIconLabel = new JLabel(centerIcon, JLabel.CENTER);
        centerIconLabel.setPreferredSize(new Dimension(400, 300));

        JPanel centerIconFlow = new JPanel(new FlowLayout());
        centerIconFlow.setPreferredSize(new Dimension(300, 300));
        centerIconFlow.add(centerIconLabel);

        // Add stats
        JPanel centerStats = new JPanel(new GridLayout(2,1));
        centerStats.setPreferredSize(new Dimension(300, 200));

        JLabel centerPlayer = new JLabel("Player: -1 HP every turn", JLabel.CENTER);
        centerPlayer.setFont(new Font("Arial", Font.PLAIN, 20));
        centerPlayer.setPreferredSize(new Dimension(200, 100));

        JLabel centerOpp = new JLabel("Opponent: +1 attack every turn", JLabel.CENTER);
        centerOpp.setFont(new Font("Arial", Font.PLAIN, 20));
        centerOpp.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnSwamp = new JButton("Swamp");
        btnSwamp.setFont(new Font("Arial", Font.BOLD, 20));
        btnSwamp.setPreferredSize(new Dimension(200, 50));

        JPanel btnSwampFlow = new JPanel(new FlowLayout());
        btnSwampFlow.add(btnSwamp);

        // Add to stats panel
        centerStats.add(centerPlayer);
        centerStats.add(centerOpp);
        
        // Add to center panel
        envCenter.add(centerIconFlow);
        envCenter.add(centerStats);
        envCenter.add(btnSwampFlow);

        // EAST PANEL
        JPanel envEast = new JPanel();
        envEast.setLayout(new BoxLayout(envEast, BoxLayout.PAGE_AXIS));
        envEast.setOpaque(false);
        envEast.setPreferredSize(new Dimension(500, 700));

        // Add icon
        ImageIcon eastIcon = new ImageIcon("ColosseumThumb.png");
        JLabel eastIconLabel = new JLabel(eastIcon, JLabel.CENTER);
        eastIconLabel.setPreferredSize(new Dimension(400, 300));

        JPanel eastIconFlow = new JPanel(new FlowLayout());
        eastIconFlow.setPreferredSize(new Dimension(300, 300));
        eastIconFlow.add(eastIconLabel);

        // Add stats
        JPanel eastStats = new JPanel(new GridLayout(2,1));
        eastStats.setPreferredSize(new Dimension(300, 200));

        JLabel eastPlayer = new JLabel("Player: +1 attack every turn", JLabel.CENTER);
        eastPlayer.setFont(new Font("Arial", Font.PLAIN, 20));
        eastPlayer.setPreferredSize(new Dimension(200, 100));

        JLabel eastOpp = new JLabel("Opponent: -1 defense every turn", JLabel.CENTER);
        eastOpp.setFont(new Font("Arial", Font.PLAIN, 20));
        eastOpp.setPreferredSize(new Dimension(200, 100));

        // Add select button
        btnColosseum = new JButton("Colosseum");
        btnColosseum.setFont(new Font("Arial", Font.BOLD, 20));
        btnColosseum.setPreferredSize(new Dimension(200, 50));

        JPanel btnColosseumFlow = new JPanel(new FlowLayout());
        btnColosseumFlow.add(btnColosseum);

        // Add to stats panel
        eastStats.add(eastPlayer);
        eastStats.add(eastOpp);
        
        // Add to east panel
        envEast.add(eastIconFlow);
        envEast.add(eastStats);
        envEast.add(btnColosseumFlow);
        
        // Add all panels to environment panel
        envPanel.add(envNorth, BorderLayout.NORTH);
        envPanel.add(envWest, BorderLayout.WEST);
        envPanel.add(envCenter, BorderLayout.CENTER);
        envPanel.add(envEast, BorderLayout.EAST);

        System.out.println("[LOG] Environment panel created");
    }

    public void displayWinPanel(String winner, int moveCounter) {
        winPanel = new JPanel();
        winPanel.setLayout(new GridBagLayout());

        JPanel winGrid = new JPanel(new GridLayout(3,1));
        winGrid.setPreferredSize(new Dimension(1400, 200));

        JLabel winnerLabel = new JLabel(winner + " won!", SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JLabel countLabel = new JLabel("The game was won in " + moveCounter + " moves", SwingConstants.CENTER);
        countLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        // Add return button to a flow panel to resize
        JPanel btnReturnFlow = new JPanel(new FlowLayout());
        btnReturnFlow.add(gamePanel.getBtnReturn());

        // Add labels and button to panel
        winGrid.add(winnerLabel);
        winGrid.add(countLabel);
        winGrid.add(btnReturnFlow);

        winPanel.add(winGrid);
        
        // Add panel to main panel
        mainPanel.add(winPanel, "winPanel");
        mainLayout.show(mainPanel, "winPanel");
    }

    public void setActionListeners(ActionListener l) {
        // Add action listeners to start and name panel buttons
        btnPlay.addActionListener(l);
        btnQuit.addActionListener(l);
        btnName.addActionListener(l);

        // Add action listeners to armor panel buttons
        btnLight.addActionListener(l);
        btnMedium.addActionListener(l);
        btnHeavy.addActionListener(l);
        btnNoArmor.addActionListener(l);

        // Add action listeners to weapon panel buttons
        btnDagger.addActionListener(l);
        btnSword.addActionListener(l);
        btnAxe.addActionListener(l);
        btnNoWeapon.addActionListener(l);

        // Add action listeners to opponent panel buttons
        btnThief.addActionListener(l);
        btnViking.addActionListener(l);
        btnMinotaur.addActionListener(l);

        // Add action listeners to environment panel buttons
        btnArena.addActionListener(l);
        btnSwamp.addActionListener(l);
        btnColosseum.addActionListener(l);
    }



    public CardLayout getMainLayout() {
        return this.mainLayout;
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
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

    public JButton getBtnThief() {
        return this.btnThief;
    }

    public JButton getBtnViking() {
        return this.btnViking;
    }

    public JButton getBtnMinotaur() {
        return this.btnMinotaur;
    }

    public JButton getBtnArena() {
        return this.btnArena;
    }
    
    public JButton getBtnSwamp() {
        return this.btnSwamp;
    }
    
    public JButton getBtnColosseum() {
        return this.btnColosseum;
    }
    
    public JTextField getNameField() {
        return this.nameField;
    }
    
}
