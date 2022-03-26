package com.ajea;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {

    /**
     * Print out a question and a set of answer choices and return the choice the user selects if valid
     * @param prompt Question to ask user
     * @param choices Array of choices to provide user
     * @return int User selected choice
     */
    //Usage for this class would be int i = Prompt.promptUser(...)
    public static int promptUser(String prompt, String[] choices){
        //Print out question
        System.out.println(prompt);
        System.out.println();
        //Print out all choices
        for(int i = 1; i <= choices.length; i++){
            System.out.println(i + ": " + choices[i-1]);
        }
        int selected = 0;
        //Loop until user picks a valid choice
        while(selected <= 0 || selected > choices.length){
            try{
                selected = Main.scan.nextInt();
                if (selected <= 0 || selected > choices.length)
                    System.out.println("Please enter a valid option");
            }
            //Catch non-int input
            catch(InputMismatchException ignored){
                System.out.println("Please enter a valid option");
                //Consume token so infinite loop does not occur
                Main.scan.nextLine();
            }
        }
        return selected;
    }
}
