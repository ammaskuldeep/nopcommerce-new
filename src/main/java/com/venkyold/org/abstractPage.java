package com.venkyold.org;


import com.venkyold.org.abstractTest;
import org.openqa.selenium.WebDriver;
import com.venkyold.org.utils.SystemLibrary;

public class abstractPage {

    public WebDriver driver;//= abstractTest.driver;

    protected SystemLibrary sl = new SystemLibrary();

    public abstractPage() {
        driver = abstractTest.getDriver();
    }


}
