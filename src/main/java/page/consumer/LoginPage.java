package page.consumer;

import com.venky.utils.CommonUtil;

import org.openqa.selenium.By;




/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 31/03/13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends abstractPage
{
    public void logout()
    {
      //  sel.click("link=Log out");
        if(CommonUtil.isElementPresent(By.linkText("Log out")))
        driver.findElement(By.linkText("Log out")).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //sel.waitForPageToLoad("30000");
    }
    public void login(String email, String password, String first,String last )
    {
        //sel.type("id=Email", email);
    	driver.findElement(By.id("Email")).sendKeys(email);
        //sel.type("id=Password",password);
        driver.findElement(By.id("Password")).sendKeys(password);
        //sel.click("xpath=//input[@value='Log in']");
        driver.findElement(By.xpath("//div[@class='form-fields']/form/div[5]/input")).click();
       // sel.waitForPageToLoad("30000");
        if(!IsconsumerLoggedin())
        {
            (new HomePage()).goToRegister();
           
            (new RegisterPage()).register(email,password,first,last);
          //  email1 = CommonUtil.getRandomString()+"@email.com";
           // logout();
            //(new HomePage()).goToLogin();
           // login(email,password,first,last);
        }
    }
    public boolean IsconsumerLoggedin() {
       // boolean b=sel.isTextPresent(email);
        boolean b=CommonUtil.isElementPresent(By.linkText("Log out"));
    	return b;

    }
}
