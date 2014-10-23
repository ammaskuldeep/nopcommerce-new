package page.consumer;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class ContactusPage extends abstractPage {

	
	
	public  boolean iscontactuspage() {

     //boolean c=sel.isTextPresent("Contact us");// TODO Auto-generated method stub
	//boolean c=	driver.findElement(By.xpath("//div[@class='page-body']/form/fieldset/legend")).getText().matches("Contact Us");
  	 
		boolean c=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText().matches("Contact Us");
		
    // String c =driver.findElement(By.xpath("//div[@class='page-body']/form/fieldset/legend")).isDisplayed();
        return c;
    }
	

	public String iscontactus()
    {
    
		 //String c=sel.getTitle();
		String c=driver.getTitle();
        return c;
    
   
    }

}

