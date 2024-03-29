package ui;

import model.Tracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuPanel extends JPanel {
    private static final String JSON_STORE = "./data/habbit.json";
    Tracker tracker;
    private Menu menu;
    private JButton viewRabbit;
    private JButton addHabit;
    private JButton modifyHabit;
    private JButton saveTracker;
    private JButton loadTracker;
    private MainWindow mainWindow;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // initializes a menu panel which contains the option to navigate through the app
    public MenuPanel(Tracker tracker, Menu menu) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.setBackground(new Color(0xf5cac2));
        this.setBounds(180, 185, 130, 200);
        this.tracker = tracker;
        this.menu = menu;
        this.setBorder(BorderFactory.createLineBorder(new Color(0xf28582), 3));

        initButtons();

        this.add(viewRabbit);
        this.add(addHabit);
        this.add(modifyHabit);
        this.add(saveTracker);
        this.add(loadTracker);
    }

    // EFFECTS: constructs all the buttons necessary
    public void initButtons() {
        viewRabbitButton();
        addHabitButton();
        modifyHabitButton();
        saveTrackerButton();
        loadTrackerButton();
    }

    // EFFECTS: constructs the button which leads the user to view the rabbit
    public void viewRabbitButton() {
        viewRabbit = new JButton();
        viewRabbit.setText("View Rabbit");
        viewRabbit.setVisible(true);
        viewRabbit.setBounds(33,20,60,24);
        viewRabbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewRabbitPage(tracker, menu);
            }
        });
    }

    // EFFECTS: constructs the button which leads the user to add habits
    public void addHabitButton() {
        addHabit = new JButton();
        addHabit.setText("Add Habit");
        addHabit.setVisible(true);
        addHabit.setBounds(33,60,135,24);
        addHabit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddHabitPage(tracker);
            }
        });
    }

    // EFFECTS: constructs the button which leads the user to modify the habits
    public void modifyHabitButton() {
        modifyHabit = new JButton();
        modifyHabit.setText("Modify Habit");
        modifyHabit.setVisible(true);
        modifyHabit.setBounds(33,100,135,24);
        modifyHabit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyHabitPage(tracker);
            }
        });
    }

    // EFFECTS: constructs the button which leads the user to save their progression
    public void saveTrackerButton() {
        saveTracker = new JButton();
        saveTracker.setText("Save");
        saveTracker.setVisible(true);
        saveTracker.setBounds(33,140,135,24);
        saveTracker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        jsonWriter.open();
                        jsonWriter.write(tracker);
                        jsonWriter.close();
                        System.out.println("Saved " + tracker.getRabbitName() + " to " + JSON_STORE);
                    } catch (FileNotFoundException a) {
                        System.out.println("Unable to write to file: " + JSON_STORE);
                    }
            }
        });
    }

    // EFFECTS: constructs the button which leads the load their progression from memory
    public void loadTrackerButton() {
        loadTracker = new JButton();
        loadTracker.setText("Load");
        loadTracker.setVisible(true);
        loadTracker.setBounds(33,180,135,24);
        loadTracker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tracker = jsonReader.read();
                    System.out.println("Loaded " + tracker.getRabbitName() + " from " + JSON_STORE);
                } catch (IOException a) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }
}
