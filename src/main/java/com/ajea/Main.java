package com.ajea;

import java.util.Scanner;
import com.ajea.minigames.*;
import com.ajea.minigames.trivia.Trivia;

import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static final Player PLAYER = new Player();

    public static void main(String[] args){
        //Main class
        List<Minigame> minigames = new LinkedList<>(Arrays.asList(new Trivia(), new DatingSim(), new FindNumbers(), new TypingTest(), new VibeCheck()));
        for(int i = 0; i < 2; i++){
            int index = (int) (Math.random()  * minigames.size());
            Minigame selectedMinigame = minigames.get(index);
            PLAYER.setSkill(selectedMinigame.gameSkill, selectedMinigame.start());
            //Remove played minigame to ensure that it isn't repeated
            minigames.remove(index);
        }
    }
}