


import com.venkyold.org.abstractTest;
import org.openqa.selenium.WebDriver;
import com.venkyold.org.utils.SystemLibrary;

public class abstractPage {

    public static WebDriver driver = abstractTest.getDriver();

    protected SystemLibrary sl = new SystemLibrary();

    public abstractPage() {
        driver = abstractTest.getDriver();
        
    }


}
