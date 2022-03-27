package com.ajea.gametree;

import com.ajea.enums.SkillLevel;

public class Choice {
    public final String skill;

    private String lowSkillChoice;
    private String midSkillChoice;
    private String highSkillChoice;

    public Choice(String skill){
        this.skill = skill;
    }

    public String getChoiceForSkillLevel(SkillLevel s){
        return switch (s.getLevelInt()) {
            case 2, 3 -> midSkillChoice;
            case 4, 5 -> highSkillChoice;
            default -> lowSkillChoice;
        };
    }

    public Choice setChoices(String low, String mid, String high){
        lowSkillChoice = low;
        midSkillChoice = mid;
        highSkillChoice = high;

        return this;
    }
}
