package persistence;

import model.Habit;
import model.Tracker;
import model.Rabbit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkHabit(String title, String desc, int perDay, String category, Habit habit) {
        assertEquals(title, habit.getTitle());
        assertEquals(desc, habit.getDesc());
        assertEquals(perDay, habit.getPerDay());
        assertEquals(category, habit.getCategory());
    }

    protected void checkTracker(String name, boolean diets, boolean fits, boolean entertaineds,
                                boolean notLonelys, boolean happy, float maxhappy, float happiness,
                                Tracker tracker) {
        assertEquals(name, tracker.getRabbitName());
        assertEquals(diets, tracker.getRabbitDiet());
        assertEquals(fits, tracker.getRabbitFit());
        assertEquals(entertaineds, tracker.getRabbitEntertained());
        assertEquals(notLonelys, tracker.getRabbitSocial());
        assertEquals(happy, tracker.getRabbitHappinessStatus());
        assertEquals(maxhappy, tracker.getRabbitMaxHappiness());
        assertEquals(happiness, tracker.getRabbitHappiness());
    }
}
