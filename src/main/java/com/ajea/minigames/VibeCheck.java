package com.ajea.minigames;

import com.ajea.enums.SkillLevel;
import com.ajea.Prompt;

import javax.swing.*;
import java.awt.*;

public class VibeCheck extends JPanel implements Minigame{
    private String[] images = {};
    private static int maxHeight = 1500;
    private static int maxWidth = 900;
    private String[] prompts = {};
    private String[][] options = {{}};
    private int answers[] = {};
    private int increm = 0;

    public VibeCheck(){

    }

    @Override
    public SkillLevel start() {
        int score = 0;
        while(increm<3){
            if(test(prompts[increm], options[increm], answers[increm])){
                score++;
            }
            increm++;
            repaint();
        }
        return skillLevel(score);
    }

    public void paintComponent(Graphics g){
        ImageIcon senario = new ImageIcon(images[increm]);
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

