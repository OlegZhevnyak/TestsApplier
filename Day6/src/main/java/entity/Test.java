package entity;

import worker.TestEngineer;
import worker.AutomationEngineer;
import worker.Engineer;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {
    private int complexity;
    private int instability;

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getInstability() {
        return instability;
    }

    public void setInstability(int instability) {
        this.instability = instability;
    }

    public Test(TestLevel testLevel, int instability) {
        this.complexity = testLevel.COMPLEXITY;
        this.instability = instability;
        if (instability == 0) this.instability = 0;
        if (instability > 10) this.instability = 10;
    }

    @Override
    public Result apply(Engineer engineer) {
        int anxiety;
        if ((this instanceof ManualTest && engineer instanceof AutomationEngineer) ||
                (this instanceof AutomatedTest && engineer instanceof TestEngineer))
            anxiety = engineer.getAnxiety();
        else
            anxiety = 1;
        if (complexity * instability * anxiety / engineer.getSkill() > 30)
            return Result.FAILED;
        else
            return Result.PASSED;
    }
}
