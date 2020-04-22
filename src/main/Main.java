package main;

import entity.AutomatedTest;
import entity.ManualTest;
import entity.TestLevel;
import worker.AutomationEngineer;
import worker.TestEngineer;

public class Main {
    public static void main(String[] args) {

        AutomatedTest automatedTestUnit = new AutomatedTest(TestLevel.UNIT, 1);
        AutomatedTest automatedTestAPI = new AutomatedTest(TestLevel.API, 5);
        AutomatedTest automatedTestGUI = new AutomatedTest(TestLevel.GUI, 8);

        ManualTest manualTestUnit = new ManualTest(TestLevel.UNIT, 2);
        ManualTest manualTestAPI = new ManualTest(TestLevel.API, 5);
        ManualTest manualTestGUI = new ManualTest(TestLevel.GUI, 7);

        TestEngineer testEngineer1 = new TestEngineer();
        AutomationEngineer automationEngineer1 = new AutomationEngineer();


        //AutomationEngineer & automatedTests
        System.out.println("AutomationEngineer & automatedTests:" + "\n"
                + automatedTestUnit.apply(automationEngineer1) + ", "
                + automatedTestAPI.apply(automationEngineer1) + ", "
                + automatedTestGUI.apply(automationEngineer1));

        System.out.println();

        //testEngineer & manualTest-s
        System.out.println("testEngineer & manualTests:" + "\n"
                + manualTestUnit.apply(testEngineer1) + ", "
                + manualTestAPI.apply(testEngineer1) + ", "
                + manualTestGUI.apply(testEngineer1));
    }
}


