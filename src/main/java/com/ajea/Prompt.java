package com.ajea;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {

    //Usage for this class would be Prompt.promptUser(...)
    public static int promptUser(String prompt, String[] choices){
        Scanner scan = new Scanner(System.in);
        //Print out prompt
        System.out.println(prompt);
        System.out.println();
        //Print out all choices
        for(int i = 1; i <= choices.length; i++){
            System.out.println(i + ": " + choices[i]);
        }
        int selected = 0;
        //Loop until user picks a valid choice
        while(selected <= 0 || selected > choices.length){
            try{
                selected = scan.nextInt();
                if (selected <= 0 || selected > choices.length)
                    System.out.println("Please enter a valid option");
            }
            //Catch non-int input
            catch(InputMismatchException ignored){
                System.out.println("Please enter a valid option");
            }
        }
        return selected;
    }
}
