package page.consumer;

import org.openqa.selenium.By;



public class SearchPage  extends abstractPage {

	
	
	// public boolean isProductShown() {
	       //boolean c=sel.isTextPresent("No products were found that matched your criteria.");
	    // boolean c=driver.findElement(By.xpath("//div[@class='search-results']/span")).getText().matches("No products were found that matched your criteria.");   
		
	    // return !c;

	  //  }

	 public boolean isProductShown(String productName) {
	       // boolean c=sel.isTextPresent("Cooking for Two");
	    	//boolean c= driver.findElement(By.xpath("//td[@class='product']/a")).getText().matches("Cooking for Two");
	        boolean c=driver.getPageSource().contains(productName);
	    	return c;
	    }
	 
	 
	 
}

