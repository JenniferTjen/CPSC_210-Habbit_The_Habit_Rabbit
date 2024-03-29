package ui;

import model.Habit;
import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class AddHabitPage extends JFrame {
    Tracker tracker;
    JPanel infoPanel;
    JLabel title;
    JTextField titleField;
    JLabel desc;
    JTextField descField;
    JLabel perDay;
    JTextField perDayField;
    JLabel category;
    JList<String> categories;
    JButton submitButton;
    String[] options;
    JLabel header;

    // a frame which contains all the fields required for the users to enter
    // in order to construct a new habit
    public AddHabitPage(Tracker tracker) {
        this.tracker = tracker;
        this.setTitle("Habit Rabbit - Add Habit");
        this.setBackground(new Color(0xf5cac2));
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        options = new String[]{"Lifestyle", "Social", "Diet", "Hobby"};

        constructInfoPanel();
    }

    // MODIFIES: this
    // EFFECTS: adds another panel inside this frame
    public void constructInfoPanel() {
        this.infoPanel = new JPanel();
        infoPanel.setBackground(new Color(0xf5cac2));
        infoPanel.setBounds(47, 145, 390, 260); // Adjust the bounds to fit the frame
        infoPanel.setVisible(true);
        this.add(infoPanel);
        infoPanel.setLayout(null);
        infoPanel.setVisible(true);

        addInfo();
    }

    // EFFECTS: adds habit fields for users to fill in
    public void addInfo() {
        addHeader();
        addTitle();
        addDesc();
        addPerDay();
        addCategory();
        addSubmitButton();
    }

    // EFFECTS: adds a welcoming message to the top part of the frame
    public void addHeader() {
        header = new JLabel("Let's construct a Habit!");
        header.setBounds(180, 70, 175, 30);
        header.setVisible(true);
        this.add(header);
    }

    // EFFECTS: inserts the title field to the panel
    public void addTitle() {
        title = new JLabel("Title:");
        title.setBounds(20, 20, 100, 30);
        title.setVisible(true);
        infoPanel.add(title);

        titleField = new JTextField();
        titleField.setBounds(115, 25, 250, 20);
        titleField.setVisible(true);
        infoPanel.add(titleField);
    }

    // EFFECTS: inserts the description field to the panel
    public void addDesc() {
        desc = new JLabel("Desc:");
        desc.setBounds(20, 50, 100, 30);
        desc.setVisible(true);
        infoPanel.add(desc);

        descField = new JTextField();
        descField.setBounds(115, 55, 250, 20);
        descField.setVisible(true);
        infoPanel.add(descField);
    }

    // EFFECTS: inserts the daily goal field to the panel
    public void addPerDay() {
        perDay = new JLabel("Goal (per day):");
        perDay.setBounds(20, 80, 100, 30);
        perDay.setVisible(true);
        infoPanel.add(perDay);

        perDayField = new JTextField();
        perDayField.setBounds(115, 85, 250, 20);
        perDayField.setVisible(true);
        infoPanel.add(perDayField);
    }

    // EFFECTS: inserts the category field to the panel
    public void addCategory() {
        category = new JLabel("Category:");
        category.setBounds(20, 110, 100, 30);
        category.setVisible(true);
        infoPanel.add(category);

        categories = new JList<>(options);
        categories.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categories.setBounds(115, 120, 120, 74);
        categories.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(categories);
        infoPanel.add(categories);
    }

    // EFFECTS: inserts the submit button to the panel
    public void addSubmitButton() {
        submitButton = new JButton("Create!");
        submitButton.setBounds(140, 210, 100, 30);
        submitButton.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String desc = descField.getText();
                int perDay = parseInt(perDayField.getText());
                int selectedIndex = categories.getSelectedIndex();
                String category = options[selectedIndex];

                tracker.addHabit(new Habit(title, desc, perDay, category));
                closeWindow();
            }
        });
        infoPanel.add(submitButton);
    }

    // EFFECTS: close the frame when hitting the submit button
    public void closeWindow() {
        this.dispose();
    }
}
