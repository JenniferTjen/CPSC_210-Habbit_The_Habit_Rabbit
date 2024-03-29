package ui;

import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ViewRabbitPage extends JFrame {
    private Menu menu;
    private Tracker tracker;
    private JPanel statPanel;
    private JLabel label;
    private JLabel rabbitHappiness;
    private JLabel rabbitName;
    private JProgressBar rabbitHappinessProgress;
    private JLabel happiness;
    private JLabel diet;
    private JProgressBar rabbitDietProgress;
    private JLabel fitness;
    private JProgressBar rabbitLifestyleProgress;
    private JLabel hobby;
    private JProgressBar rabbitHobbyProgress;
    private JLabel social;
    private JProgressBar rabbitSocialProgress;

    // constructs a frame which displays the rabbit's status
    public ViewRabbitPage(Tracker tracker, Menu menu) {
        this.setTitle("Habit Rabbit - View Rabbit");
        this.setBackground(new Color(0xf5cac2));
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.statPanel = new JPanel();
        this.label = new JLabel();
        this.tracker = tracker;
        this.menu = menu;

        this.tracker.rabbitSetHappiness();
        this.tracker.rabbitSetMaxHappiness();
        this.tracker.rabbitSetHappinessStatus();
        constructRabbit();
        constructStats();
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit according to its status
    public void constructRabbit() {
        String imageIcon;
        if (tracker.getRabbitMaxHappiness() == 0) {
            imageIcon = "pictures/sadRabbit.png";
        } else if (tracker.getRabbitHappinessStatus()) {
            imageIcon = "pictures/happyRabbit.png";
        } else {
            imageIcon = "pictures/sadRabbit.png";
        }

        ImageIcon image = new ImageIcon(getClass().getResource(imageIcon));
        Image originalImage = image.getImage();
        Image scaledImage = getScaledImage(originalImage, 175, 175);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        this.label = new JLabel(scaledIcon);
        label.setBounds(160, 0, 175, 190);
        this.add(label); // Add the label to the panel
        label.setVisible(true);
    }

    // EFFECTS: prevents the image from cropping
    public static Image getScaledImage(Image image, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return scaledImage;
    }

    // EFFECTS: constructs rabbit statuses' panel
    public void constructStats() {
        statPanel.setBackground(new Color(0xf5cac2));
        statPanel.setBounds(48, 160, 390, 250); // Adjust the bounds to fit the frame
        statPanel.setVisible(true);
        this.add(statPanel); // Add the statPanel to the panel
        statPanel.setLayout(null);
        statPanel.setVisible(true);

        addStat();
    }

    // EFFECTS: constructs rabbit statuses' within the panel
    public void addStat() {
        printRabbitName();
        isRabbitHappy();
        printRabbitHappiness();
        printRabbitDiet();
        printRabbitLifestyle();
        printRabbitHobby();
        printRabbitSocial();
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit name
    public void printRabbitName() {
        rabbitName = new JLabel("- " + tracker.getRabbitName().toUpperCase() + " -");
        rabbitName.setBounds(170, 24, 100, 30);
        rabbitName.setVisible(true);
        statPanel.add(rabbitName);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit image
    public void isRabbitHappy() {
        this.rabbitHappiness = new JLabel();
        String happiness = null;
        if (tracker.getRabbitHappinessStatus()) {
            happiness = "HAPPY";
        } else {
            happiness = "SAD";
        }

        rabbitHappiness = new JLabel("Status:  " + happiness);
        rabbitHappiness.setBounds(15, 50, 100, 30);
        rabbitHappiness.setVisible(true);
        statPanel.add(rabbitHappiness);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit happiness status
    private void printRabbitHappiness() {
        happiness = new JLabel("Happiness:");
        happiness.setBounds(15, 80, 100, 30);
        happiness.setVisible(true);
        statPanel.add(happiness);

        this.rabbitHappinessProgress = new JProgressBar();
        if (tracker.getRabbitMaxHappiness() == 0) {
            rabbitHappinessProgress.setValue(0);
        } else {
            rabbitHappinessProgress.setValue(
                    (int) ((double) tracker.getRabbitHappiness() / tracker.getRabbitMaxHappiness() * 100)
            );
        }
        rabbitHappinessProgress.setBounds(120, 90, 255, 15);
        rabbitHappinessProgress.setVisible(true);
        rabbitHappinessProgress.setStringPainted(true);
        rabbitHappinessProgress.setForeground(new Color(0x84a59e));
        rabbitHappinessProgress.setBackground(new Color(0xf7ede3));
        statPanel.add(rabbitHappinessProgress);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit diet status
    private void printRabbitDiet() {
        diet = new JLabel("Diet:");
        diet.setBounds(15, 106, 100, 30);
        diet.setVisible(true);
        statPanel.add(diet);


        this.rabbitDietProgress = new JProgressBar();
        if (tracker.getDietGoal() == 0) {
            rabbitDietProgress.setValue(0);
        } else {
            rabbitDietProgress.setValue(
                    (int) ((double) tracker.getDietCompleted() / tracker.getDietGoal() * 100)
            );
        }
        rabbitDietProgress.setBounds(120, 115, 255, 15);
        rabbitDietProgress.setVisible(true);
        rabbitDietProgress.setStringPainted(true);
        rabbitDietProgress.setForeground(new Color(0x84a59e));
        rabbitDietProgress.setBackground(new Color(0xf7ede3));
        statPanel.add(rabbitDietProgress);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit lifestyle status
    private void printRabbitLifestyle() {
        fitness = new JLabel("Lifestyle:");
        fitness.setBounds(15, 132, 100, 30);
        fitness.setVisible(true);
        statPanel.add(fitness);


        this.rabbitLifestyleProgress = new JProgressBar();
        if (tracker.getLifestyleGoal() == 0) {
            rabbitLifestyleProgress.setValue(0);
        } else {
            rabbitLifestyleProgress.setValue(
                    (int) ((double) tracker.getLifestyleCompleted() / tracker.getLifestyleGoal() * 100)
            );
        }
        rabbitLifestyleProgress.setBounds(120, 140, 255, 15);
        rabbitLifestyleProgress.setVisible(true);
        rabbitLifestyleProgress.setStringPainted(true);
        rabbitLifestyleProgress.setForeground(new Color(0x84a59e));
        rabbitLifestyleProgress.setBackground(new Color(0xf7ede3));
        statPanel.add(rabbitLifestyleProgress);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit hobby status
    private void printRabbitHobby() {
        hobby = new JLabel("Hobby:");
        hobby.setBounds(15, 158, 100, 30);
        hobby.setVisible(true);
        statPanel.add(hobby);


        this.rabbitHobbyProgress = new JProgressBar();
        if (tracker.getHobbyGoal() == 0) {
            rabbitHobbyProgress.setValue(0);
        } else {
            rabbitHobbyProgress.setValue(
                    (int) ((double) tracker.getHobbyCompleted() / tracker.getHobbyGoal() * 100)
            );
        }
        rabbitHobbyProgress.setBounds(120, 165, 255, 15);
        rabbitHobbyProgress.setVisible(true);
        rabbitHobbyProgress.setStringPainted(true);
        rabbitHobbyProgress.setForeground(new Color(0x84a59e));
        rabbitHobbyProgress.setBackground(new Color(0xf7ede3));
        statPanel.add(rabbitHobbyProgress);
    }

    // MODIFIES: this
    // EFFECTS: constructs rabbit social status
    private void printRabbitSocial() {
        social = new JLabel("Social:");
        social.setBounds(15, 184, 100, 30);
        social.setVisible(true);
        statPanel.add(social);


        this.rabbitSocialProgress = new JProgressBar();
        if (tracker.getSocialGoal() == 0) {
            rabbitSocialProgress.setValue(0);
        } else {
            rabbitSocialProgress.setValue(
                    (int) ((double) tracker.getSocialCompleted() / tracker.getSocialGoal() * 100)
            );
        }
        rabbitSocialProgress.setBounds(120, 190, 255, 15);
        rabbitSocialProgress.setVisible(true);
        rabbitSocialProgress.setStringPainted(true);
        rabbitSocialProgress.setForeground(new Color(0x84a59e));
        rabbitSocialProgress.setBackground(new Color(0xf7ede3));
        statPanel.add(rabbitSocialProgress);
    }
}
