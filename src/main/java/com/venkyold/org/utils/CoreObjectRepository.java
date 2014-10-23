package com.venkyold.org.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: GBY9AMA9
 * Date: 16/03/13
 * Time: 00:20
 * To change this template use File | Settings | File Templates.
 */
public class CoreObjectRepository {

    @FindBy(xpath = "//input[@value='Add to cart']")
    public WebElement addToCart;


}
