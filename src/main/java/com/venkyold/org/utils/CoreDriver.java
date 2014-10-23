package com.venkyold.org.utils;

import com.venkyold.org.abstractTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: GBY9AMA9
 * Date: 16/03/13
 * Time: 00:54
 * To change this template use File | Settings | File Templates.
 */
public class CoreDriver {

    private static Logger LOGGER = Logger.getLogger(com.venkyold.org.utils.CoreDriver.class);

    public static WebDriver getCurrentDriver() {
        return abstractTest.getDriver();
    }

    public static void clickOnLink(String linkText) {
        LOGGER.info("Clicking on link with text " + linkText);
        getCurrentDriver().findElement(By.linkText(linkText)).click();
    }
}
