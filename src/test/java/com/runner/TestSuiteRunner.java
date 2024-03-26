package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(
        strict = true, plugin = {"json:test-reports/cucumber.json", "pretty", "html:test-reports/cucumber.html"},
        features = {"src/test/resources/features"},
        glue = "com/search/step_definitions",
        tags = "@sky"
)

public class TestSuiteRunner extends AbstractTestNGCucumberTests {

    private static TestNGCucumberRunner testNGCucumberRunner;

    private TestSuiteRunner(){}


    @BeforeSuite(alwaysRun = true)
    public void initializeCucumberRunner() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterSuite
    public void afterSuite() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        generatePrettyReportsLocally();
    }

    /**
     * @see - https://github.com/damianszczepanik/cucumber-reporting
     * This generates a pretty html report to view locally
     */
    private void generatePrettyReportsLocally() {
        String projectName = "sample";
        String reportFilePath = "test-reports";
        File reportOutputDirectory = new File(reportFilePath);
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("test-reports/cucumber.json");

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();

        Reporter.log("\n**************************************************************************************************************" +
                "\n-------------------------------------   LOCAL PRETTY REPORT CREATED   -------------------------------------" +
                "\nLink: http://localhost:63342/sample/" + reportFilePath + "/cucumber-html-reports/overview-features.html" +
                "\n-----------------------------------------------------------------------------------------------------------" +
                "\n***************************************************************************************************************", true);
    }
}
