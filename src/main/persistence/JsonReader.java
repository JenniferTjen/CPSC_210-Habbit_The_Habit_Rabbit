package persistence;

import model.Habit;
import model.Rabbit;
import model.Tracker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads tracker from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Tracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTracker(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    public String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses tracker from JSON object and returns it
    private Tracker parseTracker(JSONObject jsonObject) {
        String name = jsonObject.getString("rabbit");
        Tracker tr = new Tracker(name);
        addRabbitStats(tr, jsonObject);
        addHabits(tr, jsonObject);
        return tr;
    }

    // MODIFIES: tr
    // EFFECTS: parses habits from JSON object and adds them to Tracker
    private void addHabits(Tracker tr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("habit");
        for (Object json : jsonArray) {
            JSONObject nextHabit = (JSONObject) json;
            addHabit(tr, nextHabit);
        }
    }

    private void addHabit(Tracker tr, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String desc = jsonObject.getString("desc");
        int perDay = jsonObject.getInt("perDay");
        int progress = jsonObject.getInt("progress");
        boolean finished = jsonObject.getBoolean("finished");
        String category = jsonObject.getString("category");
        Habit habit = new Habit(title, desc, perDay, category);
        habit.setProgress(progress);
        habit.setFinished(finished);
        tr.addHabit(habit);
    }

    private void addRabbitStats(Tracker tr, JSONObject jsonObject) {
        boolean dietGood = jsonObject.getBoolean("dietGood");
        boolean fit = jsonObject.getBoolean("fit");
        boolean entertained = jsonObject.getBoolean("entertained");
        boolean notLonely = jsonObject.getBoolean("notLonely");
        int happiness = jsonObject.getInt("happiness");
        int maxHappiness = jsonObject.getInt("maxHappiness");
        boolean isHappy = jsonObject.getBoolean("isHappy");
        tr.getRabbit().setDiet(dietGood);
        tr.getRabbit().setFit(fit);
        tr.getRabbit().setEntertained(entertained);
        tr.getRabbit().setSocial(notLonely);
        tr.getRabbit().setHappiness(happiness);
        tr.getRabbit().setMaxHappiness(maxHappiness);
        tr.getRabbit().setHappinessStatus(isHappy);
    }
}
