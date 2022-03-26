package com.ajea.minigames;

import com.ajea.Enums.SkillLevel;

import java.util.Scanner;

public class TypingTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";


    int score = 0;
    final String[] prompts = { "The quick brown fox jumps over the lazy dog.", "Hi" };
    int promptIndex = 0;

    Scanner input = new Scanner(System.in);

    /**
     * Default constructor.
     */
    public TypingTest() {

    }

    public SkillLevel start() {
        long startTime = System.currentTimeMillis(); // Timer
        int correctSentences = 0;


        for (int i = 0; i < prompts.length; i++, promptIndex++) {
            int totalWords = prompts[promptIndex].split(" ").length;

            // Prints the prompt and waits for the user to type in the answer. ANSI is color.
            System.out.println(ANSI_BLUE + "Type the following prompt:" + ANSI_RESET + " " + prompts[promptIndex]);
            String userInput = input.nextLine();

            if (!userInput.equals(prompts[promptIndex])) continue; // If they didn't type the prompt, it's wrong.

            int mistakes = countIncorrectWords(userInput, prompts[promptIndex]);
            int timeTaken = (int) (System.currentTimeMillis() - startTime);

            if ((float)mistakes/totalWords > 0.8 && timeTaken > 10000) correctSentences++; // If they made more than 80% of the words correct, it's wrong.
            System.out.println(correctSentences);
        }

        return getSkillLevel();
    }

    private int countIncorrectWords(String userInput, String prompt) {
        String[] userInputWords = userInput.split(" ");
        String[] promptWords = prompt.split(" ");
        int incorrectWords = 0;
        for (int i = 0; i < userInputWords.length; i++) {
            if (!userInputWords[i].equals(promptWords[i])) incorrectWords++;
        }
        return incorrectWords;
    }

    /**
     * Returns the SkillLevel enum representation of the number of successes.
     * @return SkillLevel
     */
    public SkillLevel getSkillLevel() {
        if (score < 2) return SkillLevel.LOW;
        else if (score < 4) return SkillLevel.MEDIUM;
        else if (score <= 6) return SkillLevel.HIGH;


        throw new IllegalStateException("Score is out of range");
    }
}
