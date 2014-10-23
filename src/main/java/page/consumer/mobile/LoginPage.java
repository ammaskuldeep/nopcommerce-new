package page.consumer.mobile;

import com.venky.utils.CommonUtil;
import com.venky.utils.abstractPage;
import org.openqa.selenium.By;
import page.consumer.HomePage;
import page.consumer.RegisterPage;

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
        //sel.waitForPageToLoad("30000");
    }
    public void login(String email, String password)
    {
        //sel.type("id=Email", email);
    	driver.findElement(By.id("Email")).sendKeys(email);
        //sel.type("id=Password",password);
        driver.findElement(By.id("Password")).sendKeys(password);
        //sel.click("xpath=//input[@value='Log in']");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
       // sel.waitForPageToLoad("30000");
        if(!IsconsumerLoggedin(email))
        {
            (new page.consumer.HomePage()).goToRegister();
          
            (new RegisterPage()).register(email,password,"test","test");
            
            logout();
            (new HomePage()).goToLogin();
            login(email,password);
        }
    }
    public boolean IsconsumerLoggedin(String email) {
       // boolean b=sel.isTextPresent(email);
//        boolean b=!CommonUtil.isElementPresent(By.cssSelector("div.validation-summary-errors")).getText().matches(email);
//        if(b)
            boolean b = driver.findElement(By.xpath("//div[@id='mainpage']/div[2]/div/ul/li/a/span/span")).getText().matches(email);
    	return b;

    }
}
