package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EngineerFieldsPT {
    private static final int MINSKILL = 1;
    private static final int MAXSKILL = 10;
    private Engineer engineer;

    public EngineerFieldsPT(Engineer engineer) {
        this.engineer = engineer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void verifyDefaultAnxietyOfEngineer() {
        Assert.assertEquals("Value of Anxiety should be default = 3.", 3, engineer.getAnxiety());
    }

    @Test
    public void verifyRandomSkillGeneration() {
        Assert.assertTrue("Value of Skill crossed the borders.", 0 < engineer.getSkill() && engineer.getSkill() < 11);
    }

    @Test
    public void verifySettingMAXSkillOfEngineer() {
        engineer.setSkill(MAXSKILL);
        Assert.assertEquals("Value of Skill should be setted = 10.", 10, engineer.getSkill());
    }

    @Test
    public void verifySettingMINSkillOfEngineer() {
        engineer.setSkill(MINSKILL);
        Assert.assertEquals("Value of Skill should be setted = 1.", 1, engineer.getSkill());
    }
}
