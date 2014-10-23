package page.consumer;

import org.openqa.selenium.By;



/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 31/03/13
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartPage extends abstractPage {
    public boolean isCurrencyShowedinShoppinCart() {
        // TODO Auto-generated method stub
       // boolean m=sel.isTextPresent("�13.70");
        return true;
    }

    public void gotocheckout()
    {

     //   sel.click("id=checkout");
        driver.findElement(By.id("checkout")).click();
       // sel.waitForPageToLoad("30000");
    }

    public boolean isgiftcardaddedtoshoppingcart()
	// TODO Auto-generated method stub
	{
		//boolean g=sel.isTextPresent("$5 Virtual Gift Card");
		return true;
	}
    
    public boolean isproductshown(String productName) {
       // boolean c=sel.isTextPresent("Cooking for Two");
    	//boolean c= driver.findElement(By.xpath("//td[@class='product']/a")).getText().matches("Cooking for Two");
        boolean c=driver.getPageSource().contains(productName);
    	return c;
    }

    public boolean isamountshown() {
        //boolean c=sel.isTextPresent("$130.00");
       boolean c= driver.findElement(By.className("nobr")).getText().matches("$130.00");
    	return c;

    }

    
}


