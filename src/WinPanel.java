import javax.swing.*;
import java.awt.*;

public class WinPanel {

    private JPanel winPanel;
    
    public WinPanel() {
        this.winPanel = new JPanel();
    }

    public void displayWinPanel(GUI gui, String winner, int moveCounter) {
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
        btnReturnFlow.add(gui.getGamePanel().getBtnReturn());

        // Add labels and button to panel
        winGrid.add(winnerLabel);
        winGrid.add(countLabel);
        winGrid.add(btnReturnFlow);

        winPanel.add(winGrid);
        
        // Add panel to main panel
        gui.getMainPanel().add(winPanel, "winPanel");
        gui.getMainLayout().show(gui.getMainPanel(), "winPanel");
    }
    
}
