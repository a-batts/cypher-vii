package com.ajea.minigames;

import com.ajea.enums.SkillLevel;
import com.ajea.Prompt;

import javax.swing.*;
import java.awt.*;

public class VibeCheck extends JPanel implements Minigame{
    public final String gameSkill = "intuition";
    private final String[] images = {"chair1.png", "kitchen1.png", "cage1.png","chair2.png","kitchen2.png","cage2.png"};
    private static final int maxHeight = 1500;
    private static final int maxWidth = 900;
    private final String[] prompts = {"Who sat in the chair?", "What was made in the kitchen?", "What animal was in the cage?"};
    private final String[][] options = {{"1: your father", "2: your mother", "3: your son", "4: your dog"},
                                    {"1: cake", "2: salad", "3: mac n cheese", "4: chili"},
                                    {"1: hamster", "2: snake", "3: fish", "4: chihuahua"}};
    private int answers[] = {1, 4, 2, 4, 1, 2};
    private int cur;

    public VibeCheck(){
        cur = (int)(images.length*Math.random());
    }

    @Override
    public SkillLevel start() {
        int score = 0;
        for(int i=0; i <3; i++){
            if (cur == images.length-1 ) cur++;
            else cur = 0;
            if (test(prompts[cur/2], options[cur/2], answers[cur/2])){
                score++;
            }

            repaint();
        }
        return skillLevel(score);
    }

    public void paintComponent(Graphics g){
        ImageIcon senario = new ImageIcon(images[cur]);
        g.drawImage(senario.getImage(), 0,0, maxWidth, maxHeight, null);

    }

    private boolean test(String prompt, String[] options, int answer){
        Prompt question = new Prompt();
        int value = question.promptUser(prompt,options);
        if (value == answer){
            return true;
        }
        return false;
    }

    private SkillLevel skillLevel(int score){
        if(score == 3) return SkillLevel.HIGH;
        else if (score == 2) return SkillLevel.MEDIUM;
        else return SkillLevel.LOW;
    }

}

