package com.ajea;

import com.ajea.minigames.*;
import com.ajea.minigames.trivia.Trivia;

import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static final Player PLAYER = new Player();

    public static void main(String[] args){
        List<Minigame> minigames = new LinkedList<>(Arrays.asList(new Trivia(), new DatingSim(), new FindNumbers(), new TypingTest(), new VibeCheck()));

    }
}
