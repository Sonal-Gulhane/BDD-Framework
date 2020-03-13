package com.LMS.pages.AboutMenuPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GCEAboutPage {

    private WebDriver driver;
    public GCEAboutPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(how = How.CSS, using = ".nav-link[data-hash='#about']")
    public WebElement webEleAboutMenu;

    @FindBy(how = How.CSS, using = ".nav-link[href='service-model.html']")
    public WebElement webEleServModelSubMenu;

    @FindBy(how = How.CSS, using = ".nav-link[href='sustainability.html']")
    public WebElement webEleSustanibilitySubMenu;

    @FindBy(how = How.CSS, using = ".container.spacing-bottom h2")
    public WebElement webEleServModelLabel;

    @FindBy(how = How.CSS, using = "[href='procurement.html']")
    public WebElement webEleLinkDoingBusiness;

    @FindBy(how = How.CSS, using = "[href='assets/forms/1_GCE_Supplier_Code_of_Conduct.pdf']")
    public WebElement webEleLinkSuppCodOfConduct;



}
