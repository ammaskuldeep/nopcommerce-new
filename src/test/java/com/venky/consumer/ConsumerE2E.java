package com.venky.consumer;

import com.venkyold.org.abstractTest;
import org.openqa.grid.internal.listeners.RegistrationListener;
import org.testng.annotations.Test;
import page.consumer.*;

import java.util.HashMap;

/**
, * User: dev
 * Date: 06/04/13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerE2E extends abstractTest
{
    @Test//(dataProvider = "test")
     public void multipleCheckOut()//HashMap<String,String> hashMap)
     {
         HomePage homePage  =  new HomePage();
         homePage.gotoHomepage();
         ProductPage productPage  =  new ProductPage();
         //select a product
         productPage.gotoproduct("HP Pavilion Artist Edition DV2890NR 14.1-inch Laptop");
         //add item to cart
         productPage.additemtobasket();
         //goto shopping cart
         productPage.gotoshoppingcart();
         ShoppingCartPage shoppingcartPage=new  ShoppingCartPage();
         //verify product is shown in the basket
         com.venky.utils.Reporter.ReportAssertCondition(shoppingcartPage.isproductshown("etnies Men's Digit Sneaker"));
         homePage.gotoHomepage();
         homePage.gotNewProducts();
         productPage.gotoproduct("The Battle Of Los Angeles");
         productPage.additemtobasket();
         productPage.gotoshoppingcart();
         com.venky.utils.Reporter.ReportAssertCondition(shoppingcartPage.isproductshown("etnies Men's Digit Sneaker"));
         com.venky.utils.Reporter.ReportAssertCondition(shoppingcartPage.isproductshown("The Battle Of Los Angeles"));
     }
   @Test
    public void completeOrderTest()
    {
        HomePage homePage = new HomePage();
//        homePage.addDefaultItem();
        ProductPage productPage = new ProductPage();
//        productPage.additemtobasket();
        productPage.gotoproduct("HP Pavilion Artist Edition DV2890NR 14.1-inch Laptop");
        //add item to cart
        productPage.additemtobasket();
        productPage.gotoshoppingcart();
        ShoppingCartPage shoppingcartPage=new  ShoppingCartPage();
        shoppingcartPage.gotocheckout();
        RegisterPage registration = new RegisterPage();
        registration.skipActivation();
        CheckOut checkedOut =  new CheckOut();
        checkedOut.fillAddressForm();
        checkedOut.confirmShippingAddress();
        checkedOut.enterCardDetails();
        checkedOut.confirmOrder() ;
        com.venky.utils.Reporter.ReportAssertCondition(checkedOut.isOrderProcessed("Your order has been successfully processed"));

    }
}
