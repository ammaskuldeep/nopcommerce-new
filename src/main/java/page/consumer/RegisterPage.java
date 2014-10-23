package page.consumer;

import com.venky.utils.CommonUtil;



import org.openqa.selenium.By;
import static com.venkyold.org.abstractTest.PROPERTIES;


/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 31/03/13
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class RegisterPage extends abstractPage
{
    public void register(String email, String password,
                            String first, String last) {
       // sel.type("id=Email", util.getNewEmail());
    	CommonUtil.generteEmail();
        driver.findElement(By.id("Email")).sendKeys(CommonUtil.getCurrentEmail());
        //sel.type("id=Password", password);
        driver.findElement(By.id("Password")).sendKeys(password);
        
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        //sel.type("id=FirstName", first);
        driver.findElement(By.id("FirstName")).sendKeys(first);
        //sel.type("id=LastName", last);
        driver.findElement(By.id("LastName")).sendKeys(last);
        //sel.click("id=register-button");
        driver.findElement(By.id("register-button")).click();
       // sel.waitForPageToLoad("30000");
}
    public boolean isConsumerRegistered() {
       // boolean a = sel.isTextPresent("Your registration completed");
       return CommonUtil.isElementPresent(By.linkText("Log out"));

    }

    public void skipActivation() {
        driver.findElement(By.xpath("//input[@value='Checkout as Guest']")).click();
    }

    public void register() {
        register(PROPERTIES.getProperty("Email"),PROPERTIES.getProperty("Password"),PROPERTIES.getProperty("First"),PROPERTIES.getProperty("Last"));
    }
}

