package com.ajea.Enums;

public enum SkillLevel {
    LOW(0), MEDIUM(1), HIGH(2);

    private int level;

    private SkillLevel(int level) {
        this.level = level;
    }

    public int getLevelInt() {
        return level;
    }
}
