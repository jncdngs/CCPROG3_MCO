import javax.swing.*;
import java.awt.*;

public class EnvPanel {

    public JPanel envPanel;

    private JButton btnArena;
    private JButton btnSwamp;
    private JButton btnColosseum;

    public EnvPanel() {
        this.envPanel = new JPanel();
    }

    public void addEnvPanel() {
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



    public JPanel getEnvPanel() {
        return this.envPanel;
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
    
}
