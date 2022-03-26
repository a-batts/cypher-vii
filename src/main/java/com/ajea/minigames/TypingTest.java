package com.ajea.minigames;

import com.ajea.Enums.SkillLevel;

import java.util.Scanner;

public class TypingTest {
    // Color Constants of Console Text
    final String ANSI_RESET = "\u001B[0m"; // Reset to consoles default.
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    final String ANSI_WHITE = "\u001B[37m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";

    int score = 0, promptIndex = 0, correctCount = 0;
    final String[] PROMPTS = { "The quick brown fox jumps over the lazy dog.", "Hi" };
    final Scanner input = new Scanner(System.in); // Scanner for easy handling of user input


    /**
     * Starts the typing test. Goes through each prompt, and asks the user to type it, checks if they're correct, gives feedback,
     * and updates this.correctCount.
     * @return SkillLevel
     */
    public SkillLevel start() {
        intro();

        for (int i = 0; i < PROMPTS.length; i++, promptIndex++) {
            // Prints the prompt and waits for the user to type in the answer. ANSI is color.
            System.out.println(ANSI_BLUE + "Type the following prompt:" + ANSI_RESET + " " + PROMPTS[promptIndex]);

            // Get user input and time taken.
            long startTime = System.currentTimeMillis(), timeTaken; // Get the current time in milliseconds (from epoch), so we can see how much time has elapsed.
            String userInput = input.nextLine();
            timeTaken = System.currentTimeMillis() - startTime;

            // Returns true if the user input is 80% correct and the time taken is less than 10 seconds.
            if (checkInputAndTime(userInput, PROMPTS[promptIndex], timeTaken)) {
                feedback(true); correctCount++;
            } else {
                feedback(false);
            }
        }

        return getSkillLevel();
    }

    private void intro() {
        System.out.println(ANSI_BLUE_BACKGROUND + "Are you coordinated?" + ANSI_RESET + " Let's see how you do!\n" +
                "For this typing test, you'll need to get 80% of words correct in under 15 seconds.\n");

        // We wait 6 seconds so the user can read the instructions.
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the user input is correct (at least 80%) and the time taken is less than 15 seconds.
     * @param userInput - The user's input.
     * @param prompt - The prompt the user was supposed to type.
     * @param timeTaken - The time taken to type the prompt in miliseconds.
     * @return boolean
     */
    private boolean checkInputAndTime(String userInput, String prompt, long timeTaken) {
        if (userInput.length() == 0) return false; // If they didn't type anything, it's wrong.

        float totalWords = PROMPTS[promptIndex].split(" ").length;
        float mistakes = countIncorrectWords(userInput, PROMPTS[promptIndex]);

        return mistakes / totalWords < 0.2 && timeTaken < 15000; // 1 - 0.2 = 80% correct.
    }

    /**
     * Counts the number of incorrect words in the user input.
     * @param userInput - The user's input.
     * @param prompt - The prompt the user was supposed to type.
     * @return int
     */
    private int countIncorrectWords(String userInput, String prompt) {
        // To count the words, we need to separate them by spaces. Make each lowercase to avoid case sensitivity.
        String[] userInputWords = userInput.toLowerCase().split(" ");
        String[] promptWords = prompt.toLowerCase().split(" ");


        // We need to count the number of incorrect words.
        // TODO: Use a better algorithm. Currently, the index only goes up by one, there missing words if there are extra spaces.
        int incorrectWords = 0;
        for (int i = 0; i < userInputWords.length; i++) {
            if (!userInputWords[i].equals(promptWords[i])) incorrectWords++;
        }

        return incorrectWords;
    }

    /**
     * Prints feedback to the user based on whether they got the answer correct or not.
     */
    private void feedback(boolean goodOrBad) {
        System.out.println(
                goodOrBad ?
                        ANSI_GREEN + "Good job 👍! " + ANSI_RESET + (promptIndex+1) + "/" + PROMPTS.length
                        : ANSI_RED + "Uh-oh... not very coordinated ❌. Do better! " + ANSI_RESET + (promptIndex+1) + "/" + PROMPTS.length
        );
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
