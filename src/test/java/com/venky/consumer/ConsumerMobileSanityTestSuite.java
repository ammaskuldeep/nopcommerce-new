package com.venky.consumer;

import com.venky.abstractTest;
import com.venky.utils.CommonUtil;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.venkyold.org.utils.REPORTER;
import page.consumer.mobile.HomePage;
import page.consumer.mobile.LoginPage;
import page.consumer.*;

public class ConsumerMobileSanityTestSuite extends abstractTest {

        String email = "roopa6@gmail.com";
        String password = "roopa1234";
        String First = "Roopa";
        String Last = "Reddy";
        private String currency = "Euro";
    @Test
    public void verifyUserCanRegister()
    {
        //goto register page
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.goToRegister();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(email,password,First,Last);
        REPORTER.isTrue(registerPage.isConsumerRegistered());
        LoginPage loginPage = new LoginPage();
        loginPage.logout();
        REPORTER.Log("logout");

    }
   

    //}
    String email13 = "venky@gmail.com";
    String password13 = "&*&*";
    String First3 = "Roopa";
    String Last3 = "Reddy";
 
    @Test
    public void verifyUserCanRegister3()
    {
        //goto register page
        HomePage homePage  =  new HomePage();
        homePage.goToRegister();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(email13,password13,First3,Last3);
        REPORTER.isTrue(!registerPage.isConsumerRegistered());
        LoginPage loginPage = new LoginPage();
        loginPage.logout();
     }

//        String email1 = "roopa5@gmail.com";
//        String password1 = "roopa1234";

