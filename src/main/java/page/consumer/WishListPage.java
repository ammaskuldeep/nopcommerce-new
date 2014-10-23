package page.consumer;

import org.openqa.selenium.By;



public class WishListPage  extends abstractPage
{
	
	public void gotowishlist()
	{
		  //sel.click("link=Wishlist");
		//  driver.findElement(By.("Wishlist")).click();
		
		 driver.findElement(By.linkText("wishlist")).click();
		 
		  //sel.waitForPageToLoad("30000")
		  
	}
	public boolean verifyitemaddedtowishlist()
	{
		  //boolean s= sel.isTextPresent("Black & White Diamond Heart");
		boolean s=driver.findElement(By.xpath("//a[@href='/black-white-diamond-heart']")).getText().contains("Black & White Diamond Heart");
		return s;
		  
	}  


}
