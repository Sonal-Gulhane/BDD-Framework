package com.LMS.Runner;

import com.LMS.excelUtis.FeatureOverright;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import java.io.IOException;


//@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        outputFolder = "target2")
@CucumberOptions(
        features = "src/test/java/com/LMS/Feature/",
        glue = {"com.LMS.StepDef"},
        //tags = {"~@Ignore"},
        //tags = {"@regression"},
        tags = {"@smoke"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "usage:target/cucumber-reports/cucumber-usage.json", "junit:target/cucumber-reports/cucumber-results.xml"
        },monochrome = true,dryRun = false,
        strict = true,
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")


public class TestRunner extends ExtentTestNgFormatter {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test( description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        FeatureOverright.overrideFeatureFiles("./src/test/java/com/LMS/Feature");

    }


}