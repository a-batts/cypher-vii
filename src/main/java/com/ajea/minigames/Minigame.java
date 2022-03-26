package com.ajea.minigames;

import com.ajea.enums.SkillLevel;

public interface Minigame {
    //The skill the minigame gives you the chance to improve
    String gameSkill = null;
    //Main method of the minigame - will be called from main game
    SkillLevel start();
}
