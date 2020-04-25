package tests;

import entity.AutomatedTest;
import entity.ManualTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.TestEngineer;

public class EngineersTestKit {
    private static final int MINSKILL = 1;
    private static final int MAXSKILL = 10;

    private AutomationEngineer autoE = new AutomationEngineer();
    private TestEngineer testE = new TestEngineer();

    @Test
    public void verifyDefaultAnxietyOfTestEngineer() {
        Assert.assertEquals("Value of Anxiety should be default = 3.", 3, testE.getAnxiety());
    }

    @Test
    public void verifySettingAnxietyOfAutomationEngineer() {
        autoE.setAnxiety(10);
        Assert.assertEquals("Value of Anxiety should be setted = 10.", 10, autoE.getAnxiety());
    }

    @Test
    public void verifyRandomSkillGeneration() {
        Assert.assertTrue("Value of Skill crossed the borders.", 0 < autoE.getSkill() && testE.getSkill() < 11);
    }

    @Test
    public void verifyUnitTestComplexity() {
        AutomatedTest automatedTestUnit = new AutomatedTest(TestLevel.UNIT, 1);
        Assert.assertEquals("Value of UnitTest Complexity != 1.", 1, automatedTestUnit.getComplexity());
    }

    @Test
    public void verifyAPITestComplexity() {
        ManualTest manualTestAPI = new ManualTest(TestLevel.API, 5);
        Assert.assertEquals("Value of APITest Complexity != 3.", 3, manualTestAPI.getComplexity());
    }

    @Test
    public void verifyGUITestComplexity() {
        AutomatedTest automatedTestGUI = new AutomatedTest(TestLevel.GUI, 8);
        Assert.assertEquals("Value of GUITest Complexity != 9.", 9, automatedTestGUI.getComplexity());
    }

    @Test
    public void verifyInstabilityInitialisation() {
        ManualTest manualTestUnit = new ManualTest(TestLevel.UNIT, 2);
        Assert.assertEquals("Value of Instability should be = 2.", 2, manualTestUnit.getInstability());
    }

    //AutomationEngineer applies tests

    @Test
    public void AutomationEngineerExecutedAutomatedUnitTest() {
        AutomatedTest automatedTestUnit = new AutomatedTest(TestLevel.API, 1);
        AutomationEngineer automationEngineer3 = new AutomationEngineer();
        Assert.assertEquals("Test should be PASSED: ",
                Result.PASSED, automatedTestUnit.apply(automationEngineer3));
    }

    @Test
    public void AutomationEngineerExecutedAutomatedAPITest() {
        AutomatedTest automatedTestAPI = new AutomatedTest(TestLevel.API, 5);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        automationEngineer.setSkill(MAXSKILL);
        Assert.assertEquals("Test should be PASSED.",
                Result.PASSED, automatedTestAPI.apply(automationEngineer));
    }

    @Test
    public void AutomationEngineerExecutedAutomatedGUITest() {
        AutomatedTest automatedTestGUI = new AutomatedTest(TestLevel.GUI, 9);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        automationEngineer.setSkill(MINSKILL);
        Assert.assertEquals("Test should be FAILED.",
                Result.FAILED, automatedTestGUI.apply(automationEngineer));
    }

    @Test
    public void AutomationEngineerExecutedManualUnitTest() {
        ManualTest manualTestUnit = new ManualTest(TestLevel.API, 1);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("Test should be PASSED.",
                Result.PASSED, manualTestUnit.apply(automationEngineer));
    }

    @Test
    public void AutomationEngineerExecutedManualGUITest() {
        ManualTest manualTestGUI = new ManualTest(TestLevel.GUI, 9);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        automationEngineer.setSkill(MINSKILL);
        Assert.assertEquals("Test should be FAILED.",
                Result.FAILED, manualTestGUI.apply(automationEngineer));
    }

    //TestEngineer applies tests

    @Test
    public void TestEngineerExecutedManualUnitTest() {
        ManualTest manualTestUnit = new ManualTest(TestLevel.UNIT, 1);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("Test should be PASSED.",
                Result.PASSED, manualTestUnit.apply(testEngineer));
    }

    @Test
    public void TestEngineerExecutedManualAPITest() {
        ManualTest manualTestAPI = new ManualTest(TestLevel.API, 5);
        TestEngineer testEngineer = new TestEngineer();
        testEngineer.setSkill(MAXSKILL);
        Assert.assertEquals("Test should be PASSED.",
                Result.PASSED, manualTestAPI.apply(testEngineer));
    }

    @Test
    public void TestEngineerExecutedManualGUITest() {
        ManualTest manualTestGUI = new ManualTest(TestLevel.GUI, 9);
        TestEngineer testEngineer = new TestEngineer();
        testEngineer.setSkill(MINSKILL);
        Assert.assertEquals("Test should be FAILED.",
                Result.FAILED, manualTestGUI.apply(testEngineer));
    }

    @Test
    public void TestEngineerExecutedAutomatedUnitTest() {
        AutomatedTest automatedTestUnit = new AutomatedTest(TestLevel.UNIT, 1);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("Test should be PASSED.",
                Result.PASSED, automatedTestUnit.apply(testEngineer));
    }

    @Test
    public void TestEngineerExecutedAutomatedGUITest() {
        AutomatedTest automatedTestGUI = new AutomatedTest(TestLevel.GUI, 9);
        TestEngineer testEngineer = new TestEngineer();
        testEngineer.setSkill(MINSKILL);
        Assert.assertEquals("Test should be FAILED.",
                Result.FAILED, automatedTestGUI.apply(testEngineer));
    }
}