    @Test
    public void verifyLogin()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.goToLogin();
        REPORTER.Log("goToLogin");
        //enter uername and password
        LoginPage loginPage = new LoginPage();
        loginPage.login(email,password);
        REPORTER.Log("login");
        //veirfy user has loogged in
        REPORTER.isTrue(loginPage.IsconsumerLoggedin(CommonUtil.getCurrentEmail()));
        loginPage.logout();
        REPORTER.Log("logout");
    }
    @Ignore
    @Test
    public void verifySearchForValidProduct()
    {
        //search for products
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.searchforvalidproduct("acer");
        REPORTER.Log("searchforvalidproduct");
        //verify products is shown in search results
        SearchPage searchPage  =  new SearchPage();
        REPORTER.isTrue(searchPage.isProductShown("acer"));
    }


     //  @AfterTest
    public void logOut()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.logout();
    }




    @Test
    public void verifyUserCanAddanItemIntoBasket() throws Exception
    {

        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //go to category
        homePage.gotobooks();
        REPORTER.Log("gotobooks");
        ProductPage productPage  =  new ProductPage();
        //select a product
        productPage.gotoproduct();
        REPORTER.Log("gotoproduct");
        //add item to cart
        productPage.additemtobasket();
        REPORTER.Log("additemtobasket");
        //goto shopping cart
        productPage.gotoshoppingcart();
        REPORTER.Log("gotoshoppingcart");
        ShoppingCartPage shoppingcartPage=new  ShoppingCartPage();
        //verify product is shown in the basket
        REPORTER.isTrue(shoppingcartPage.isproductshown("Cooking for Two"));

    }

    @Test
    public void verifycontactus()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.gotocontactus();
        REPORTER.Log("gotocontactus");
        ContactusPage contactusPage  =  new ContactusPage();

        REPORTER.isTrue(contactusPage.iscontactuspage());


    }



    @Test

    public void verifyLogolink()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.gotocontactus();
        REPORTER.Log("gotocontactus");
        ContactusPage contactusPage  =  new ContactusPage();
        String a =contactusPage.iscontactus();
        REPORTER.equals("nopCommerce demo store. Contact Us", a);
        homePage.gotoHomepage();
        String b =homePage.ishomepage();
        REPORTER.equals("nopCommerce demo store", b);
    }

    @Test
    public void verifyCheckout() throws Exception
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        // go to new products
        homePage.gotNewProducts();
        REPORTER.Log("gotoNewProducts");
        //go to categories
        homePage.gotoCategories("Jewelry");
        REPORTER.Log("gotoCategories");
        ProductPage productPage  =  new ProductPage();
        // select a product
        productPage.gotoproduct("Black & White Diamond Heart");
        REPORTER.Log("gotoprodct");
        //add to basket
        productPage.addtobasket();
        REPORTER.Log("addtobasket");
        // go to shopping cart
        productPage.gotoshoppingcart();
        REPORTER.Log("gotoshoppingcart");
        ShoppingCartPage  shoppingcartPage=new  ShoppingCartPage();
        // goto checkout
        shoppingcartPage.gotocheckout();
        REPORTER.Log("gotocheckout");
        //isverif
        REPORTER.isTrue(shoppingcartPage.isamountshown());
    }


    @Test
    public void myaccount(){


        //go to my account
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.goToLogin();
        REPORTER.Log("goToLogin");
        //enter login details
        LoginPage loginPage = new LoginPage();
        loginPage.login(email,password);
        REPORTER.Log("login");
        CustomerInfoPage customerinfoPage  =  new CustomerInfoPage();
        customerinfoPage.gotomyaccount();
        //verify for customer information
        REPORTER.isTrue(customerinfoPage.istextpresent());
        loginPage.logout();
        REPORTER.Log("logout");

    }
    @Test
    public void verifyusercanadditemtowishlist()
    {

        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //select category for wish list
        homePage.selectcategoryforwishlist();
        REPORTER.Log("selectcategoryforwishlist");
        //verify page is displayed with items
        //boolean a= con.iscategoryshownforwishlist();
        //Assert.assertTrue(a);
        //select an item in the category for wish list
        ProductPage productPage  =  new ProductPage();
        productPage.selectitemforwishlist();
        REPORTER.Log("selectitemforwishlist");
        //add an item to wish list
        productPage.additemtowishlist();
        REPORTER.Log("additemtowishlist");
        //go to wish list
        WishListPage wishlistPage=new WishListPage();
        wishlistPage.gotowishlist();
        REPORTER.Log("gotowishlist");
        //verify item is added in the wish list
        REPORTER.isTrue(wishlistPage.verifyitemaddedtowishlist());
    }



    @Test
    public void newproduct()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //go to new products
        homePage.gotoNewproducts();
        REPORTER.Log("gotoNewproducts");
        // go to categories
        ProductPage productPage =new ProductPage();
        productPage.selectproduct("Computers");
        REPORTER.Log("selectproduc");
        //select a category
        productPage.selectproduct("Desktops");
        REPORTER.Log("selectprodu");
        //Select a product
        productPage.selectproduct("Build your own computer");
        REPORTER.Log("selectprod");
        //verify for product
        REPORTER.isTrue(productPage.isproductshow());
    }

    @Test

    public void recentlyViewedProducts()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //go to recently viewed products
        homePage.gotoRecentlyviewedproducts();
        REPORTER.Log("goRecentlyviewedproducts");
        // verify for product shown
        ProductPage productPage  =  new ProductPage();
        REPORTER.isTrue(productPage.isproductshow1());


    }




    @Test
    public void verifySitemap()
    {
        HomePage homePage  =  new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //goto site map
        homePage.gotositemap();
        REPORTER.Log("gotositemap");
        //verify sitemap
        InformationPage informationPage  =  new InformationPage();
        REPORTER.isTrue(informationPage.isSiteMapPageOpen());


    }



    @Test
    public void VerifycompareList()
    {

        HomePage homePage  =  new HomePage();
       
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //go to new products
        homePage.gotNewProducts();
        REPORTER.Log("gotoNewProducts");

        //select the item
        ProductPage productPage  =  new ProductPage();
        productPage.selectproduct("The Battle Of Los Angeles");
        REPORTER.Log("selectproduct");
        //add to compare list
        productPage.addToCompareList();
        REPORTER.Log("addToCompareList");
        homePage.gotNewProducts();
        REPORTER.Log("gotoNewProducts");
        productPage.selectproduct("Single Ladies (Put A Ring On It)");
        REPORTER.Log("selectproduct");
        REPORTER.isTrue(productPage.isItemsAdded("The Battle Of Los Angeles", "Single Ladies (Put A Ring On It)"));

    }
    @Test

    public void communitypole(){
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.consumerpole();
        REPORTER.Log("consumerpole");
        boolean vote = homePage.verifypolling();
        Assert.assertFalse(vote);
        // REPORTER.isTrue(homePage.verifypolling());
        homePage.goToRegister();
        REPORTER.Log("goToregister");
        RegisterPage registerPage = new RegisterPage();
        registerPage.register( email, password, First, Last);
        REPORTER.Log("register");
        REPORTER.isTrue(registerPage.isConsumerRegistered());
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        homePage.consumerpole();
        REPORTER.Log("consumerpole");
        REPORTER.isTrue(homePage.verifypolling());
        LoginPage loginPage = new LoginPage();
        loginPage.logout();
        REPORTER.Log("logout");

    }
    String Email2="selenium1abc@gmail.com";
    @Test
    public void newsletter()
    {
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //subscribe for news letter
        homePage.newsletter(Email2);
        REPORTER.Log("newsletter");
        //check if subscribed

        InformationPage informationPage=new InformationPage();
        REPORTER.isTrue(informationPage.issubscribedfornewsletter());


    }




    String email1 = "roopa5@gmail.com";
    String password1 = "roopa1234";
    String RecipientsName="selenium1";
    String RecipientsEmail="selenium1abc@gmail.com";
    String YourName="siri";
    String YourEmail="selenium2abc@gmail.com";
    String Message="hi";
    @Test
    public void giftcard()
    {
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //go to gift card
        homePage.giftcard();
        REPORTER.Log("giftcard");
        ProductPage productPage=new ProductPage();
        //add recipients details
        productPage.addrecepientsname(RecipientsName,  YourName,  Message);
        REPORTER.Log("addrecepientsname");
        //add to cart
        productPage.additemtocart();
        REPORTER.Log("additemtocart");
        //verify gift card added to shopping cart
        ShoppingCartPage shoppingcartPage=new ShoppingCartPage();
        REPORTER.isTrue(shoppingcartPage.isgiftcardaddedtoshoppingcart());

    }





    @Test
    public void ShippingandReturns()
    {
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        // select shipping & Returns
        homePage.gotoshippingandreturns();
        REPORTER.Log("gotoshippingandreturns");
        InformationPage   informationPage=new   InformationPage();
        //verify text present
        REPORTER.isTrue(informationPage.isverifyShippingreturns());
    }


    @Test
    public void Privacynotice()
    {
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        //select Privacy Notice
        homePage.gotoPrivacynotice();
        REPORTER.Log("gotoPrivecynotice");
        InformationPage   informationPage=new   InformationPage();
        // verify text present
        REPORTER.isTrue(informationPage.isverifyprivacypolicy());
    }


    @Test
    public void ConditionsOfUse()
    {
        HomePage homePage = new HomePage();
        homePage.gotoHomepage();
        REPORTER.Log("gotoHomepage");
        // select conditions of use
        homePage.gotoconditionsofuse();
        REPORTER.Log("gotoconditionsofuse");
        InformationPage   informationPage=new   InformationPage();
        // verify text present
        REPORTER.isTrue(informationPage.isverifyconditionsofuse());

    }



    /**        @Test
    //    public void verifycurrencychangingto()
    //       {
    //           //goto homepage
    //           con.gotoHomepage();
    //          REPORTER.Log("goToHomepage");
    //       con.changecurrency(currency);
    //      con.selectDefaultProduct();
    //       REPORTER.Log("selectDefaultProdut");
    //     //gotoAddtocart
    con.gotoaddCart();
    REPORTER.Log("gotoaddCart");
    boolean k=con.isCurrencyShowedinEuro();
    REPORTER.Log("isCurrencyShowedinEuro");
    REPORTER.isTrue(k);
    con.gotoshoppingCart();
    REPORTER.Log("gotoshoppingCart");
    boolean m=con.isCurrencyShowedinShoppinCart();
    REPORTER.Log("isCurrencyShowedinShoppinCart");
    REPORTER.isTrue(m);
    junit.framework.Assert.assertTrue(m);

    }

     */



    //
