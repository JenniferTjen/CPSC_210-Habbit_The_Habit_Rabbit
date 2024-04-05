package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    InitialPanel initialPanel;
    EventLog events;

    // the main frame in which the initial panel until menu panel is displayed in
    public MainWindow() {
        this.setTitle("Habit Rabbit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 500);
        this.setVisible(true);
        events = EventLog.getInstance();
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

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            // Execute your function here
            for (Event event : events) {
                System.out.println(event);
            }
            super.processWindowEvent(e);
        }
    }
}
