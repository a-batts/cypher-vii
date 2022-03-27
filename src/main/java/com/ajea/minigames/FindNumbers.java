package com.ajea.minigames;

import com.ajea.enums.SkillLevel;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class FindNumbers extends JPanel implements Minigame {
    public String gameSkill = "observation";
    private static final int maxHeight = 1500;
    private static final int maxWidth = 900;
    final Scanner input = new Scanner(System.in);
    private final int[][] numbers = {{31,85,35,80,57,89,12,22,73,47},
                            {2,19,45,29,48,47,74,33,59,55},
                            {13,64,36,6,92,34,19,7,31,84},
                            {91,26,1,13,47,3,10,8,17,21},
                            {41,92,40,13,33,18,16,12,98,28},
                            {5,20,63,10,2,64,27,56,11,36}};
    private final String prompt = "Find as many of the words as you can within 10 seconds!";
    private int cur;

    public FindNumbers(){
        cur = (int)(6*Math.random());
    }

    public void paintComponent(Graphics g){
        ImageIcon senario = new ImageIcon("find_num"+cur+".png");
        g.drawImage(senario.getImage(), 0,0, maxWidth, maxHeight, null);
    }

    private int countCorrectNumbers(int[] userNums, int[] numbers){
        int score =0;
        boolean[] used = new boolean[userNums.length];
        for(int i=0; i< userNums.length; i++){
            for(int j=0; j< userNums.length; j++){
                if(numbers[j] == userNums[i] && used[j]==false) score++;
            }
        }
        return score;
    }
    private boolean checkInputAndTime(String[] userInput, int[] numbers, long timeTaken) {
        if (userInput.length == 0) return false; // If they didn't type anything, it's wrong.
        int[] userNums = new int[userInput.length];
        for(int i = 0; i<userInput.length; i++){
            userNums[i] = Integer.parseInt(userInput[i]);
        }
        int score = countCorrectNumbers(userNums, numbers);

        return score >= 7 && timeTaken < 15000;
    }

    private SkillLevel skillLevel(int score){
        if(score == 3) return SkillLevel.HIGH;
        else if (score == 2) return SkillLevel.MEDIUM;
        else return SkillLevel.LOW;
    }

    public SkillLevel start() {
        int score = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println(prompt);
            long startTime = System.currentTimeMillis(), timeTaken; // Get the current time in milliseconds (from epoch), so we can see how much time has elapsed.
            String[] userInput = input.next().split(" ");
            timeTaken = System.currentTimeMillis() - startTime;
            if (checkInputAndTime(userInput, numbers[cur], timeTaken)) score++;
            if (cur<numbers.length-1) cur++;
            else cur=0;
            repaint();
        }
        return skillLevel(score);
    }
}
