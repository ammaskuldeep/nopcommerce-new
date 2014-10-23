package com.venkyold.org.adv.utils;

import com.thoughtworks.selenium.Selenium;
import com.venky.utils.CommonUtil;



public class abstractPage {

    public static Selenium sel;
    public CommonUtil util = new CommonUtil();

    public abstractPage()
    {
            sel=  CommonUtil.getSelenium();
    }


}
