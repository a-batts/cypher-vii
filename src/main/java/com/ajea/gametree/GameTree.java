package com.ajea.gametree;

import com.ajea.FileLoader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTree {
    private JsonObject choices;
    private final TreeNode root = new TreeNode();

    public GameTree(String fileName){
        FileLoader fl = new FileLoader().loadJSON(fileName);
        choices = fl.asJsonObject();
    }

    public GameTree initTree(){
        //Initialize first node
        TreeNode current = this.root;
        setData(current, 1);
        //Initialize the rest of the story line once it is done

        return this;
    }

    /**
     * Set the prompt and choices for a TreeNode
     * @param node TreeNode
     * @param index index of JSON line
     */
    private void setData(TreeNode node, int index){
        String prompt = choices.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("prompt").toString();
        Choice[] choices = getChoices(index);
        node.setData(prompt, choices);
    }

    private Choice[] getChoices(int index){
        JsonArray currentObject = choices.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("choices").getAsJsonArray();
        ArrayList<Choice> choices = new ArrayList<>();
        for(JsonElement e: currentObject){
            JsonObject arr = e.getAsJsonObject();
            choices.add(new Choice(arr.get("skill").toString()).setChoices(arr.get("short").toString(), arr.get("medium").toString(), arr.get("long").toString()));
        }

        return choices.toArray(new Choice[0]);
    }
}
