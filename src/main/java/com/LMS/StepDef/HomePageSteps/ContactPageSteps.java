package com.LMS.StepDef.HomePageSteps;

import com.LMS.base.BaseClass;
import com.LMS.genericUtils.Utilities;
import com.LMS.genericUtils.WebElementUtils;
import com.LMS.pages.GCEhomepage.GCEcontactPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.testng.Reporter;

public class ContactPageSteps {
    @Then("^enter details in contact form$")
    public void enterDetailsInContactForm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user clicks on submit button$")
    public void userClicksOnSubmitButton() throws Throwable {

        GCEcontactPage objGCEcontactPage = new GCEcontactPage(BaseClass.getDriver());
        Utilities.sleep(2);
        objGCEcontactPage.webEleSubmitButton.click();
        Reporter.log("# Submit button clicked",true);
    }

    private void enterDetailsInContact(String name, String email, String phone, String company, String subject) {
        Reporter.log("# Fill Contact Details, except subject text", true);
        GCEcontactPage objGCEcontactPage = new GCEcontactPage(BaseClass.getDriver());
        objGCEcontactPage.webEleContactNameText.sendKeys(name);
        objGCEcontactPage.webEleContactEmail.sendKeys(email);
        objGCEcontactPage.webEleContactPhone.sendKeys(phone);
        objGCEcontactPage.webEleContactCompany.sendKeys(company);
        WebElementUtils.selectByText(objGCEcontactPage.webEleSelectContactSubj, subject);


    }

    @Then("^enter details in contact form \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
    public void enterDetailsInContactForm(String name, String email, String phone, String company, String subject) throws Throwable {
        //leaving message text box intentionally to get the error message

        enterDetailsInContact(name, email, phone, company, subject);

    }


    @Then("^validate the error message \"([^\"]*)\"$")
    public void validateTheErrorMessage(String errorMsgExpected) throws Throwable {
        GCEcontactPage objGCEcontactPage = new GCEcontactPage(BaseClass.getDriver());

        Reporter.log("# Actual error message displayed  " +objGCEcontactPage.webEleMsgErrorLabel.getText().trim(),true );
        Assert.assertEquals(objGCEcontactPage.webEleMsgErrorLabel.getText().trim(),errorMsgExpected,"Error message differs!");
        Reporter.log("# Error message verified..", true);
    }
}
