package com.LMS.base;


import com.LMS.genericUtils.DateUtil;

import java.io.File;

public class Constants {
    public static final String USER_DIR = "user.dir";
    public static final String RESOURCE_PATH = System.getProperty(USER_DIR)+ File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator;
    public static final String PROPERTY_FILES = RESOURCE_PATH + "PropertiesFile" + File.separator +   System.getProperty("Environment");
    public static final String EMAIL_FILE_PATH = RESOURCE_PATH + "PropertiesFile" + File.separator +   "Email.properties";
    public static final String DATA_SHEET_PATH  = RESOURCE_PATH + "datasheets" + File.separator;
    public static final String DRIVER_PATH = RESOURCE_PATH + "driver" + File.separator;
    public static final String CHROME_SWITCHES = "chrome.switches";
    public static final String CHROME_SWITCH_VALUE = "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized";
    public static final String CREDENTIAL_ENABLE_SERVICE = "credentials_enable_service";
    public static final String PROFILE_PW_MANAGER_ENABLED = "profile.password_manager_enabled";
    public static final String PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS = "profile.default_content_settings.popups";
    public static final String DOWNLOAD_DEFAULT_DIRECTORY = "download.default_directory";
    public static final String DATETIMEFORMAT = "yyyyMMddHHmmss";
    public static final String TIMEFORMAT = "HHmmss";
    public static final String DATEFORMATWITH_HYPHEN = "MM-dd-yyyy";
    public static final String DATE_FORMAT_YYYY_MM_DD ="yyyy-MM-dd";
    public static final String TEST_SCREENSHOT_DIR = "Screenshot" ;

    public static final String OUTPUT_DIR = System.getProperty(USER_DIR) + File.separator + "test-output" + File.separator  + DateUtil.currentDate("yyyyMMdd") + File.separator;


}
