package persistence;

import model.Habit;
import model.Tracker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Tracker tr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTracker() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyTracker.json");
        try {
            Tracker tr = reader.read();
            assertEquals("Kirby", tr.getRabbitName());
            assertEquals(0, tr.getHabits().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTracker() {
        JsonReader reader = new JsonReader("./data/testWriterGeneralTracker.json");
        try {
            Tracker tr = reader.read();
            assertEquals("Kirby", tr.getRabbitName());
            List<Habit> habits = tr.getHabits();
            assertEquals(2, habits.size());
            checkHabit("run", "run everyday", 5, "Diet", habits.get(0));
            checkHabit("gym", "gymie", 7, "Lifestyle", habits.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
