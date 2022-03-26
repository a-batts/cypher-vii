package com.ajea;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Loads a JSON file and returns a JSON object or String
 * @example FileLoader file = new FileLoader();
 *          JsonObject json = file.loadJSON("src/main/java/com/ajea/gametree/choices.json").asJsonObject();
 *          System.out.println(json.get("choices").getAsJsonArray().get(0).getAsJsonObject().get("text").getAsString());
 */
public class FileLoader {
    private JsonObject content;

    public FileLoader loadJSON(String filePath) {
        if (!filePath.endsWith(".json")) throw new UnsupportedOperationException("Unsupported file type");

        // Parse json string to json object
        JsonParser parser = new JsonParser();
        // Load json file as a string
        String jsonString = "";

        try {
            jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        content = parser.parse(jsonString).getAsJsonObject();
        return this;
    }

    public String asString() {
        return content.toString();
    }

    public JsonObject asJsonObject() {
        return content;
    }
}
