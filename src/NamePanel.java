import javax.swing.*;
import java.awt.*;

public class NamePanel {

    private JPanel namePanel;

    private JLabel nameBackground;
    private JLabel namePrompt;
    
    private JButton btnName;

    private JTextField nameField;

    public NamePanel() {
        this.namePanel = new JPanel();
    }

    public void addNamePanel(GUI gui) {
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
        nameBackground = new JLabel(gui.getStartImg());
        nameBackground.setLayout(new BorderLayout());

        nameBackground.add(nameMenu, BorderLayout.SOUTH);

        namePanel.add(nameBackground, BorderLayout.CENTER);

        System.out.println("[LOG] Name panel created");
    }



    public JPanel getNamePanel() {
        return this.namePanel;
    }
    
    public JButton getBtnName() {
        return this.btnName;
    }

    public JTextField getNameField() {
        return this.nameField;
    }

}
