package page.consumer;


import com.venkyold.org.abstractTest;
import com.venkyold.org.adv.utils.CommonUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.venkyold.org.utils.SystemLibrary;
import com.venkyold.org.utils.WaitUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 30/03/13
 * Time: 00:45
 * To change this template use File | Settings | File Templates.
 */
public class CheckOut extends abstractPage {
    private Logger LOGGER = Logger.getLogger(this.getClass());
    public void fillAddressForm() {
        LOGGER.info("Entering the default shipping details");
        driver.findElement(By.id("BillingNewAddress_FirstName")).clear();
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("First");
        driver.findElement(By.id("BillingNewAddress_LastName")).clear();
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Last");
        driver.findElement(By.id("BillingNewAddress_Email")).clear();
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("test@example.com");
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("United States");
        driver.findElement(By.id("BillingNewAddress_City")).clear();
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Newyork");
        driver.findElement(By.id("BillingNewAddress_Address1")).clear();
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("line");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).clear();
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12456");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).clear();
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("012345678");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public void confirmShippingAddress() {
        driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
        CommonUtil.waitFor(3000);
        driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
    }


    public enum paymentMethods{


        CASH("Cash On Delivery (COD)","paymentmethod_0"),
        MONEYORDER("Check / Money Order","paymentmethod_1"),
        CREDITCARD("Credit Card","paymentmethod_2"),
        PURCHASE_ORDER("Purchase Order","paymentmethod_3");

        private String text;

        private String id;
        private paymentMethods(String text,String id)
        {
            this.id = id;
        }

        private String getText()
        {
            return text;
        }
        private String getid()
        {
            return id;
        }

    }
    public void confirmPaymentWithMethod(String paymentMethod)
    {

        switch (paymentMethods.valueOf(paymentMethod))
        {
            case  CASH:
                selectPayWith(paymentMethods.CASH.getid());
                driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
                break;
            case  MONEYORDER:
                selectPayWith(paymentMethods.CASH.getid());
                driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
                break;
            case  CREDITCARD:
                selectPayWith(paymentMethods.CASH.getid());
                enterCardDetails();
                break;
            case  PURCHASE_ORDER:
                selectPayWith(paymentMethods.CASH.getid());
                payWithPurchaseOrder();
                break;
            default:


        }
    }


    private void selectPayWith(String getid) {
        driver.findElement(By.id(getid)).click();
        driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
        CommonUtil.waitFor(5);
    }
    private void payWithPurchaseOrder() {
         driver.findElement(By.id("PurchaseOrderNumber")).sendKeys(abstractTest.PROPERTIES.getProperty("PONUMBER"));
        driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
    }


    private void payWithMoneyOrder() {

    }

    private void payWithCreditCard() {

    }

    public void payWithCash(String id)
    {

    }


    public void enterCardDetails() {
        CommonUtil.waitFor(3000);
        driver.findElement(By.id("paymentmethod_2")).click();
        driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
        driver.findElement(By.id("CardholderName")).clear();
        driver.findElement(By.id("CardholderName")).sendKeys("sriram angajala");
        driver.findElement(By.id("CardNumber")).clear();
        driver.findElement(By.id("CardNumber")).sendKeys("4111111111111111");
        new Select(driver.findElement(By.id("ExpireMonth"))).selectByVisibleText("11");
        driver.findElement(By.id("CardCode")).clear();
        driver.findElement(By.id("CardCode")).sendKeys("1233");
        driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
    }

    public void confirmOrder() {
        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
    }

    public boolean isOrderProcessed(String text) {
        WaitUtils.waitForElement(By.className("order-completed"));
        return (new SystemLibrary()).isTextPresent(text);
    }
}
