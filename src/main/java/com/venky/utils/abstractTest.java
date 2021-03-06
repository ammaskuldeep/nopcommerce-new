package com.venky.utils;

import com.venky.utils.utils.BrowserFactory;
import com.venky.utils.utils.DataSheetUtil;
import com.venky.utils.utils.REPORTER;
import com.venky.utils.utils.SystemLibrary;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class abstractTest {
//    public static final Logger LOGGER  = Logger.getLogger("abstractTest.class");
    public static final boolean DebugSwitch = false;
    public static SystemLibrary sl;
    public static WebDriver driver;
    static String sheet;

    static DataSheetUtil dataUtil;
    public static String browser;
    public static Object getDriver;
    static SeleniumServer selSer;
    private static String BROWSER;
    private static String SERVERURL;
    static String propertiesFileName = "automation.properties";
    public static Properties PROPERTIES = loadProperties(propertiesFileName);;



    @BeforeClass
    public static void browserStart() throws Exception {
        REPORTER.startReporter();
//        startRemoteWebBrowser(PROPERTIES.getProperty("BROWSER"));
//        DesiredCapabilities capabilities= new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME,"firefox");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", Platform.WINDOWS);
        caps.setCapability("version", "31");
//        caps.setCapability("browserName", "")
//        2c259106-416c-4890-9e0a-9f09ccb96c74
        driver = new RemoteWebDriver(new URL("http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PROPERTIES.getProperty("URL"));
    }

    private static Properties loadProperties(String propertiesFileName2) {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(propertiesFileName2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void browserclose() {
        //bl.logout();
        driver.quit();
        REPORTER.closeReports();
        SystemLibrary.waitFor(3);
        String file = "target\\qa-logs\\SampleTest_Results.XML";
//        MailReporter mailSender=new MailReporter("jkumar12398@gmail.com","Selenium Webdriver Execution Report","Hi this is a test mail",file);
        // Disconnect the Server
//       LOGGER.info("I am Closing the Server............");
//        try {
//          //  Runtime.getRuntime().exec("taskkill /im firefox.exe");
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }


    }
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        REPORTER.setIteration((m.getName()));
    }


    //@AfterMethod
    public void afterMethod(ITestResult result) {
        sl.captureScreen(result.getMethod().getMethodName());
//       LOGGER.info("I am in after method");
        driver.quit();
        driver = null;
        selSer.stop();
        sl = null;
    }

    @DataProvider(name = "test1")
    public Object[][] loadDataSheet1() {
        dataUtil = new DataSheetUtil();
        return (HashMap[][]) dataUtil.getTestDataFromExcel(PROPERTIES.getProperty("fileName"), sheet);

    }

    @DataProvider(name = "test")
    public Object[][] loadDataSheet() {
        dataUtil = new DataSheetUtil();
        sheet = PROPERTIES.getProperty("SHEET");
        return (HashMap[][]) dataUtil.getTestDataFromExcel(PROPERTIES.getProperty("fileName"), sheet);

    }

    protected static void startRemoteWebBrowser(String browser) throws MalformedURLException {

        driver = BrowserFactory.getBrowser();
        driver.get(PROPERTIES.getProperty("URL"));
    }


    protected void startBrowser(String browser) {

        browser = browser;
        if (browser.equals("IEXPLORE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals("IEXPLORE")) {

            driver = new AndroidDriver();
        } else {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            driver = new FirefoxDriver(firefoxProfile);
        }
        driver.get(PROPERTIES.getProperty("URL"));
        sl = new SystemLibrary();

    }

    public void runStandAloneServer() {
        try {
            selSer = new SeleniumServer();
            selSer.start();
        } catch (Exception e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

