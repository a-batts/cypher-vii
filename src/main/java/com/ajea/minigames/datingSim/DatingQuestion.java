package com.ajea.minigames.datingSim;

public record DatingQuestion(String question, String[] options, int correctOption) {

    public boolean checkAnswer(int answer) {
        return answer == correctOption;
    }
}
