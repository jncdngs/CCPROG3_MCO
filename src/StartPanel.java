import javax.swing.*;
import java.awt.*;

/**
 * Start menu panel class.
 * <p>
 * Initializes and manages the Start menu panel and elements.
 * 
 * @author Jon Chester Donguines
 */
public class StartPanel {

    private JPanel startPanel;
    private JPanel menuBtnPanel;

    private JLabel startBackground;

    private JButton btnPlay;
    private JButton btnQuit;

    private ImageIcon startImg;

    /**
     * Constructs a StartPanel instance.
     * <p>
     * Initializes a new JPanel for the start menu screen and sets the menu 
     * background image.
     */
    public StartPanel() {
        this.startPanel = new JPanel();
        startImg = new ImageIcon("Background.png");
    }

    /**
     * Sets the layout of the StartPanel and adds all necessary elements in 
     * corresponding subpanels.
     */
    public void addStartPanel() {
        startPanel.setLayout(new BorderLayout());
        
        // CENTER PANEL
        // Set background image
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



    /**
     * Returns the start menu panel.
     * 
     * @return the start panel
     */
    public JPanel getStartPanel() {
        return this.startPanel;
    }
    
    /**
     * Returns the Play button.
     * 
     * @return the Play button
     */
    public JButton getBtnPlay() {
        return this.btnPlay;
    }

    /**
     * Returns the Quit button.
     * 
     * @return the Quit button
     */
    public JButton getBtnQuit() {
        return this.btnQuit;
    }

}
