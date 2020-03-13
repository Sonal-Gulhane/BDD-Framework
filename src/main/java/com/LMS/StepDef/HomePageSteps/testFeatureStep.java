package com.LMS.StepDef.HomePageSteps;

import com.LMS.base.BaseClass;
import com.LMS.genericUtils.Utilities;
import com.LMS.pages.GCEhomepage.GCEcontactPage;
import com.LMS.pages.GCEhomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class testFeatureStep  {




   /* public void performLogin() {
        LaunchBrowserHelper objLaunchBrowserHelper = new LaunchBrowserHelper();
        Reporter.log("# Launching GCE home page.....", true);
        objLaunchBrowserHelper.loadLoginPage();
    }*/

   /* @When("^User navigates to GCE homepage$")
    public void userNavigatesToGCEHomepage() throws Throwable {
        performLogin();

    }*/

    @When("^User Clicks on Contact Menu on HomePage$")
    public void userClicksOnContactMenuOnHomePage() throws Throwable {
        GCEhomePage objGCEHomePage  = new GCEhomePage(BaseClass.getDriver());
        objGCEHomePage.webEleContactMenu.click();
    }


  /*  public void close(){
        BaseClass.getDriver().close();
        BaseClass.getDriver().quit();
    }*/

    @Then("^user enters details on contact page (.*)$")
    public void userEntersDetailsOnContactPage(String Contactname) throws Throwable {
        GCEcontactPage objGCEcontactpage = new GCEcontactPage(BaseClass.getDriver());
        objGCEcontactpage.webEleContactNameText.sendKeys(Contactname);
        Utilities.sleep(2);
    }

/*    @Then("^close the browser$")
    public void closeTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        close();
    }*/

    /*@Given("^User open the browser$")
    public void userOpenTheBrowser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BaseClass objBaseClass = new BaseClass();
        objBaseClass.executionFactory("chrome","local");

    }*/
}
