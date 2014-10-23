package com.venky.consumer;

import com.venky.abstractTest;
import com.venky.utils.CommonUtil;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.testng.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 04/09/2013
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
public class PracticeTestsWebDriver extends com.venkyold.org.abstractTest {

  //  static WebDriver driver ;//= new FirefoxDriver(new FirefoxProfile());

//    @BeforeClass
//    public static void setup()
//    {
//           driver = new SafariDriver();
//
//           driver.get("www.google.coms");
//    }

    @Test
    public void testCheckBox()
    {

        //sdriver.navigate().to("file://localhost/Users/sriramangajala/Documents/Automation/svn/pom-ven-webdriver/WebDriverTests.html");
         driver.navigate().to("http://www.google.com");
        setCheckBoxValue("TRUE",By.id("edit-mobile-phone-opt-in"));

    }

    private void setCheckBoxValue(String cBox1,By by) {

        if(cBox1.equalsIgnoreCase("TRUE"))
        {
            //checking if the check box is already checked
            if(driver.findElement(by).isSelected())
            {
                System.out.println("Check box is already check so ignoring the action");
                driver.findElement(by).isSelected();
            }
            else
            {
                //if not checked then check
                driver.findElement(by).click();
            }
        }
        else if(cBox1.equalsIgnoreCase("FALSE"))
        {
            if(driver.findElement(by).getAttribute("value").equalsIgnoreCase("checked"))
            {
                //if checked then uncheck
                driver.findElement(by).click();
            }
            else
            {
                System.out.println("Check box is already not checked so ignoring the action");

            }
        }

    }


    @Test
    public void testMessageOnPage()
    {
        driver.navigate().to("http://demo.nopcommerce.com/");
        Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
    }

    @Test
    public void testUseOfElementPresent()
    {
        Assert.assertTrue(CommonUtil.isElementPresent(By.id("Email")));
    }

    public void isElementPresent(By by)
    {
        Assert.assertTrue(driver.findElements(by).size()>0);
    }


    @Test
    public void testMessageOnSection()
    {
        Assert.assertEquals("The text on the element or section of web page is tested by getting the value using get text method",driver.findElement(By.id("welcomemessage")).getText(),"Welcome message");
    }

    @Test
    public void testSelectAnValueFromDropdowns()
    {
        Select select;
        select = new Select(driver.findElement(By.id("select")));
        select.selectByVisibleText("HYDERABAD");
        //we can do this in single line but to understand the steps i have kept in multiple lines
    }

    @Test
    public void testHandleAlertBox()
    {
           Alert alert;
          alert = new Alert() {
              @Override
              public void dismiss() {
                  //To change body of implemented methods use File | Settings | File Templates.
              }

              @Override
              public void accept() {
                  //To change body of implemented methods use File | Settings | File Templates.
              }

              @Override
              public String getText() {
                  return null;  //To change body of implemented methods use File | Settings | File Templates.
              }

              @Override
              public void sendKeys(String keysToSend) {
                  //To change body of implemented methods use File | Settings | File Templates.
              }
          };//// ;{
//               @Override
//               public void dismiss() {
//                   //To change body of implemented methods use File | Settings | File Templates.
//               }
//
//               @Override
//               public void accept() {
//                   //To change body of implemented methods use File | Settings | File Templates.
//               }
//
//               @Override
//               public String getText() {
//                   return null;  //To change body of implemented methods use File | Settings | File Templates.
//               }
//
//               @Override
//               public void sendKeys(String keysToSend) {
//                   //To change body of implemented methods use File | Settings | File Templates.
//               }
//           }  ;

    }
    @Test
    public void testMultipleWindows()
    {


    }

    @Test
    public void testUseOfXpath()
    {
        //nth element

              //relaive

        //attribute

        //contains text

        //class name partial
    }

    @Test
    public void testUseOfCSS()
    {
                 //nth

        //text contains
    }

    @Test
    public void testUseOfExplicitWait()
    {

    }

    @Test
    public void tesUseOfFluentWait()
    {

    }
    @Test
    public void testUseOfAjaxWait()
    {

    }
    @Test
    public void testUseOfDragAndDrop()
    {

    }

    @Test
    public void testUseOfAjaxWaitTillPageIsLoaded()
    {

    }

         ///yestodo

         //page factory



}
