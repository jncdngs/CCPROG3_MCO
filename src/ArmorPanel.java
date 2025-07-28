import javax.swing.*;
import java.awt.*;

/**
 * Armor selection panel class.
 * <p>
 * Initializes and manages the armor selection panel and elements.
 * 
 * @author Jon Chester Donguines
 */
public class ArmorPanel {

    private JPanel armorPanel;

    private JButton btnLight;
    private JButton btnMedium;
    private JButton btnHeavy;
    private JButton btnNoArmor;

    /**
     * Constructs an ArmorPanel instance.
     * <p>
     * Initializes a new JPanel for the armor selection screen.
     */
    public ArmorPanel() {
        this.armorPanel = new JPanel();
    }

    /**
     * Sets the layout of the ArmorPanel and adds all necessary elements in 
     * corresponding subpanels.
     */
    public void addArmorPanel() {
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



    /**
     * Returns the armor selection panel.
     * 
     * @return the armor panel
     */
    public JPanel getArmorPanel() {
        return this.armorPanel;
    }
    
    /**
     * Returns the Light Armor button.
     * 
     * @return the Light button
     */
    public JButton getBtnLight() {
        return this.btnLight;
    }

    /**
     * Returns the Medium Armor button.
     * 
     * @return the Medium button
     */
    public JButton getBtnMedium() {
        return this.btnMedium;
    }

    /**
     * Returns the Heavy Armor button.
     * 
     * @return the Heavy button
     */
    public JButton getBtnHeavy() {
        return this.btnHeavy;
    }

    /**
     * Returns the No Armor button.
     * 
     * @return the No Armor button
     */
    public JButton getBtnNoArmor() {
        return this.btnNoArmor;
    }

}
