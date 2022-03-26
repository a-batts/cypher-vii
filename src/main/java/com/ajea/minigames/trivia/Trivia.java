package com.ajea.minigames.trivia;

import com.ajea.Enums.SkillLevel;

import java.util.Arrays;
import java.util.List;

public class Trivia {
    public SkillLevel start(){
        int correctQuestions = 0;

        System.out.println("Show us how much you actually know about William and Mary by answering a few trivia questions");

        List<TriviaQuestion> questionsBank = Arrays.asList(
                new TriviaQuestion("Who is the president of William and Mary?", new String[]{"Kathy Rowe", "Jim Deverick", "Peggy Agouris"}, 1),
                new TriviaQuestion("Who is the president of William and Mary?", new String[]{"Kathy Rowe", "Jim Deverick", "Caf Bird"}, 1)
        );

        for(int i = 0; i < 5; i++){
            //Select random number from 0 to the size of the question bank
            int selectedQ = (int) (Math.random()*questionsBank.size());
            TriviaQuestion q = questionsBank.get(selectedQ);
            if (q.quiz())
                correctQuestions++;
            //Remove solved question to prevent repetition
            questionsBank.remove(selectedQ);

        }

        return switch (correctQuestions) {
            case 2, 3 -> SkillLevel.MEDIUM;
            case 5 -> SkillLevel.HIGH;
            default -> SkillLevel.LOW;
        };
    }

}
