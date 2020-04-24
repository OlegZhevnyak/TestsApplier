import entity.AutomatedTest;
import entity.ManualTest;
import entity.Result;
import entity.TestLevel;
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
public class EngineerExecuteTestPT {
    private Engineer engineer;
    private int skill;
    private entity.Test test;
    private Result expected;

    public EngineerExecuteTestPT(Engineer engineer, int skill, entity.Test test, Result expected) {
        this.engineer = engineer;
        this.skill = skill;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.UNIT, 1), Result.PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.GUI, 0), Result.PASSED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.UNIT, 0), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.UNIT, 10), Result.PASSED},
                {new TestEngineer(), 10, new AutomatedTest(TestLevel.API, 11), Result.PASSED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.GUI, 10), Result.FAILED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.GUI, 11), Result.FAILED},
                {new TestEngineer(), 1, new AutomatedTest(TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer(), 1, new AutomatedTest(TestLevel.UNIT, 11), Result.PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer(), 1, new ManualTest(TestLevel.API, 10), Result.FAILED},
                {new AutomationEngineer(), 10, new ManualTest(TestLevel.GUI, 11), Result.PASSED},
                {new AutomationEngineer(), 1, new ManualTest(TestLevel.GUI, 1), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer(), 10, new AutomatedTest(TestLevel.API, 10), Result.PASSED},
        });
    }

    @Test
    public void EngineerExecuteTest() {
        engineer.setSkill(skill);
        Assert.assertEquals("Unexpected result of test execution.", expected, test.apply(engineer));
    }
}
