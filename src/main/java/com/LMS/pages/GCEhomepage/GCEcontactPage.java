package com.LMS.pages.GCEhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GCEcontactPage {

    private WebDriver driver;
    public GCEcontactPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(how = How.ID, using = "contactName")
    public WebElement webEleContactNameText;

    @FindBy(how=How.ID,using = "contactEmail")
    public WebElement webEleContactEmail;

    @FindBy(how=How.ID,using = "contactPhone")
    public WebElement webEleContactPhone;

    @FindBy(how=How.ID,using = "contactCompany")
    public WebElement webEleContactCompany;

    @FindBy(how=How.ID,using = "contactSubject")
    public WebElement webEleSelectContactSubj;

    @FindBy(how=How.ID,using = "contactMessage")
    public WebElement webEleContactMsg;

    @FindBy(how=How.CSS,using = "#contactForm div button.btn")
    public WebElement webEleSubmitButton;



    @FindBy(how=How.ID,using = "contactMessage-error")
    public WebElement webEleMsgErrorLabel;
}
