package ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    InitialPanel initialPanel;

    // the main frame in which the initial panel until menu panel is displayed in
    public MainWindow() {
        this.setTitle("Habit Rabbit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 500);
        this.setVisible(true);
        initial();

        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds an initialPanel to the frame
    public void initial() {
        initialPanel = new InitialPanel(this);
        this.add(initialPanel);
    }
}
