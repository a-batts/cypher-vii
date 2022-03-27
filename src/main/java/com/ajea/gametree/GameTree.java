package com.ajea.gametree;

import com.ajea.FileLoader;
import com.ajea.Main;
import com.google.gson.JsonObject;

public class GameTree {
    private final JsonObject data;
    private final TreeNode root = new TreeNode();

    public GameTree(String fileName){
        FileLoader fl = new FileLoader().loadJSON(fileName);
        data = fl.asJsonObject();
    }

    public GameTree initTree(){
        //Initialize first node
        setData(this.root, 1);
        //Initialize the rest of the story line once it is done

        return this;
    }

    /**
     * Set the prompt and choices for a TreeNode
     * @param node TreeNode
     * @param index index of JSON line
     */
    private void setData(TreeNode node, int index){
        node.setData(getPrompt(index), getChoices(index));
    }

    private String getPrompt(int index){
        JsonObject promptData = data.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("prompts").getAsJsonArray().get(0).getAsJsonObject();

        return switch (Main.PLAYER.getLevelOfSkill(promptData.get("skill").getAsString()).getLevelInt()) {
            case 2, 3 -> promptData.get("long").toString();
            case 4, 5 -> promptData.get("medium").toString();
            default -> promptData.get("short").toString();
        };
    }

    private String[] getChoices(int index){
        JsonObject choiceData = data.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("choices").getAsJsonArray().get(0).getAsJsonObject();

        return new String[]{choiceData.get("a").toString(), choiceData.get("b").toString()};
    }
}
