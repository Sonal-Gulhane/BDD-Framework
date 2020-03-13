package com.LMS.base;



import com.LMS.StepDef.GenericStep;
import com.LMS.genericUtils.GenericException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.LMS.base.Constants.*;


public class BaseClass  {
    RemoteWebDriver driver;
    public static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
    private static ChromeDriverService service;
    public static Properties envProp;
    public static String parentwindowhandle;
    public   static String BrowserType;
    public static String platform;

    private static Logger logger=  LogManager.getLogger(BaseClass.class);


    public void executionFactory() {

        envProp = fileRead(PROPERTY_FILES);
        BaseClass.BrowserType=envProp.getProperty("BrowserType");

        BaseClass.platform=envProp.getProperty("platform");
        if (platform.equalsIgnoreCase("local")) {
            browserSetup(BrowserType);

        } else if (platform.equalsIgnoreCase("saucelabs")) {
            browserSetupSauceLabs(BrowserType);
        }
        logger.info("Launched browser.");

    }

  /*  @Parameters({"BrowserType", "platform"})
    public void executionFactory(String BrowserType, String platform) {
        BaseClass.browsername=BrowserType;
        BaseClass.platformname=platform;
        envProp = fileRead(PROPERTY_FILES);
        if (platform.equalsIgnoreCase("local")) {
            browserSetup(BrowserType);

        } else if (platform.equalsIgnoreCase("saucelabs")) {
            browserSetupSauceLabs(BrowserType);
        }

    }*/

    private void browserSetupSauceLabs(String browserType) {

        String USERNAME = envProp.getProperty("USERNAME");
        String ACCESS_KEY = envProp.getProperty("ACCESS_KEY");
        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
        DesiredCapabilities caps = null;
        Reporter.log("# Execution started on SauceLabs...BROWSER # " + browserType, true);
        if (browserType.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "78.0");

        } else if (browserType.equalsIgnoreCase("safari")) {
            caps = DesiredCapabilities.safari();
            caps.setCapability("platform", "macOS 10.12");
            caps.setCapability("version", "latest-1");

        }else if(browserType.equalsIgnoreCase("firefox")){
            caps = DesiredCapabilities.firefox();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "70.0");

        }

        caps.setCapability("extendedDebugging", "true");
        caps.setCapability("name", "Web Driver demo Test");


        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            throw new GenericException(e);
        }
        configureWebDriver();

    }

    private void browserSetup(String browserType) {
        Reporter.log("# Execution started on Local machine...BROWSER # " + browserType, true);
        if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
          /*  ChromeOptions options = new ChromeOptions();
            options.addArguments(CHROME_SWITCHES, CHROME_SWITCH_VALUE);
            Map<String, Object> prefs = new HashMap<>();
            prefs.put(CREDENTIAL_ENABLE_SERVICE, false);
            prefs.put(PROFILE_PW_MANAGER_ENABLED, false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);*/
          driver=new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();


        } else if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", DRIVER_PATH + "IEDriverServer32.exe");
            InternetExplorerOptions capabilities = new InternetExplorerOptions();
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            driver = new InternetExplorerDriver(capabilities);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Remote")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(CHROME_SWITCHES, CHROME_SWITCH_VALUE);
            Map<String, Object> prefs = new HashMap<>();
            prefs.put(CREDENTIAL_ENABLE_SERVICE, false);
            prefs.put(PROFILE_PW_MANAGER_ENABLED, false);
            prefs.put(PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS, 0);
            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            try {
                driver = new RemoteWebDriver(new URL("url:4444/wd/hub"), capabilities); // replace url with proper http value
            } catch (MalformedURLException e) {
                Reporter.log(e.getMessage(), true);
            }

            driver.setFileDetector(new LocalFileDetector());

        } else if (browserType.equalsIgnoreCase("local")) {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(DRIVER_PATH + "chromedriver_new.exe")).usingPort(4444)
                    .build();
            try {
                service.start();
            } catch (IOException e) {
                Reporter.log(e.getMessage(), true);
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments(CHROME_SWITCHES, "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
            Map<String, Object> prefs = new HashMap<>();
            prefs.put(CREDENTIAL_ENABLE_SERVICE, false);
            prefs.put(PROFILE_PW_MANAGER_ENABLED, false);
            prefs.put("profile.default_content_settings.popups", 0);
            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
            } catch (MalformedURLException e) {
                Reporter.log(e.getMessage(), true);
            }
            driver.setFileDetector(new LocalFileDetector());
        }

        configureWebDriver();

    }


    public void configureWebDriver() {
        setWebDriver(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        parentwindowhandle = getDriver().getWindowHandle();

    }




    public void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriverThreadLocal.set(driver);
    }

    public static RemoteWebDriver getDriver() {
        return remoteWebDriverThreadLocal.get();
    }

    //@After
    @Parameters("BrowserType")
    public static void closeBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("local")) {
            service.stop();
        } else if (browserType.equalsIgnoreCase("IE")) {
            try {
                Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
            } catch (IOException e) {
                throw new GenericException(e);
            }
        } else {
            getDriver().close();
            getDriver().quit();
        }

        Reporter.log("# Closing all browsers...",true);

    }

     @BeforeClass
    public static void loadProperties() {
        envProp = fileRead(PROPERTY_FILES);
    }

    /**
     * load any prop file
     *
     * @param path
     * @return
     */
    public static Properties fileRead(String path) {
        File file = new File(path);
        Properties properties = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new GenericException(e);
        }
        return properties;
    }

    /*
        creating output dir
     */
    @BeforeSuite
    public void createOutPutFolder() {
        File file = new File(OUTPUT_DIR);
        file.mkdirs();

    }

    /*
    skipping the test
     */
    public static void executionCheck(String execution) {
        if (execution.equalsIgnoreCase("N")) {
            Reporter.log("# Skipping the test", true);
            throw new SkipException("Skipping the test");
        }
    }


}
