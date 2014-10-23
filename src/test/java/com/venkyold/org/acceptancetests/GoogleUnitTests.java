package com.venkyold.org.acceptancetests;

import junit.framework.Assert;
import com.venkyold.org.abstractTest;
import com.venkyold.org.adv.utils.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.selenesedriver.TakeScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.testng.annotations.Test;
import com.venkyold.org.utils.MailReporter;
import com.venkyold.org.utils.REPORTER;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 06/04/13
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public class GoogleUnitTests extends abstractTest
{
//    WebDriver driver;
//    @Test //(dataProv ider = "test")
    public void googleTitle()
    {
        try
        {
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability("platform", "OS X 10.6");
        caps.setCapability("version", "");
//            caps.setBrowserName("Fire");
//            caps.setCapability("server","http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub");
//        driver = new RemoteWebDriver(new URL("http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub"),caps);
            driver = new BrowserFactory.ScreenShotRemoteWebDriver(new URL("http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub"),caps);
            driver.get("http://www.google.com");
        }
        catch (Exception e)
        {

        }

        WebDriver driver1 = new Augmenter().augment(driver);
        TakesScreenshot t = ((TakesScreenshot)driver1);
            File f =  t.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f,new File("C:\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        REPORTER.equals("Google", driver.getTitle());
    }

    @Test
    public void googleTitle1()
    {

        driver.get("http://www.google.com");
        REPORTER.equals("Google",driver.getTitle());
//        System.out.print("Data"+hashMap.get("BROWSER"));
    }

    public void mailUnitTest()
    {
//        MailReporter mailReporter =
    }

    @Test
    public void reportUnitTest()
    {
        REPORTER.equals("Test","Test1");
        REPORTER.isTrue(true);
        REPORTER.warning("Test Warning");
        REPORTER.Log("Test Log");
        REPORTER.pass("Test Pass");
        REPORTER.isTrue(true,"Test");
        REPORTER.equals(1,1,"Test");
        REPORTER.fail("Fail");
        try {
        REPORTER.failAndExit("Test Message");
    }
    catch (Exception e)
    {

    }
        try {
            REPORTER.equalsAndExit("Test","Test","");
            REPORTER.equalsAndExit("Test1","Test","");
        }
        catch (Exception e)
        {

        }
        try {
            REPORTER.isTrueAndExit(true,"Test Message");
            REPORTER.isTrueAndExit(false,"Test Message");
        }
        catch (Exception e)
        {

        }
        REPORTER.Exception("Exception");

    }


}
