package page.consumer;

import com.venkyold.org.abstractTest;
import com.venkyold.org.utils.SystemLibrary;

import org.openqa.selenium.WebDriver;


public class abstractPage extends com.venkyold.org.abstractPage{

    public static WebDriver driver;// = abstractTest.getDriver();

    protected SystemLibrary sl = new SystemLibrary();

    public abstractPage() {
        driver = abstractTest.getDriver();
    }


}
