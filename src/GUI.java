import javax.swing.*;
import javax.swing.border.Border;

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

        // Weapon selection panel

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

        System.out.println("Start panel created");
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

        System.out.println("Name panel created");
    }

    private void addArmorPanel() {
        
    }

    private void addGamePanel() {
        gamePanel.setLayout(new BorderLayout());
        
        // North panel
        JPanel panelStats = new JPanel(new FlowLayout());
        panelStats.setOpaque(false);
        // panelStats.setBackground(Color.GRAY);

        JLabel header = new JLabel("North Panel");
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 30));
        panelStats.add(header);

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

        System.out.println("Game panel created");
    }

    public void setActionListeners(ActionListener l) {
        btnPlay.addActionListener(l);
        btnQuit.addActionListener(l);
        btnName.addActionListener(l);

        // btnLight.addActionListener(l);
        // btnMedium.addActionListener(l);
        // btnHeavy.addActionListener(l);
        // btnNoArmor.addActionListener(l);

        // btnDagger.addActionListener(l);
        // btnSword.addActionListener(l);
        // btnAxe.addActionListener(l);
        // btnNoWeapon.addActionListener(l);

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

    public void setBtnName(JButton btnName) {
        this.btnName = btnName;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

}
