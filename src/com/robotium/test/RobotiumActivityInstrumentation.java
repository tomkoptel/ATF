package com.robotium.test;


import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;

@SuppressWarnings("unchecked")
public class RobotiumActivityInstrumentation extends ActivityInstrumentationTestCase2 {
    private static final String TARGET_PACKAGE_ID = "com.robotium.calc";
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.calculator.StartUpActivity";
    private static Class launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public RobotiumActivityInstrumentation() throws ClassNotFoundException {
        super(TARGET_PACKAGE_ID, launcherActivityClass);
    }

    private Solo solo;

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testDisplayBlackBox() {
        //Enter any integer/decimal value for first editfield, we are writing 10
        solo.enterText(0, "10");
        //Enter any interger/decimal value for first editfield, we are writing 20
        solo.enterText(1, "20");
        //Click on Multiply button
        solo.clickOnButton("Multiply");
        //Verify that resultant of 10 x 20
        assertTrue(solo.searchText("200"));
    }

    @Override
    public void tearDown() throws Exception {
        try {
            solo.finalize();
        } catch (Throwable throwable) {

        }
    }
}