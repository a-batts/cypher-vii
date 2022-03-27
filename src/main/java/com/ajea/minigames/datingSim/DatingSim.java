package com.ajea.minigames.datingSim;

import com.ajea.enums.SkillLevel;

import java.util.ArrayList;
import java.util.List;

import static com.ajea.Main.*;
import static com.ajea.Prompt.promptUser;

public class DatingSim {
    private DatingQuestion[] datingQuestions;
    int score = 0;
    final public String gameSkill = "charm";

    public DatingSim() {
        setupQuestions();
    }

    public SkillLevel start() {
        intro();

        /*
          I don't have the time to learn a binary tree algorithm. You must make do with this disaster.
          I present to you, the dating sim master switch.
          Look at this for help.... you'll want to use it... I promise:
          https://cdn.discordapp.com/attachments/355066621221535745/957488759769792522/datingsimstructure.png
         */
        int currentQuestion = 0;
        for (int i = 0; i < datingQuestions.length; i++) {
        switch (currentQuestion) {
            case 0:
                int answer = promptUser(datingQuestions[currentQuestion].question(), datingQuestions[currentQuestion].options());
                if (answer == 1) {
                    currentQuestion = 99; // END THE GAME. LOSER.
                } else if (answer == 2) {
                    currentQuestion = 1; // GO TO QUESTION 0B...the medium option.
                    score += 2;
                } else if (answer == 3) {
                    currentQuestion = 2; // GO TO QUESTION 1...great job ig.
                    score += 5;
                }
                break;
            case 99:
                return finish(); // Ha, loser. Unless you were charming.
            case 1: {
                int answer2 = promptUser(datingQuestions[currentQuestion].question(), datingQuestions[currentQuestion].options());
                if (answer2 == 1) {
                    currentQuestion = 99; // Game ends but right choice.
                    System.out.println("You had a good time with your crush and you hang out from time to time, but just as friends – nothing more. Maybe it’s for the better! Total score: 7/15");
                    score += 7;
                } else if (answer2 == 2) {
                    currentQuestion = 99; // Game ends but wrong choice.
                    System.out.println("Your crush is clearly hurt by your backhanded compliment, and now all their friends give you dirty looks. Total score: 2/15");
                } else if (answer2 == 3) {
                    currentQuestion = 99; // Game ends but right choice.
                    System.out.println("You had a good time studying together, but your crush clearly took your words to heart – it never happens again. Total score: 4/15");
                    score += 2;
                }
                break;
            }
            case 2: {
                int answer3 = promptUser(datingQuestions[currentQuestion].question(), datingQuestions[currentQuestion].options());
                if (answer3 == 1) {
                    currentQuestion = 3; // Go to question 4...
                    score += 5;
                } else if (answer3 == 2) {
                    currentQuestion = 99; // Game ends but wrong choice.
                    score += 2;
                } else if (answer3 == 3) {
                    currentQuestion = 99; // Game ends but wrong choice.
                }
            }
            case 3: {
                int answer4 = promptUser(datingQuestions[currentQuestion].question(), datingQuestions[currentQuestion].options());
                if (answer4 == 1) {
                    currentQuestion = 99; // Game ends but wrong choice.
                    System.out.println("You see a movie with your crush. It’s mildly entertaining, but you quickly learn you’ve made a mistake as you realize that actually talking to your crush would be much more fun than sitting in the dark with them for two hours. You continue to hang out with them often, but just as friends – nothing more. Maybe it’s for the better! Total score: 10/15");
                } else if (answer4 == 2) {
                    currentQuestion = 99; // Game ends but wrong choice.
                    score += 2;
                    System.out.println("You and your crush go to Noodles & Co. You have a good time eating your pasta, but you get some sauce on your shirt! Regardless, you make plans for another date with your crush, and you can’t wait to go out with them again. Congratulations! Total score: 12/15");
                } else if (answer4 == 3) {
                    currentQuestion = 99; // Game ends, FANTASTIC CHOICE!
                    score += 5;
                    System.out.println("You and your crush go to the farmers market, and it couldn’t be more perfect. The weather is beautiful, and both of you have a lovely time. The date goes wonderfully, and you’ve even made plans for the next one by the end! Congratulations, you’ve wooed your crush! Total score: 15/15");
                }
            }
        }

        }

        return SkillLevel.LOW;
    }

    private void intro() {
        System.out.println(
                ANSI_RED_BACKGROUND + "You're in love, but can you manage the pressure?" + ANSI_RESET + "\n" +
                "Things can get worse before they get better. But if you prove yourself, you'll get all the charisma.\n");

        // We wait 6 seconds so the user can read the instructions.
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setupQuestions() {
        List<DatingQuestion> questions = new ArrayList<>(4);
        questions.add(
                new DatingQuestion("You notice someone really cute across the room in one of your classes, and you really want to get to know them a little better. They approach you at the end of class and ask if you want to study for the next exam together. How do you reply?",
                new String[] {
                        "“I’m feeling confident on these topics, so I think I’ll be okay on my own. Maybe we could hang out some other time though!”",
                        "“Yeah, that sounds good! I’m really confident for this one, so I can give you some pointers to help you do well on the exam.”",
                        "“That sounds really fun! Want to meet at Swem at 4:00?”"
                })
        );
        questions.add(
                new DatingQuestion("You study with your crush at Swem, and things seem to be going well. You take the exam feeling as confident as ever, and when you get it back, you see that you got a 92. Your crush approaches you excitedly after class and tells you that they got a 98 on the exam. How do you respond?",
                new String[] {
                        "“Looks like next time you’ll be the one giving me pointers!”",
                        "“Wow, you must have gotten lucky with the partial credit! Nice job!”",
                        "“I guess you didn’t need me after all!”"}));

        questions.add(
                new DatingQuestion("You study with your crush at Swem, and you really hit it off. You leave the study session feeling perfectly prepared, and you’re confident when you take the exam. When you get the exam back, you’re overjoyed to learn that both you and your crush knocked it out of the park! You want to ask them to go celebrate somewhere with you. What do you say?",
                new String[] {
                        "“Wanna get smoothies from Wawa with me?”",
                        "“I hear that froyo place near New Town is good, do you want to try it with me?”",
                        "“I hear Caf has good brownies today, let’s go there!”"
                }));

        questions.add(
                new DatingQuestion("You go to Wawa and get your smoothies. Your crush really enjoyed theirs, and wants to hang out again sometime! What do you suggest?",
                new String[] {
                        "“Let’s go see a movie this Saturday!”",
                        "“Let’s go check out the Williamsburg Farmers Market this weekend!”",
                        "“Let’s go to Noodles & Co. in New Town!”"
                })
        );

        datingQuestions = questions.toArray(new DatingQuestion[0]);
    }

    private SkillLevel finish() {
        if (score <= 5) {
            return SkillLevel.LOW;
        } else if (score <= 10) {
            return SkillLevel.MEDIUM;
        } else if (score <= 15) {
            return SkillLevel.HIGH;
        }

        throw new RuntimeException("Score out of range: " + score);
    }
}
