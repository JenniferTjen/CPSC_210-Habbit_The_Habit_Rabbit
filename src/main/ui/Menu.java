package ui;

import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    private Tracker tracker;
    private MainWindow mainWindow;
    private JLabel textLabel;
    private JLabel textLabel2;
    private JLabel textLabel3;

    // constructs a panel which contains the MenuPanel and message
    public Menu(Tracker tracker, MainWindow mainWindow) {
        this.setBackground(new Color(0xf7ede3));
        this.setBounds(0, 0, 500, 500);
        this.tracker = tracker;
        this.mainWindow = mainWindow;
        this.setLayout(null);

        this.add(new MenuPanel(tracker, this));
        addIntro();
    }

    // EFFECTS: adds intro message to the panel
    public void addIntro() {
        textLabel = new JLabel("Hi, " + tracker.getRabbitName().toUpperCase());
        textLabel2 = new JLabel("What do you want to do today?");
        textLabel.setBounds(230, 2, 200, 100);
        textLabel2.setBounds(160, 25, 200, 100);
        this.add(textLabel);
        this.add(textLabel2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
