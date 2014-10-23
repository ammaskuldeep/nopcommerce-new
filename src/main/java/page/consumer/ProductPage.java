package page.consumer;

import com.venky.utils.CommonUtil;
import com.venkyold.org.adv.utils.CoreDriver;

import org.openqa.selenium.By;

public class ProductPage extends abstractPage
{

	 public void selectproduct(String product){
	       CommonUtil.clickByLink(product);
	 }

	 public boolean isproductshow() {
	        // TODO Auto-generated method stub
	        //boolean b = sel.isTextPresent("Build your own mylaptop");
	     boolean b=driver.findElement(By.xpath("//div[@class='overview']/h1")).getText().matches("Build your own mylaptop");   
		 return b ;
	    }
	 
	 
	 public void selectitemforwishlist()
	 {
	 	 //sel.click("link=Black & White Diamond Heart");
	 	 driver.findElement(By.linkText("Black & White Diamond Heart")).click();
	 	 //sel.waitForPageToLoad("30000");
	 	 
	 }
	 public void additemtowishlist()
	 {
	 	 // sel.click("xpath=//input[@value='Add to wishlist']");
	 	// driver.findElement(By.xpath("//input[@value='Add to wishlist']")).click();
	 	 
	 	 driver.findElement(By.xpath("//input[@value='Add to wishlist']")).click();
	 	 
		// util.pause();
	 	  
	 	  
	 }

	 
	 public void addToCompareList() {
	        //sel.click("xpath=//input[@value='Add to compare list']");
	   	 driver.findElement(By.xpath("//input[@value='Add to compare list']")).click();

	    }
	 public boolean isItemsAdded(String item1, String item2) {
	        return true;//sel.isTextPresent(item1) && sel.isTextPresent(item2);
	    }
	 
    public void addtobasket() {
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
      //  util.pause();
    }
	public String getTotalCost() {
		return null;
	}
    public void gotoaddCart() {
       driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        //sel.waitForPageToLoad("30000");
        //util.pause();
    }


    
    
    
    public void gotoproduct()
    {
 //       sel.click("link=Cooking for Two");
    	driver.findElement(By.linkText("ASUS Eee PC 900HA 8.9-Inch Netbook Black")).click();
    	//sel.waitForPageToLoad("30000");
    }

    
    public void gotoproduct(String product)
    {
           	driver.findElement(By.linkText(product)).click();
    
    }

    public void additemtobasket() {
       // CoreDriver.waitForElement(driver.findElement(By.xpath("//input[@value='Add to wishlist']")));
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        CommonUtil.WaitTillGreenIsShown();
    }

    public void gotoshoppingcart(){
        driver.navigate().to("http://demo.nopcommerce.com/cart");
       // driver.findElement(By.linkText("shopping cart")).click();
    }

    public void gotobethefirsttobereview() {
        //sel.click("link=Be the first to review this product");
    	driver.findElement(By.linkText("Be the first to review this product")).click();
   // 	sel.waitForPageToLoad("30000");
    }
    public void gotoshoppingCart(){
        //sel.click("link=shopping cart");
		//sel.click("xpath=//div[@class='header-links']/ul/li[3]/a");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li[3]/a")).click();
        //sel.waitForPageToLoad("30000");

    }
    public boolean isCurrencyShowedinEuro() {
        // TODO Auto-generated method stub
       // boolean k=sel.isTextPresent("�13.70");
        return true;
    }
    public boolean isCurrencyShowedinShoppinCart() {
        // TODO Auto-generated method stub
       // boolean m=sel.isTextPresent("�13.70");
        return true;
    }

    public boolean isproductshow1() {
    //    boolean a =sel.isTextPresent("Recently viewed products");
      boolean a=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText().matches("Recently viewed products");
    	return a;
    }

    public void addrecepientsname(String RecipientsName,String YourName,String Message)
  {
    	//sel.type("id=giftcard_1_RecipientName",RecipientsName);
    	driver.findElement(By.className("recipient-name")).sendKeys(RecipientsName);
    	//sel.type("id=giftcard_1_RecipientEmail",RecipientsEmail);
    	//driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys(RecipientsEmail);
    	//sel.type("id=giftcard_1_SenderName",YourName);
    	driver.findElement(By.className("sender-name")).sendKeys(YourName);
    //	sel.type("id=giftcard_1_SenderEmail",YourEmail);
    	//driver.findElement(By.id("giftcard_1_SenderEmail")).sendKeys(YourEmail);
    	//sel.type("id=giftcard_1_Message",Message);
    	driver.findElement(By.className("message")).sendKeys(Message);
    }
    
    
    public void additemtocart() {

    	driver.findElement(By.xpath("//input[@value='Add to cart']")).click();    
    	//util.pause();
    
    	
    }

    public void addToCard() {

    }

	
		
	}


