package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {

    private ArrayList<Habit> l1;
    private Tracker t1;
    private Habit h1;
    private Habit h2;
    private Habit h3;
    private Habit h4;
    private Habit h11;
    private Habit h22;
    private Habit h33;
    private Habit h44;


    @BeforeEach
    public void runBefore() {
        l1 = new ArrayList<>();
        t1 = new Tracker("Kirby");
        h1 = new Habit("Gym", "go to gym", 1, "Lifestyle");
        h2 = new Habit("Email", "reply to emails", 3, "Social");
        h3 = new Habit("Vegetable", "eat vegetables", 3, "Diet");
        h4 = new Habit("Read", "read book", 2, "Hobby");
        h11 = new Habit("Bike", "ride a bike", 2, "Lifestyle");
        h22 = new Habit("Slack", "reply to slack", 3, "Social");
        h33 = new Habit("Drink water", "drink water", 8, "Diet");
        h44 = new Habit("Crochet", "do crochet", 4, "Hobby");
    }

    @Test
    public void testAddHabit() {
        assertEquals(0, t1.numberOfHabits());
        assertEquals(l1, t1.getHabits());
        t1.addHabit(h1);
        l1.add(h1);
        assertEquals(l1, t1.getHabits());
        t1.addHabit(h2);
        l1.add(h2);
        assertEquals(l1, t1.getHabits());
    }

    @Test
    public void testModifyHabit() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.selectHabit(h1);
        assertEquals("Gym", h1.getTitle());
        assertEquals("go to gym", h1.getDesc());
        assertEquals(1, h1.getPerDay());
        assertEquals("Lifestyle", h1.getCategory());
        t1.changeTitle("Lala");
        t1.changeDescription("lolo");
        t1.changeCategory("Hobby");
        t1.changePerDay(5);
        assertEquals("Lala", h1.getTitle());
        assertEquals("lolo", h1.getDesc());
        assertEquals(5, h1.getPerDay());
        assertEquals("Hobby", h1.getCategory());
        assertEquals(0, h1.getProgress());
        h1.addProgress();
        assertEquals(1, h1.getProgress());
        h1.addProgress();
        assertEquals(2, h1.getProgress());
    }

    @Test
    public void testReturnProgress() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.addHabit(h22);
        t1.addHabit(h33);
        t1.addHabit(h44);
        assertEquals(7, t1.numberOfHabits());
        assertEquals(1, t1.getLifestyleGoal());
        assertEquals(6,t1.getSocialGoal());
        assertEquals(11,t1.getDietGoal());
        assertEquals(6,t1.getHobbyGoal());
        assertEquals(0, t1.getLifestyleCompleted());
        assertEquals(0, t1.getSocialCompleted());
        assertEquals(0, t1.getDietCompleted());
        assertEquals(0, t1.getHobbyCompleted());
        assertEquals(0, t1.completedHabits());
        h1.addProgress();
        assertEquals(1, h1.getProgress());
        h2.addProgress();
        h2.addProgress();
        h33.addProgress();
        h33.addProgress();
        h33.addProgress();
        h33.addProgress();
        h33.addProgress();
        assertEquals(1, t1.getLifestyleCompleted());
        assertEquals(2, t1.getSocialCompleted());
        assertEquals(5, t1.getDietCompleted());
        assertEquals(0, t1.getHobbyCompleted());
        assertEquals(1, t1.completedHabits());
        h2.addProgress();
        assertEquals(2, t1.completedHabits());
    }

    @Test
    public void testIsFit() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.addHabit(h11);
        t1.addHabit(h22);
        t1.addHabit(h33);
        t1.addHabit(h44);
        assertEquals(3, t1.getLifestyleGoal());
        assertEquals(0, t1.getLifestyleCompleted());
        t1.progressHabit(0);
        assertEquals(1, t1.getLifestyleCompleted());
        t1.isFit();
        assertFalse(t1.getRabbitFit());
        t1.progressHabit(0);
        t1.progressHabit(4);
        t1.progressHabit(4);
        t1.progressHabit(1);
        t1.progressHabit(0);
        t1.isFit();
        assertTrue(t1.getRabbitFit());
        assertEquals(5, t1.getLifestyleCompleted());
    }

    @Test
    public void testIsDiet() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.addHabit(h11);
        t1.addHabit(h22);
        t1.addHabit(h33);
        t1.addHabit(h44);
        assertEquals(11, t1.getDietGoal());
        assertEquals(0, t1.getDietCompleted());
        t1.progressHabit(2);
        assertEquals(1, t1.getDietCompleted());
        t1.isDietGood();
        assertFalse(t1.getRabbitDiet());
        t1.progressHabit(2);
        t1.progressHabit(2);
        t1.progressHabit(2);
        t1.progressHabit(6);
        t1.progressHabit(6);
        t1.progressHabit(6);
        t1.progressHabit(6);
        t1.progressHabit(2);
        t1.progressHabit(2);
        t1.progressHabit(3);
        t1.isDietGood();
        assertFalse(t1.getRabbitDiet());
        t1.progressHabit(2);
        t1.isDietGood();
        assertTrue(t1.getRabbitDiet());
        assertEquals(11, t1.getDietCompleted());
    }

    @Test
    public void testIsSocial() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.addHabit(h11);
        t1.addHabit(h22);
        t1.addHabit(h33);
        t1.addHabit(h44);
        assertEquals(6, t1.getSocialGoal());
        assertEquals(0, t1.getSocialCompleted());
        t1.progressHabit(1);
        assertEquals(1, t1.getSocialCompleted());
        t1.isSociable();
        assertFalse(t1.getRabbitDiet());
        t1.progressHabit(1);
        t1.progressHabit(1);
        t1.progressHabit(4);
        t1.progressHabit(2);
        t1.progressHabit(7);
        t1.progressHabit(5);
        t1.progressHabit(5);
        t1.progressHabit(5);
        t1.progressHabit(5);
        t1.progressHabit(5);
        t1.isSociable();
        assertTrue(t1.getRabbitSocial());
        assertEquals(8, t1.getSocialCompleted());
    }

    @Test
    public void testIsEntertained() {
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.addHabit(h11);
        t1.addHabit(h22);
        t1.addHabit(h33);
        t1.addHabit(h44);
        assertEquals(6, t1.getHobbyGoal());
        assertEquals(0, t1.getHobbyCompleted());
        t1.progressHabit(3);
        assertEquals(1, t1.getHobbyCompleted());
        t1.isEntertained();
        assertFalse(t1.getRabbitEntertained());
        t1.progressHabit(7);
        t1.progressHabit(7);
        t1.progressHabit(3);
        t1.progressHabit(5);
        t1.progressHabit(1);
        t1.progressHabit(7);
        t1.progressHabit(7);
        t1.progressHabit(5);
        t1.progressHabit(4);
        t1.progressHabit(4);
        t1.isEntertained();
        assertTrue(t1.getRabbitEntertained());
        assertEquals(6, t1.getHobbyCompleted());
    }

    @Test
    public void testRabbitHappiness() {
        assertEquals(0, t1.getRabbitHappiness());
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.rabbitSetHappiness();
        assertEquals(0, t1.getRabbitHappiness());
        t1.progressHabit(1);
        t1.rabbitSetHappiness();
        assertEquals(1, t1.getRabbitHappiness());
        t1.progressHabit(3);
        t1.rabbitSetHappiness();
        assertEquals(2, t1.getRabbitHappiness());
    }

    @Test
    public void testRabbitMaxHappiness() {
        assertEquals(0, t1.getRabbitMaxHappiness());
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.rabbitSetMaxHappiness();
        assertEquals(9, t1.getRabbitMaxHappiness());
        t1.addHabit(h11);
        t1.rabbitSetMaxHappiness();
        assertEquals(11, t1.getRabbitMaxHappiness());
    }

    @Test
    public void testRabbitHappinessStatus() {
        assertFalse(t1.getRabbitHappinessStatus());
        t1.addHabit(h1);
        t1.addHabit(h2);
        t1.addHabit(h3);
        t1.addHabit(h4);
        t1.rabbitSetHappinessStatus();
        assertFalse(t1.getRabbitHappinessStatus());
        t1.progressHabit(1);
        t1.progressHabit(2);
        t1.progressHabit(3);
        t1.progressHabit(0);
        t1.progressHabit(1);
        t1.progressHabit(1);
        t1.rabbitSetHappinessStatus();
        assertFalse(t1.getRabbitHappinessStatus());
        t1.progressHabit(2);
        t1.rabbitSetHappinessStatus();
        assertTrue(t1.getRabbitHappinessStatus());
        t1.progressHabit(3);
        t1.progressHabit(0);
        t1.rabbitSetHappinessStatus();
        assertTrue(t1.getRabbitHappinessStatus());
    }

    @Test
    public void testGetRabbitName() {
        assertEquals("Kirby", t1.getRabbitName());
        t1.modifyRabbitName("Lala");
        assertEquals("Lala", t1.getRabbitName());
    }
}