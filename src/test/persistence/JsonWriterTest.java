package persistence;

import model.Habit;
import model.Tracker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Tracker tr = new Tracker("Kirby");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTracker() {
        try {
            Tracker tr = new Tracker("Kirby");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTracker.json");
            writer.open();
            writer.write(tr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTracker.json");
            tr = reader.read();
            assertEquals("Kirby", tr.getRabbitName());
            assertEquals(0, tr.getHabits().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTracker() {
        try {
            Tracker tr = new Tracker("Kirby");
            tr.addHabit(new Habit("run", "run everyday", 5, "Diet"));
            tr.addHabit(new Habit("gym", "gymie", 7, "Lifestyle"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTracker.json");
            writer.open();
            writer.write(tr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTracker.json");
            tr = reader.read();
            assertEquals("Kirby", tr.getRabbitName());
            List<Habit> habits = tr.getHabits();
            assertEquals(2, habits.size());
            checkHabit("run", "run everyday", 5, "Diet", habits.get(0));
            checkHabit("gym", "gymie", 7, "Lifestyle", habits.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
