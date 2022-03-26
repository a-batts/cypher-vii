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

    public SkillLevel start() {
        long startTime = System.currentTimeMillis(); // Timer
        int correctSentences = 0;


        for (int i = 0; i < prompts.length; i++, promptIndex++) {
            // Prints the prompt and waits for the user to type in the answer. ANSI is color.
            System.out.println(ANSI_BLUE + "Type the following prompt:" + ANSI_RESET + " " + prompts[promptIndex]);
            String userInput = input.nextLine();

            // Returns true if the user input is 80% correct and the time taken is less than 10 seconds.
            if (checkInputAndTime(userInput, prompts[promptIndex], System.currentTimeMillis() - startTime))
                correctSentences++;
        }

        return getSkillLevel();
    }

    private boolean checkInputAndTime(String userInput, String prompt, long timeTaken) {
        if (userInput.length() == 0) return false; // If they didn't type anything, it's wrong.

        float totalWords = prompts[promptIndex].split(" ").length;
        float mistakes = countIncorrectWords(userInput, prompts[promptIndex]);

        return mistakes / totalWords < 0.2 && timeTaken < 15000;
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
