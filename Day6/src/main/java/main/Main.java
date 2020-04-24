package main;

import entity.AutomatedTest;
import entity.TestLevel;
import worker.AutomationEngineer;

public class Main {
    public static void main(String[] args) {
        AutomationEngineer autoE1 = new AutomationEngineer();
        AutomatedTest autoT1 = new AutomatedTest(TestLevel.UNIT, 5);

        autoT1.apply(autoE1);
    }
}
