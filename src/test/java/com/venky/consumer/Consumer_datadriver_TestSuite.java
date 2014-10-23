package com.venky.consumer;

import java.util.HashMap;

import com.venky.utils.Reporter;
import org.testng.annotations.Test;

import page.consumer.*;


public class Consumer_datadriver_TestSuite extends abstractTest {
	
//	String email = "roopa6@gmail.com";
//    String password = "roopa1234";
//    String First = "Roopa";
//    String Last = "Reddy";\
    private String currency = "Euro";
@Test(dataProvider="test")
public void verifyUserCanRegister(HashMap<String,String> hashMap)
{
    String email =  hashMap.get("EMAIL") ;
    //goto register page
    HomePage homePage  =  new HomePage();
    homePage.goToRegister();
    RegisterPage registerPage = new RegisterPage();
    registerPage.register(hashMap.get("EMAIL"),hashMap.get("PASSWORD"),hashMap.get("FIRST"),hashMap.get("LAST"));
    if(hashMap.get("SUCCESS").equals("Y"))
    {
    	com.venky.utils.Reporter.ReportAssertCondition(registerPage.isConsumerRegistered());
    }
    else
    {
    	com.venky.utils.Reporter.ReportAssertCondition(!registerPage.isConsumerRegistered());
        return;
    }
    
    LoginPage loginPage = new LoginPage();
    loginPage.logout();
    com.venky.utils.Reporter.ReportInfo("logout");

}

    @Test(dataProvider = "test")
    public void verifyCompare(HashMap<String,String> hashMap)
    {
        HomePage homePage = new HomePage();
        homePage.gotNewProducts();
//        ProductPage productPage = new ProductPage();
        ProductPage productPage = new ProductPage();
        productPage.gotoproduct(hashMap.get("PRODUCT1"));
        productPage.addToCompareList();
        homePage.gotNewProducts();
        productPage.gotoproduct(hashMap.get("PRODUCT2"));
        productPage.addToCompareList();
        Reporter.ReportAssertCondition(productPage.isItemsAdded(hashMap.get("PRODUCT1"), hashMap.get("PRODUCT2")));

    }


    @Test(dataProvider = "test")
    public void paymentsTest(HashMap<String,String> hashMap)
    {
        ///login
        HomePage homePage =new HomePage();
        homePage.register();
        ///add item from category
        homePage.addProductFromCategory(hashMap.get("CATEGORY"),hashMap.get("PRODUCT"));
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.gotocheckout();
        CheckOut checkOut = new CheckOut();
        checkOut.fillAddressForm();
        checkOut.confirmShippingAddress();
        checkOut.confirmPaymentWithMethod("MONEYORDER");
        checkOut.confirmOrder();

    }


}
