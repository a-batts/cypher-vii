package com.ajea.minigames.datingSim;

import java.util.Arrays;
import java.util.Objects;

public final class DatingQuestion {
    private final String question;
    private final String[] options;
    private final int correctOption;

    public DatingQuestion(String question, String[] options) {
        this.question = question;
        this.options = options;
        this.correctOption = 0;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctOption;
    }

    public String question() {
        return question;
    }

    public String[] options() {
        return options;
    }

    public int correctOption() {
        return correctOption;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DatingQuestion) obj;
        return Objects.equals(this.question, that.question) &&
                Objects.equals(this.options, that.options) &&
                this.correctOption == that.correctOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, Arrays.hashCode(options), correctOption);
    }

    @Override
    public String toString() {
        return "DatingQuestion[" +
                "question=" + question + ", " +
                "options=" + options + ", " +
                "correctOption=" + correctOption + ']';
    }

}
