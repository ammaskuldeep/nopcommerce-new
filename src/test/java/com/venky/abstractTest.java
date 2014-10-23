package com.venky;


import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import com.venky.utils.CommonUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class abstractTest extends com.venkyold.org.abstractTest
{
    static CommonUtil util = new CommonUtil();
    public static Selenium sel;
//    @BeforeClass
//    public static void Up()
//    {
////       startAndOpenBrowser();
//       util.setSelenium(sel);
//    }

    @AfterClass
    public static void stopAndCloser()
    {
//        stopAndCloseBrowser();
    }

    public static void startAndOpenBrowser() {
//
//        sel = new DefaultSelenium(util.HOST,4444,util.BROWSER,util.URL);
//        sel.start();
//        sel.windowMaximize();
//        sel.open("/");
    }

    public static void stopAndCloseBrowser() {

        sel.close();
        sel.stop();
    }
}
