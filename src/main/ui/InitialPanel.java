package ui;

import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class InitialPanel extends JPanel {
    Tracker tracker;
    JButton submitButton;
    JTextField nameField;
    JLabel label;
    JLabel textLabel;
    JLabel textLabel2;
    JLabel textLabel3;
    Menu menuPanel;
    MainWindow mainWindow;

    // the panel which contains an introduction message and
    // a text field in which the user can enter their name
    public InitialPanel(MainWindow mainWindow) {
        this.setBackground(new Color(0xf7ede3));
        this.mainWindow = mainWindow;
        nameField = new JTextField();
        submitButton = new JButton("submit");
        label = new JLabel();
        textLabel = new JLabel();
        addRabbitImage();
        addNameField();
        addText();
        this.setLayout(null);

        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds text components to the frame
    public void addText() {
        textLabel = new JLabel("Hi, I am");
        textLabel2 = new JLabel("HABBIT THE RABBIT!");
        textLabel3 = new JLabel("I will help you achieve the best you!");
        textLabel.setBounds(230, 2, 100, 100);
        textLabel2.setBounds(197, 25, 200, 100);
        textLabel3.setBounds(160, 50, 200, 100);
        this.add(textLabel);
        this.add(textLabel2);
        this.add(textLabel3);
    }


    // EFFECTS: adds a rabbit image to the frame
    public void addRabbitImage() {
        ImageIcon image = new ImageIcon(getClass().getResource("pictures/happyRabbit.png"));
        Image originalImage = image.getImage();
        Image scaledImage = getScaledImage(originalImage, 175, 175);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        this.add(label);
        label.setBounds(160, 150, 175, 175);
    }

    // EFFECTS: adds name field in which the users can enter their name in to the frame
    public void addNameField() {
        JTextField nameField = new JTextField(10);  // Specify preferred width for the text field
        nameField.setBounds(180, 310, 135, 30);
        this.add(nameField);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = nameField.getText();
                tracker = new Tracker(userInput);
                menuPanel = new Menu(tracker, mainWindow);

                removeAllComponents();
                add(menuPanel);
                revalidate();
                repaint();

            }
        });
        this.add(submitButton);
        submitButton.setBounds(198, 350, 100, 30);
    }

    // EFFECTS: prevents the image to be cropped due to resizing and the setBounds() function
    public static Image getScaledImage(Image image, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return scaledImage;
    }

    // EFFECTS: removes all the components inside the parent container
    private void removeAllComponents() {
        removeAll(); // Remove all components from the panel
    }
}
