package worker;

import entity.Result;
import entity.Test;

public abstract class Engineer {
    private int skill = (int) (Math.random() * 10 + 1);
    private int anxiety = 3;

    public int getSkill() {
        return skill;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public Result executeTest(Test test) {
        return null;
    }
}
