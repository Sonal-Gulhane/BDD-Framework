package com.LMS.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

import static com.LMS.base.Constants.*;


public class GetScreenshot {


    public static String captureFailed(String testclassName, String screenShotName, WebDriver driver) throws IOException {
        String destPath = "";

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        destPath = OUTPUT_DIR + TEST_SCREENSHOT_DIR + File.separator + "failedScreenshot" + File.separator + testclassName + File.separator + screenShotName + ".png";
        //File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenShotName + ".png");

        File destination = new File(destPath);
        FileUtils.copyFile(source, destination);
        return destPath;
    }

    public static String capturePassed(String testclassName, String screenShotName, WebDriver driver) throws IOException {
        String destPath = "";


        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        destPath = OUTPUT_DIR + TEST_SCREENSHOT_DIR + File.separator + "passedScreenshot" + File.separator + testclassName + File.separator + screenShotName + ".png";

        /*Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File(destPath));
*/

        //Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS).save(destPath);

        File destination = new File(destPath);

        FileUtils.copyFile(source, destination);
        return destPath;


    }
}
