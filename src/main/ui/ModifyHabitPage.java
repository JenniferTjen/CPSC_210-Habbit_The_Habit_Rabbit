package ui;

import model.Habit;
import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyHabitPage extends JFrame {
    Tracker tracker;
    ArrayList<Habit> habits;
    JLabel message;

    // a frame which displays all habits that has been made by the user
    public ModifyHabitPage(Tracker tracker) {
        this.tracker = tracker;
        this.setTitle("Habit Rabbit - Add Habit");
        this.setBackground(new Color(0xf5cac2));
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        habits = tracker.getHabits();

        constructHabits();
    }

    // EFFECTS: prints a suggesting message and iterates through the habit list
    // in the tracker and calls for another method to construct buttons
    public void constructHabits() {
        message = new JLabel("Choose a Habit to modify!");
        for (Habit h : habits) {
            this.add(constructButton(h.getTitle()));
        }
    }

    // EFFECTS: constructs button for each habit
    public JButton constructButton(String title) {
        JButton button = new JButton(title);
        button.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Habit h : habits) {
                    if (h.getTitle() == title) {
                        new HabitInspectorPage(tracker, h);
                    }
                }
            }
        });
        button.setSize(30, 15);

        return button;
    }
}
