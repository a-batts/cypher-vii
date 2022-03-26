package com.ajea;

import com.ajea.Enums.SkillLevel;

import java.util.HashMap;
import java.util.Map;

public class Player {
    Map<String, SkillLevel> skills = new HashMap<>();

    public Player(){
        skills.put("intelligence", SkillLevel.LOW);
        skills.put("intuition", SkillLevel.LOW);
        skills.put("observation", SkillLevel.LOW);
        skills.put("coordination", SkillLevel.LOW);
        skills.put("charm", SkillLevel.LOW);
    }

    public void setSkill(String skillName, SkillLevel level){
        skills.replace(skillName, level);
    }

    public SkillLevel getLevelOfSkill(String skillName){
        return skills.get(skillName);
    }
}
