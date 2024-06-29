package Images;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class AnimalSelectionPanel extends JPanel implements ActionListener {

    // Strings representing animal names
    private static final String[] animalStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

    // Components
    private ButtonGroup group;
    private JLabel picture;

    public AnimalSelectionPanel() {
        // Initialize components
        picture = new JLabel();
        add(picture);

        group = new ButtonGroup();

        // Create and add radio buttons
        for (String animal : animalStrings) {
            JRadioButton button = new JRadioButton(animal);
            button.setMnemonic(KeyEvent.VK_UNDEFINED); // Use the first letter as the mnemonic
            button.setActionCommand(animal);
            button.addActionListener(this);
            group.add(button);
            add(button);
        }

        // Select the 'Pig' radio button by default
        JRadioButton pigButton = (JRadioButton) getComponent(4);  // 4 is the index of 'Pig' in components array
        pigButton.setSelected(true);

        // Load initial image (Pig)
        updateImage("C:\\Users\\Administrator\\Downloads\\Pig.jpeg");  // Use absolute file path for Pig
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedAnimal = e.getActionCommand();

        // Update the image with the same path for each animal
        updateImage("C:\\Users\\Administrator\\Downloads\\Pig.jpeg");

        // Optionally, show a message dialog indicating the selected animal
        JOptionPane.showMessageDialog(this, "You selected: " + selectedAnimal, "Animal Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        picture.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Animal Selection");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AnimalSelectionPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
