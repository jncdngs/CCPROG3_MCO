import javax.swing.*;
import java.awt.*;

public class StartPanel {

    private JPanel startPanel;
    private JPanel menuBtnPanel;

    private JLabel startBackground;

    private JButton btnPlay;
    private JButton btnQuit;

    private ImageIcon startImg;

    public StartPanel() {
        this.startPanel = new JPanel();
        startImg = new ImageIcon("Background.png");
    }

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



    public JPanel getStartPanel() {
        return this.startPanel;
    }
    
    public JButton getBtnPlay() {
        return this.btnPlay;
    }

    public JButton getBtnQuit() {
        return this.btnQuit;
    }

}
