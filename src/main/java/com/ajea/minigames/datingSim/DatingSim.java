package com.ajea.minigames.datingSim;

import com.ajea.Prompt;
import com.ajea.enums.SkillLevel;

import static com.ajea.Prompt.promptUser;

public class DatingSim {
    private DatingQuestion[] datingQuestions;
    public String gameSkill = "charm";

    public DatingSim() {
        setupQuestions();
    }

    public SkillLevel start() {
        for (DatingQuestion datingQuestion : datingQuestions) {
            System.out.println(datingQuestion.question());
            int answer = promptUser(datingQuestion.question(), datingQuestion.options());
            System.out.println(answer);
        }
        return SkillLevel.LOW;
    }

    private DatingQuestion[] setupQuestions() {
        DatingQuestion[] questions = new DatingQuestion[2];
        questions[0] = new DatingQuestion("Hi", new String[] {"Hi", "Hello", "Hey"}, 2);
        questions[1] = new DatingQuestion("Hi", new String[] {"Hi", "Hello", "Hey"}, 3);

        return questions;
    }
}
