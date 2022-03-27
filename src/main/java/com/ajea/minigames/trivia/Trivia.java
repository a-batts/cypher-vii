package com.ajea.minigames.trivia;

import com.ajea.enums.SkillLevel;
import com.ajea.minigames.Minigame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trivia implements Minigame {
    private int correctQuestions = 0;

    private final List<TriviaQuestion> QUESTIONS_BANK = new LinkedList<>(Arrays.asList(
            new TriviaQuestion("Who is the president of William and Mary?", new String[]{"Kathy Rowe", "Jim Deverick", "Peggy Agouris"}, 1),
            new TriviaQuestion("Which of these buildings is the oldest?", new String[]{"Boswell Hall", "Commons Dining Hall (Caf)", "Pleasents Hall"}, 2),
            new TriviaQuestion("What is the William & Mary student:faculty ratio?", new String[]{"12:1", "13:1", "14:1"}, 1),
            new TriviaQuestion("Which of these people was not a William & Mary chancellor?", new String[]{"George Washington", "John Adams", "Margaret Thatcher"}, 2),
            new TriviaQuestion("William & Mary is designated as a \"Public Ivy\". Which of these other schools is also a public ivy?", new String[]{"Miami University", "University of Washington", "University of Colorado: Boulder"}, 1),
            new TriviaQuestion("Which of these programs was W&M the first university to offer?", new String[]{"Philosophy", "Religious Studies", "Modern Languages"}, 3),
            new TriviaQuestion("When did William & Mary officially become a university?", new String[]{"1693", "1727", "1779"}, 3),
            new TriviaQuestion("What percentage of classes at William & Mary have fewer than 40 students?", new String[]{"78%", "82%", "86%"}, 3),
            new TriviaQuestion("According to Rate My Professors, which of these aspects of William & Mary has the highest rating?", new String[]{"Opportunity", "Facilities", "Happiness"}, 2),
            new TriviaQuestion("Which of these locations do not accept W&M Express as payment?", new String[]{"Five Guys", "Panera", "Which Wich"}, 1)
    ));

    public String gameSkill = "intelligence";

    /**
     * Starts the trivia minigame. Prompts user with 5 random trivia questions and counts how many they get right.
     * @return SkillLevel
     */
    public SkillLevel start(){
        intro();

        for(int i = 0; i < 5; i++){
            //Select random number from 0 to the size of the question bank
            int selectedQ = (int) (Math.random()* QUESTIONS_BANK.size());
            TriviaQuestion q = QUESTIONS_BANK.get(selectedQ);
            if (q.quiz()){
                correctQuestions++;
                System.out.println("Correct! Good job!");
            }
            else
                System.out.println("Incorrect answer");
            //Remove solved question to prevent a user getting re-prompted with the same question
            QUESTIONS_BANK.remove(selectedQ);
            System.out.println();
        }

        System.out.println("You got " + correctQuestions + "/5 questions right!");
        System.out.println();

        //Return user's skill level based on how many questions they get correct
        return switch (correctQuestions) {
            case 2, 3 -> SkillLevel.MEDIUM;
            case 5 -> SkillLevel.HIGH;
            default -> SkillLevel.LOW;
        };
    }

    private void intro(){
        System.out.println("Show us how much you actually know about William and Mary by answering a few trivia questions.\n" +
                "The more you get correct, the higher your intelligence stat will be.");
    }

}
