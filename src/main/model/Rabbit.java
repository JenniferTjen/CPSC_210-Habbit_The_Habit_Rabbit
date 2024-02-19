package model;

public class Rabbit {
    private String name;
    private Boolean dietGood;       // corresponds to user diet
    private Boolean fit;            // corresponds to user lifestyle level
    private Boolean entertained;    // corresponds to user hobby progress
    private Boolean notLonely;      // corresponds to user social level
    private Boolean happy;
    private float maxHappiness;
    private float happiness;

    // EFFECTS : Initializes a rabbit with normal stats
    public Rabbit(String n) {
        this.name = n;
        this.dietGood = false;
        this.fit = false;
        this.entertained = false;
        this.notLonely = false;
        this.happiness = 0;
        this.maxHappiness = 0;
        this.happy = false;
    }

    public void setName(String x) {
        name = x;
    }

    // MODIFIES : this
    // EFFECTS : set fit status to true
    public void yesFit() {
        fit = true;
    }

    // MODIFIES : this
    // EFFECTS : set fit status to false
    public void notFit() {
        fit = false;
    }

    // MODIFIES : this
    // EFFECTS : set diet status to true
    public void yesDiet() {
        dietGood = true;
    }

    // MODIFIES : this
    // EFFECTS : set diet status to false
    public void notDiet() {
        dietGood = false;
    }

    // MODIFIES : this
    // EFFECTS : set social status to true
    public void yesSocial() {
        notLonely = true;
    }

    // MODIFIES : this
    // EFFECTS : set social status to false
    public void notSocial() {
        notLonely = false;
    }

    // MODIFIES : this
    // EFFECTS : set entertained status to true
    public void yesEntertained() {
        entertained = true;
    }

    // MODIFIES : this
    // EFFECTS : set fit entertained to false
    public void notEntertained() {
        entertained = false;
    }

    // MODIFIES : this
    // EFFECTS : set happiness level
    public void setHappiness(float i) {
        happiness = i;
    }

    // MODIFIES : this
    // EFFECTS : set happiness max amount
    public void setMaxHappiness(float k) {
        maxHappiness = k;
    }

    // MODIFIES : this
    // EFFECTS : set happiness status
    public void setHappinessStatus(boolean s) {
        happy = s;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public Boolean getDietStatus() {
        return dietGood;
    }

    public Boolean getSocialStatus() {
        return notLonely;
    }

    public Boolean getFitStatus() {
        return fit;
    }

    public Boolean getEntertainedStatus() {
        return entertained;
    }

    public float getHappiness() {
        return happiness;
    }

    public float getMaxHappiness() {
        return maxHappiness;
    }

    public boolean getHappyStatus() {
        return happy;
    }
}
