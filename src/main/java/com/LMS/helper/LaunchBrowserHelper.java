package com.LMS.helper;

import com.LMS.base.BaseClass;
import com.LMS.genericUtils.Utilities;
import com.LMS.genericUtils.WebElementUtils;


public class LaunchBrowserHelper {


    public void loadLoginPage() {
        WebElementUtils.loadPage(BaseClass.envProp.getProperty("gcuurl"));
    }

   /* public boolean validateHomePage() {
        boolean isTextPresent = false;
        objLaunchHomePage = new LaunchHomePage(BaseClass.getDriver());
        isTextPresent = WebElementUtils.isElementDisplayed(objLaunchHomePage.weGCUText);
        WebElementUtils.highlighterMethod(BaseClass.getDriver(), objLaunchHomePage.weGCUText);
        return isTextPresent;
    }*/

/*
    public boolean validateSubMenusDGPrg() {
        boolean isPresent = false;
        String value = "psychology & counseling";
        objLaunchHomePage = new LaunchHomePage(BaseClass.getDriver());
        WebElementUtils.mouseHover(BaseClass.getDriver(), objLaunchHomePage.weDGPrgHeader);
        WebElementUtils.waitForAnElement(BaseClass.getDriver(), BaseClass.getDriver().findElement(objLaunchHomePage.getWeSubMenuLabelXpath(value)));
        isPresent = WebElementUtils.isElementDisplayed(getDriver().findElement(objLaunchHomePage.getWeSubMenuLabelXpath(value)));
        WebElementUtils.highlighterMethod(getDriver(), getDriver().findElement(objLaunchHomePage.getWeSubMenuLabelXpath(value)));
        return isPresent;

    }*/

/*    public boolean validateSubMenusDGPrg(String value) {
        boolean isPresent = false;
        objLaunchHomePage = new LaunchHomePage(getDriver());
        WebElementUtils.waitTillPageLoad(60);
        WebElementUtils.mouseHover(getDriver(), objLaunchHomePage.weDGPrgHeader);
        WebElementUtils.waitForAnElement(getDriver(), getDriver().findElement(objLaunchHomePage.getWeSubMenuLabelXpath(value)));
        isPresent = WebElementUtils.isElementDisplayed(getDriver().findElement(objLaunchHomePage.getWeSubMenuLabelXpath(value)));
        return isPresent;

    }*/

    /*
    Navigates to Student Login Page

    */
 /*   public void navigateToGCULogin() {
        objStudentLoginPage = new StudentLoginPage(getDriver());
        WebElementUtils.clickElement(objStudentLoginPage.weGCULogin);
        Utilities.sleep(10);
        WebElementUtils.switchToNewWindow();
        //Utilities.sleep(60); // uncomment while exec with Safari
        WebElementUtils.waitTillPageLoad(120);
        WebElementUtils.waitForAnElement(getDriver(), objStudentLoginPage.weStudentAccess);
        WebElementUtils.clickElement(objStudentLoginPage.weStudentAccess);
        Utilities.sleep(5);


    }*/


}
