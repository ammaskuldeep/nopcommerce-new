package page.consumer;

import org.openqa.selenium.By;



public class InformationPage  extends abstractPage
{

	 public boolean isSiteMapPageOpen() {
	        //boolean a =sel.isTextPresent("Sitemap");
	        boolean a = driver.findElement(By.xpath("//div[@class='page-title']")).getText().matches("Sitemap");
	        return a;
	        

	      
	    }
	
	 public boolean issubscribedfornewsletter()
	 {
		   //boolean h=sel.isTextPresent("Thank you for signing up! A verification email has been sent. We appreciate your interest.");
		  boolean h = driver.findElement(By.id("newsletter-result-block")).getText().matches("Thank you for signing up! A verification email has been sent. We appreciate your interest.");
		   
		  
		   return h;
	 }


	 public boolean isverifyShippingreturns() {
			
			
			//boolean n=sel.isTextPresent("Shipping & Returns");
		  boolean h = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText().matches("Shipping & Returns");
		 return h;

	} 

	 public boolean isverifyprivacypolicy() {
			
	//		boolean n=sel.isTextPresent("Privacy policy");
		   boolean n = driver.findElement(By.xpath("//div[@class='page-title']")).getText().matches("Privacy policy");
		 return n;
		}


	 public boolean isverifyconditionsofuse() {
			
			//boolean n=sel.isTextPresent("Conditions of use");
			 boolean n = driver.findElement(By.xpath("//div[@class='page-title']")).getText().matches("Conditions of use");
			return n;
		}

}