//    public void verifyForgotPassword()
//    {
//        HomePage homePage = new HomePage();
//        homePage.goToRegister();
//        Register register = new Register();
//        register.register(email, password, First, Last);
//        con.logout();
//        con.goToLogin();
//        con.forgotpassword();
//
//        REPORTER.Log("invalid email");
//        con.passwordrecoverywith("1234");
//        REPORTER.isTrue(!con.isPasswordRecoverSuccess());
//        REPORTER.Log("wrong email");
//        con.passwordrecoverywith("test@test.com");
//        REPORTER.isTrue(!con.isPasswordRecoverSuccess());
//        REPORTER.Log("Correct email");
//        con.passwordrecoverywith(CommonUtil.getCurrentEmail());
//        REPORTER.isTrue(con.isPasswordRecoverSuccess());
//    }
//

//    @Test
//    public void verifywheteherconsumercanwriteownreview()
//    {
//        //  go to homepage
//        con.gotoHomepage();
//        // click on etnies men's digit sneaker
//        con.selectDefaultProduct();
//        //  click on be the first to be review
//        con.gotobethefirsttobereview();
//
//        boolean f = con.isUserCanWriteReview();
//        junit.framework.Assert.assertFalse(f);
//
//
//        // goto home page
//        con.gotoHomepage();
//
//        // login user details
//        con.goToLogin();

    // enter details
//        con.login(email,password);
//
//        // click on etnies men's digit sneaker
//
//        con.selectDefaultProduct();
//        //  click on be the first to be review
//        con.gotobethefirsttobereview();
//
//        boolean g = con.isUserCanWriteReview();
//        junit.framework.Assert.assertTrue(g);
//
//    }


}
