package com.LMS.genericUtils;

import com.LMS.StepDef.GenericStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.LMS.base.BaseClass.getDriver;


public class WebElementUtils {

    private static Logger logger=  LogManager.getLogger(WebElementUtils.class);

    public static boolean isElementDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

    public static boolean isElementEnabled( WebElement webElement){
        return webElement.isEnabled();
    }

    public static  void loadPage(String url){
        Reporter.log("# To load fresh page, deleting cookies and refreshing page...", true);

        getDriver().manage().deleteAllCookies();
        getDriver().navigate().refresh();
        getDriver().get(url);
        waitTillPageLoad(10);
        Utilities.sleep(5);
        logger.info("URL loaded successfully");
    }

    public static void selectByText(WebElement element, String text) {
        try {
            Select selectElement = new Select(element);
            //scrollToView(getDriver(),element);
            selectElement.selectByVisibleText(text);
            Reporter.log("# Value: " + text + " was selected successfully for element", true);
        } catch(StaleElementReferenceException e){
            Select selectElement = new Select(element);
            selectElement.selectByVisibleText(text);

        }

        catch (Exception e1) {
            e1.printStackTrace();
            logger.error(e1.getMessage());
        }
    }

    public static void pressEnter(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static JavascriptExecutor getJavaExecutor(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor;
    }

    public static void highlighterMethod(WebDriver driver,WebElement element){
        getJavaExecutor(driver).executeScript("arguments[0].style.border='2px solid red'", element);
    }


    public static void scrollToView(WebDriver driver,WebElement element){
        getJavaExecutor(driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickElement(WebElement element){
        element.click();
        Reporter.log("# Element clicked..",true);
    }

    public static void mouseHover(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        actions.moveByOffset(1, 1).build().perform();
    }

    public static void waitForAnElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void switchToParentWindow() {
        getDriver().switchTo().defaultContent();
    }

    public static void waitTillPageLoad(int timeinSec) {
        getDriver().manage().timeouts().pageLoadTimeout(timeinSec, TimeUnit.SECONDS);
    }

    public static void switchToNewWindow() {
        Set s = getDriver().getWindowHandles();
        Iterator itr = s.iterator();
        String w1 = (String) itr.next();
        String w2 = (String) itr.next();
        getDriver().switchTo().window(w2);
    }

    public static void switchToOldWindow() {
        Set s = getDriver().getWindowHandles();
        Iterator itr = s.iterator();
        String w1 = (String) itr.next();
        String w2 = (String) itr.next();
        getDriver().switchTo().window(w1);
    }



}
