import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    
    private CardLayout mainLayout;
    
    private JPanel mainPanel;
    
    private StartPanel startPanel;
    private NamePanel namePanel;
    private ArmorPanel armorPanel;
    private WeaponPanel weaponPanel;
    private OppPanel oppPanel;
    private EnvPanel envPanel;
    private GamePanel gamePanel;
    private WinPanel winPanel;

    // private JPanel startPanel;
    // private JPanel namePanel;
    // private JPanel armorPanel;
    // private JPanel weaponPanel;
    // private JPanel oppPanel;
    // private JPanel envPanel;
    // private JPanel gamePanel;
    // private JPanel winPanel;
    
    private ImageIcon icon;
    
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
        startPanel = new StartPanel();
        gamePanel = new GamePanel();
        namePanel = new NamePanel();
        armorPanel = new ArmorPanel();
        weaponPanel = new WeaponPanel();
        oppPanel = new OppPanel();
        envPanel = new EnvPanel();
        winPanel = new WinPanel();

        // Main card container panel
        mainLayout = new CardLayout();
        mainPanel = new JPanel(mainLayout);

        // Start menu panel
        startPanel.addStartPanel();
        mainPanel.add(startPanel.getStartPanel(), "startPanel");
        System.out.println("[LOG] Added start panel to container");

        // Name input panel
        namePanel.addNamePanel();
        mainPanel.add(namePanel.getNamePanel(), "namePanel");
        System.out.println("[LOG] Added name panel to container");

        // Armor selection panel
        armorPanel.addArmorPanel();
        mainPanel.add(armorPanel.getArmorPanel(), "armorPanel");
        System.out.println("[LOG] Added armor panel to container");

        // Weapon selection panel
        weaponPanel.addWeaponPanel();
        mainPanel.add(weaponPanel.getWeaponPanel(), "weaponPanel");
        System.out.println("[LOG] Added weapon panel to container");

        // Opponent selection panel
        oppPanel.addOppPanel();
        mainPanel.add(oppPanel.getOppPanel(), "oppPanel");
        System.out.println("[LOG] Added opp panel to container");

        // Environment selection panel
        envPanel.addEnvPanel();
        mainPanel.add(envPanel.getEnvPanel(), "envPanel");
        System.out.println("[LOG] Added env panel to container");

        // Winner panel return button
        gamePanel.setBtnReturn(new JButton("Return to main menu"));
        
        gamePanel.getBtnReturn().setPreferredSize(new Dimension(300, 50));
        gamePanel.getBtnReturn().setFont(new Font("Arial", Font.BOLD, 20));

        // Add to frame
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void setActionListeners(ActionListener l) {
        // Add action listeners to start and name panel buttons
        startPanel.getBtnPlay().addActionListener(l);
        startPanel.getBtnQuit().addActionListener(l);
        namePanel.getBtnName().addActionListener(l);

        // Add action listeners to armor panel buttons
        armorPanel.getBtnLight().addActionListener(l);
        armorPanel.getBtnMedium().addActionListener(l);
        armorPanel.getBtnHeavy().addActionListener(l);
        armorPanel.getBtnNoArmor().addActionListener(l);

        // Add action listeners to weapon panel buttons
        weaponPanel.getBtnDagger().addActionListener(l);
        weaponPanel.getBtnSword().addActionListener(l);
        weaponPanel.getBtnAxe().addActionListener(l);
        weaponPanel.getBtnNoWeapon().addActionListener(l);

        // Add action listeners to opponent panel buttons
        oppPanel.getBtnThief().addActionListener(l);
        oppPanel.getBtnViking().addActionListener(l);
        oppPanel.getBtnMinotaur().addActionListener(l);

        // Add action listeners to environment panel buttons
        envPanel.getBtnArena().addActionListener(l);
        envPanel.getBtnSwamp().addActionListener(l);
        envPanel.getBtnColosseum().addActionListener(l);
    }



    public CardLayout getMainLayout() {
        return this.mainLayout;
    }
    
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public StartPanel getStartPanel() {
        return this.startPanel;
    }

    public NamePanel getNamePanel() {
        return this.namePanel;
    }

    public ArmorPanel getArmorPanel() {
        return this.armorPanel;
    }

    public WeaponPanel getWeaponPanel() {
        return this.weaponPanel;
    }

    public OppPanel getOppPanel() {
        return this.oppPanel;
    }

    public EnvPanel getEnvPanel() {
        return this.envPanel;
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public WinPanel getWinPanel() {
        return this.winPanel;
    }
    
}
