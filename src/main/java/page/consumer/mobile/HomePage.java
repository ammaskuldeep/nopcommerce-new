package page.consumer.mobile;

import com.venky.utils.CommonUtil;
import com.venky.utils.abstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.venkyold.org.utils.REPORTER;
import com.venkyold.org.utils.SystemLibrary;
import page.consumer.ProductPage;
import page.consumer.RegisterPage;

public class HomePage extends abstractPage
{


	public void addDefaultItem() {

            driver.findElement(By.xpath("(//input[@value='Add to cart'])[3]")).click();
            SystemLibrary.waitFor(5);

		
	}
	  public void changecurrency(String currency) {
	        //sel.select("customerCurrency","label="+currency);
	        (new Select(driver.findElement(By.id("customerCurrency")))).selectByVisibleText(currency);
	    }


	    public void consumerpole() {
	        //sel.click("id=pollanswers-2");
	    	driver.findElement(By.id("pollanswers-2")).click();
	    	//sel.click("id=vote-poll-1");
	    	driver.findElement(By.id("vote-poll-1")).click();
	    	//util.pause();
	    }
    public void gotNewProducts() {
        
  //  sel.click("link=New products");
    driver.findElement(By.linkText("New products")).click();
    //    sel.waitForPageToLoad("30000");
    }
    public void gotobooks() {
        //sel.click("link=Books");
    	driver.findElement(By.linkText("Books")).click();
      //  sel.waitForPageToLoad("30000");
    }
    public void gotoCategories(String category) {
       // sel.click("link="+category);
        driver.findElement(By.linkText("Jewelry")).click();
        
        //sel.waitForPageToLoad("30000");
    }

    public void gotocontactus() {
        // TODO Auto-generated method stub
        //sel.click("link=Contact us");
    	driver.findElement(By.linkText("Contact us")).click();
        //sel.waitForPageToLoad("30000");
    	util.pause();
    }

    public void gotoHomepage() {
        REPORTER.Log("I am going to Home Page");
        driver.findElement(By.xpath("//div[@id='mainpage']/div/a/span/span")).click();
    }
    public void goToLogin() {
        REPORTER.Log("I am going to Login Page");
        driver.findElement(By.xpath("//div[@id='mainpage']/div[2]/div/ul/li[2]/a/span")).click();

    }

    public void gotomyaccount() {

        
    	//sel.click("xpath=//div[@class='header-menu']/ul/li[4]/a");
    	driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[4]/a")).click();
    	
       // sel.waitForPageToLoad("30000");

    }
    public void gotoNewproducts() {
        // TODO Auto-generated method stub
        //sel.open("/");
        //sel.click("link=New products");
        driver.findElement(By.linkText("New products")).click();
        //sel.waitForPageToLoad("30000");

    }

    
    public void newsletter(String Email2)
    {
    	  //sel.type("id=newsletter-email",Email2);
    	  driver.findElement(By.id("newsletter-email")).sendKeys(Email2);
    	  
    	  
    	  //sel.click("id=newsletter-subscribe-button");
    	  driver.findElement(By.id("newsletter-subscribe-button")).click();
    	  //WebElement element =driver.findElement(By.id("newsletter-subscribe-button"));
    	  //element.click();
    	  //sel.waitForPageToLoad("30000");  
    	  util.pause();
    	  
    	  
    }
    public void selectcategoryforwishlist()

    {
    	//sel.click("link=jewelry");
    	driver.findElement(By.linkText("jewelry")).click();
    	//sel.waitForPageToLoad("30000");
    	
    }
    public void goToRegister() {

     //   sel.click("link=Register");
      driver.findElement(By.linkText("Register")).click();
       // sel.waitForPageToLoad("30000");
    }
    public void gotoshoppingCart(){
        //sel.click("link=shopping cart");
        driver.findElement(By.linkText("shopping cart")).click();
//		sel.click("xpath=//div[@class='header-links']/ul/li[3]/a");
        //sel.waitForPageToLoad("30000");

    }

    public void gotositemap() {
        //sel.open("/");
        //sel.click("link=Sitemap");
    	driver.findElement(By.linkText("Sitemap")).click();
        //sel.waitForPageToLoad("30000");
    }
    public void selectDefaultProduct()
    {
        selectproduct(defaultProduct);
    }
    public void selectproduct(String product) {
        // TODO Auto-generated method stub
        sel.click("link="+product);
        sel.waitForPageToLoad("30000");

    }
    public String ishomepage() {
       // String c=sel.getTitle() ;
    	String c=driver.getTitle();
        return c;

    }
    public static boolean verifypolling(){
        boolean verify= CommonUtil.isTextPresent("Good") && CommonUtil.isTextPresent("vote(s) - 100.0%)");

        return verify;
    }
    
    public void searchforvalidproduct(String string)
    {
        //sel.type("id=small-searchterms", string);
    	driver.findElement(By.id("small-searchterms")).sendKeys(string);
    	//sel.click("xpath=//input[@value='Search']");
    	driver.findElement(By.xpath("//input[@value='Search']")).click();
      //  sel.waitForPageToLoad("30000");
    }

    public void gotoRecentlyviewedproducts() {
        // TODO Auto-generated method stub
        //sel.click("link=Recently viewed products");
        driver.findElement(By.linkText("Recently viewed products")).click();
        //sel.waitForPageToLoad("30000");

    }

 
    
    
    
    public void gotoshippingandreturns() {
		//sel.click("xpath=//div[@class='listbox']/ul/li[8]/a");
	//	sel.click("link=Shipping & Returns");
    	driver.findElement(By.linkText("Shipping & Returns")).click();
		//sel.waitForPageToLoad("30000");
		
		// TODO Auto-generated method stub
		
	}


 
public void gotoPrivacynotice() {
	// TODO Auto-generated method stub
	//sel.click("xpath=//div[@class='listbox']/ul/li[10]/a");
	//sel.click("link=Privacy Notice");
	driver.findElement(By.linkText("Privacy Notice")).click();
	//sel.waitForPageToLoad("30000");
	
}



public void gotoconditionsofuse() {
	// TODO Auto-generated method stub
//	sel.click("link=Conditions of Use");
	driver.findElement(By.linkText("Conditions of Use")).click();
	//sel.waitForPageToLoad("30000");
}


public void giftcard()
{
	  //sel.click("link=Gift Cards");
	driver.findElement(By.linkText("Gift Cards")).click();  
	//sel.waitForPageToLoad("30000");
	  //sel.click("link=$5 Virtual Gift Card");
	driver.findElement(By.linkText("$5 Virtual Gift Card")).click();  
	//sel.waitForPageToLoad("30000");
	  
}
    
    private static final String defaultProduct = "etnies Men's Digit Sneaker";

    public void register() {
        goToRegister();
        (new RegisterPage()).register();
    }

    public void addProductFromCategory(String category, String product) {
        CommonUtil.clickByLink(category);
        CommonUtil.clickByLink(product);
        (new ProductPage()).addtobasket();
        (new ProductPage()).gotoshoppingcart();

    }
}
