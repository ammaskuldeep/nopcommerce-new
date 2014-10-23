package page.consumer;

import org.openqa.selenium.By;



public class CustomerInfoPage extends abstractPage {

	
	
	 public void gotomyaccount() {

	        //sel.click("xpath=//div[@class='header-menu']/ul/li[4]/a");
	      driver.findElement(By.linkText("My account")).click();
	        //sel.waitForPageToLoad("30000");

	    }
	  public boolean istextpresent() {

	        //boolean d= sel.isTextPresent("My account - Customer info");
	      boolean d=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText().matches("My account - Customer info");  
		  return d;
	    }



	   
}
