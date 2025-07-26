import javax.swing.*;
import java.awt.*;

public class OppPanel {

    public JPanel oppPanel;

    private JButton btnThief;
    private JButton btnViking;
    private JButton btnMinotaur;

    public OppPanel() {
        this.oppPanel = new JPanel();
    }

    public void addOppPanel() {
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



    public JPanel getOppPanel() {
        return this.oppPanel;
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
    
}
