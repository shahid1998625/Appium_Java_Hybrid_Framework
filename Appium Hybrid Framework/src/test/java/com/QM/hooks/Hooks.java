package com.QM.hooks;

import com.QM.Base.BaseClass1;
import com.QM.utils.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;

public class Hooks extends BaseClass1 implements IInvokedMethodListener, IExecutionListener, ITestListener {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
        ExtentReportUtil.setup();
        ExtentReportUtil.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("After Scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            ExtentReportUtil.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentReportUtil.getTest().pass("Scenario passed: " + scenario.getName());
        }
        ExtentReportUtil.tearingDown(scenario, "test case Failed");
    }

}
