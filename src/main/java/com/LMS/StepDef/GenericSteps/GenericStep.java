package com.LMS.StepDef;

import com.LMS.base.BaseClass;
import com.LMS.genericUtils.WebElementUtils;
import com.LMS.helper.LaunchBrowserHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class GenericStep {

    private static Logger logger = LogManager.getLogger(WebElementUtils.class);


    public void close() {
        //BaseClass.getDriver().close();
        BaseClass.getDriver().quit();
    }


    public void performLogin() {
        LaunchBrowserHelper objLaunchBrowserHelper = new LaunchBrowserHelper();
        Reporter.log("# Launching GCE home page.....", true);
        objLaunchBrowserHelper.loadLoginPage();
    }

    @Given("^User open the browser$")
    public void userOpenTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BaseClass objBaseClass = new BaseClass();
       /* String browsername = BaseClass.browsername;
        String platform = BaseClass.platformname;
        System.out.println("browsername " + browsername);
        System.out.println("platform " + platform);*/
        objBaseClass.executionFactory();


    }

    @Then("^close the browser$")
    public void closeTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        close();
    }

    @When("^User navigates to GCE homepage$")
    public void userNavigatesToGCEHomepage() throws Throwable {
        performLogin();
        logger.info("Navigates to GCE page");
    }


}
