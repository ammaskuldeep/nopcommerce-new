package com.venky.utils;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriverBackedSelenium;

@Deprecated
public class abstractPage extends com.venkyold.org.abstractPage
{

    public static Selenium sel;
    public CommonUtil util = new CommonUtil();

    public abstractPage()
    {
            //sel= new WebDriverBackedSelenium(driver,util.URL);
//                    CommonUtil.getSelenium();
 
    	 //sel=  util.getSelenium();
    	 
    }


}
