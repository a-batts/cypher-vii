package com.ajea.minigames.trivia;

import com.ajea.Enums.SkillLevel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trivia {
    public SkillLevel start(){
        int correctQuestions = 0;
        intro();

        List<TriviaQuestion> questionsBank = new LinkedList<>(Arrays.asList(
                new TriviaQuestion("Who is the president of William and Mary?", new String[]{"Kathy Rowe", "Jim Deverick", "Peggy Agouris"}, 1),
                new TriviaQuestion("Which of these buildings is the oldest?", new String[]{"Boswell Hall", "Commons Dining Hall (Caf)", "Pleasents Hall"}, 2),
                new TriviaQuestion("What is the William & Mary student:faculty ratio?", new String[]{"12:1", "13:1", "14:1"}, 1),
                new TriviaQuestion("Which of these people was not a William & Mary chancellor?", new String[]{"George Washington", "John Adams", "Margaret Thatcher"}, 2),
                new TriviaQuestion("William & Mary is designated as a \"Public Ivy\". Which of these other schools is also a public ivy?", new String[]{"Miami University", "University of Washington", "University of Colorado: Boulder"}, 1),
                new TriviaQuestion("Which of these programs was W&M the first university to offer?", new String[]{"1693", "1727", "1779"}, 3)
        ));

        for(int i = 0; i < 5; i++){
            //Select random number from 0 to the size of the question bank
            int selectedQ = (int) (Math.random()*questionsBank.size());
            TriviaQuestion q = questionsBank.get(selectedQ);
            if (q.quiz()){
                correctQuestions++;
                System.out.println("Correct!");
            }
            else
                System.out.println("Incorrect answer");
            //Remove solved question to prevent repetition
            questionsBank.remove(0);
            System.out.println();

        }

        return switch (correctQuestions) {
            case 2, 3 -> SkillLevel.MEDIUM;
            case 5 -> SkillLevel.HIGH;
            default -> SkillLevel.LOW;
        };
    }

    public void intro(){
        System.out.println("Show us how much you actually know about William and Mary by answering a few trivia questions.\n" +
                "The more you get correct, the higher your intelligence stat will be.");
    }

}
