package com.ajea;

import com.ajea.gametree.GameTree;
import com.ajea.gametree.TreeNode;
import com.ajea.minigames.*;
import com.ajea.minigames.datingSim.DatingSim;
import com.ajea.minigames.trivia.Trivia;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Color Constants of Console Text
    public static final String ANSI_RESET = "\u001B[0m"; // Reset to consoles default.
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static Scanner scan = new Scanner(System.in);

    public static final Player PLAYER = new Player();

    public static void main(String[] args){
        //Run minigames
        LinkedList<Minigame> minigames = new LinkedList<>(Arrays.asList(new Trivia(), new DatingSim(), new FindNumbers(), new TypingTest(), new VibeCheck()));
        for(int i = 0; i < 2; i++){
            int index = (int) (Math.random()  * minigames.size());
            Minigame selectedMinigame = minigames.get(index);
            PLAYER.setSkill(selectedMinigame.gameSkill, selectedMinigame.start());
            //Remove played minigame to ensure that it isn't repeated
            minigames.remove(index);
        }
        //Create the game tree
        GameTree game = new GameTree("src/main/resources/choices.json").initTree();
        runGame(game);

    }

    private static void runGame(GameTree game){
        TreeNode current = game.getRoot();
        while(current.left != null && current.right != null){
            int sel = Prompt.promptUser(current.prompt, current.choices);
            if(sel == 1)
                current = current.left;
            else if(sel == 2)
                current = current.right;
        }
        System.out.println(current.prompt);
    }
}