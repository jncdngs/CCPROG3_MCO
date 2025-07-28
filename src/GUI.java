import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main GUI class.
 * <p>
 * Initializes and manages the different panels used in the program using a 
 * main container panel that uses CardLayout.
 * 
 * @author Jon Chester Donguines
 */
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
    
    private ImageIcon icon;
    
    /**
     * Constructs a GUI instance.
     * <p>
     * Sets the window's name, icon, and dimensions. Sets other properties such as
     * resizability, position, and close operation. Calls addSetupPanel() which
     * sets up the panels to be displayed throughout the program.
     */
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

    /**
     * Initializes and adds all panels to the main container panel using CardLayout.
     * <p>
     * This method instantiates each of the custom panel classes (e.g. StartPanel, 
     * GamePanel), builds them by calling their respective add methods, and adds 
     * their components to the main panel using string identifiers.
     */
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

    /**
     * Attaches a shared ActionListener to all JButtons in all panels.
     * <p>
     * This method is used by the Controller to centralize event handling.
     * Each button from each panel is added with the ActionListener.
     *
     * @param l the ActionListener that handles button actions
     */
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



    /**
     * Returns the layout of the main panel.
     * 
     * @return the layout of the main panel
     */
    public CardLayout getMainLayout() {
        return this.mainLayout;
    }
    
    /**
     * Returns the main container panel.
     * 
     * @return the main container panel
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    /**
     * Returns the start menu panel.
     * 
     * @return the start menu panel
     */
    public StartPanel getStartPanel() {
        return this.startPanel;
    }

    /**
     * Returns the name creation panel.
     * 
     * @return the name creation panel
     */
    public NamePanel getNamePanel() {
        return this.namePanel;
    }

    /**
     * Returns the armor selection panel.
     * 
     * @return the armor selection panel
     */
    public ArmorPanel getArmorPanel() {
        return this.armorPanel;
    }

    /**
     * Returns the weapon selection panel.
     * 
     * @return the weapon selection panel
     */
    public WeaponPanel getWeaponPanel() {
        return this.weaponPanel;
    }

    /**
     * Returns the opponent selection panel.
     * 
     * @return the opponent selection panel
     */
    public OppPanel getOppPanel() {
        return this.oppPanel;
    }

    /**
     * Returns the environment selection panel.
     * 
     * @return the environment selection panel
     */
    public EnvPanel getEnvPanel() {
        return this.envPanel;
    }

    /**
     * Returns the main game panel.
     * 
     * @return the main game panel
     */
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    /**
     * Returns the win panel.
     * 
     * @return the win panel
     */
    public WinPanel getWinPanel() {
        return this.winPanel;
    }
    
}
