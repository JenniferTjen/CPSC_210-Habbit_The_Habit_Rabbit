package ui;

import model.Habit;
import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class HabitInspectorPage extends JFrame {
    Tracker tracker;
    Habit habit;
    JPanel infoPanel;
    JLabel title;
    JLabel desc;
    JLabel perDay;
    JLabel category;
    JProgressBar progressBar;
    JButton addProgressButton;

    // a frame which displays the habit's specifications
    public HabitInspectorPage(Tracker tracker, Habit h) {
        this.setBackground(new Color(0xf5cac2));
        this.tracker = tracker;
        this.setTitle("Habit Rabbit - View Habit");
        this.setSize(250, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.habit = h;

        printStats();
    }

    // EFFECTS: initializes all the habit information
    public void printStats() {
        constructInfoPanel();
        addTitle();
        addProgress();
        addDesc();
        addCategory();

        addProgressButton();
    }

    // MODIFIES: this
    // EFFECTS: constructs the panel in which the habit information is displayed
    public void constructInfoPanel() {
        this.infoPanel = new JPanel();
        infoPanel.setBackground(new Color(0xf5cac2));
        infoPanel.setBounds(20, 30, 195, 260); // Adjust the bounds to fit the frame
        infoPanel.setVisible(true);
        this.add(infoPanel);
        infoPanel.setLayout(null);
        infoPanel.setVisible(true);
    }

    // EFFECTS: adds the habit title to the panel
    public void addTitle() {
        title = new JLabel("Title: " + habit.getTitle().toUpperCase());
        title.setBounds(10, 20, 150, 30);
        title.setVisible(true);
        infoPanel.add(title);
    }

    // EFFECTS: adds the habit description to the panel
    public void addDesc() {
        desc = new JLabel("Desc: " + habit.getDesc());
        desc.setBounds(10, 50, 150, 30);
        desc.setVisible(true);
        infoPanel.add(desc);
    }

    // EFFECTS: adds the habit progress to the panel, including a progress bar
    public void addProgress() {
        perDay = new JLabel(
                "Progress: " + habit.getProgress() + " / " + habit.getPerDay()
        );
        perDay.setBounds(10, 110, 150, 30);
        perDay.setVisible(true);
        infoPanel.add(perDay);
        addProgressBar();
    }

    // EFFECTS: adds the habit category to the panel
    public void addCategory() {
        category = new JLabel("Category: " + habit.getCategory());
        category.setBounds(10, 80, 150, 30);
        category.setVisible(true);
        infoPanel.add(category);
    }

    // EFFECTS: adds the habit progress bar to the panel
    public void addProgressBar() {
        this.progressBar = new JProgressBar();
        if (habit.getPerDay() == 0) {
            progressBar.setValue(0);
        } else {
            progressBar.setValue(
                    (int) ((double) habit.getProgress() / habit.getPerDay() * 100)
            );
        }
        progressBar.setBounds(10, 145, 180, 15);
        progressBar.setVisible(true);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0x84a59e));
        progressBar.setBackground(new Color(0xf7ede3));
        infoPanel.add(progressBar);
    }

    // EFFECTS: adds the add progress button to the panel
    public void addProgressButton() {
        addProgressButton = new JButton("Add Progress!");
        addProgressButton.setBounds(10, 170, 130, 30);
        addProgressButton.setVisible(true);
        addProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tracker.progressHabit(tracker.getHabits().indexOf(habit));
                updateProgressBar();
            }
        });
        infoPanel.add(addProgressButton);
    }

    // EFFECTS: updates the progress and progress bar every time the
    //          add progress button is pressed
    public void updateProgressBar() {
        perDay.setText("Progress: " + habit.getProgress() + " / " + habit.getPerDay());
        if (habit.getPerDay() == 0) {
            progressBar.setValue(0);
        } else {
            progressBar.setValue((int) ((double) habit.getProgress() / habit.getPerDay() * 100));
        }
    }
}
