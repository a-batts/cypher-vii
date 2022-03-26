package com.ajea.minigames.trivia;

import com.ajea.Prompt;

public class TriviaQuestion {
    private final String question;
    private final String[] answers;
    private final int correctAnswer;

    public TriviaQuestion(String question, String[] answers, int correctAnswer){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public boolean quiz(){
        return correctAnswer == Prompt.promptUser(question, answers);
    }
}
