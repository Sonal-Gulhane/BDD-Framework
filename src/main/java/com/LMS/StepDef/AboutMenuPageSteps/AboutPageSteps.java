package com.LMS.StepDef.AboutMenuPageSteps;

import com.LMS.base.BaseClass;
import com.LMS.genericUtils.Utilities;
import com.LMS.genericUtils.WebElementUtils;
import com.LMS.pages.AboutMenuPage.GCEAboutPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.testng.Reporter;

public class AboutPageSteps {

    GCEAboutPage objGCEAboutPage = new GCEAboutPage(BaseClass.getDriver());

    @Then("^user hovers on About menu$")
    public void userHoversOnAboutMenu() throws Throwable {
        WebElementUtils.mouseHover(BaseClass.getDriver(),objGCEAboutPage.webEleAboutMenu);
        Utilities.sleep(2);
    }

    @Then("^validate submenu \"(.*)\" and \"(.*)\"$")
    public void validateSubmenuAnd(String menuSustainability, String menuServiceModel) throws Throwable {
        Assert.assertTrue(WebElementUtils.isElementDisplayed(objGCEAboutPage.webEleServModelSubMenu));
        Assert.assertTrue(WebElementUtils.isElementDisplayed(objGCEAboutPage.webEleSustanibilitySubMenu));
        Reporter.log("# both menu displayed..",true);

    }

    @Then("^user clicks on ServiceModel submenu$")
    public void userClicksOnServiceModelSubmenu() throws Throwable {
        objGCEAboutPage.webEleServModelSubMenu.click();
    }

    @Then("^validates ServiceModel load \"([^\"]*)\"$")
    public void validatesServiceModelLoad(String labelMessage) throws Throwable {
        Assert.assertTrue(objGCEAboutPage.webEleServModelLabel.getText().trim().equalsIgnoreCase(labelMessage),"Service Model page not loaded properly!");
        Reporter.log("# Service model page loaded properly",true);
    }

    @Then("^user clicks on DoingBusiness Link$")
    public void userClicksOnDoingBusinessLink() throws Throwable {
        objGCEAboutPage.webEleLinkDoingBusiness.click();
        WebElementUtils.waitTillPageLoad(5);
        Reporter.log("# Procurement Page loaded successfully",true);
    }

    @Then("^click on SupplierCodeOfConduct Link$")
    public void clickOnSupplierCodeOfConductLink() throws Throwable {
        objGCEAboutPage.webEleLinkSuppCodOfConduct.click();
        WebElementUtils.waitTillPageLoad(5);
        WebElementUtils.switchToNewWindow();
        Utilities.sleep(2);

    }

    @Then("^Validate the pdfLoad for SupplierCodeOfConduct$")
    public void validateThePdfLoadForSupplierCodeOfConduct() throws Throwable {
        String pdfUrl = BaseClass.getDriver().getCurrentUrl();
        Utilities.validatePdfURLisLoaded(pdfUrl);
        Reporter.log("# PDF displayed successfully",true);
    }

}
