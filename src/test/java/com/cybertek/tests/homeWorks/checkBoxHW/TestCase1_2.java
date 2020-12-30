package com.cybertek.tests.homeWorks.checkBoxHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1_2 {

    WebDriver driver;
    @BeforeMethod
    public void setUP(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        // 1. Open Chrome Browser comes from setUP()
        // 2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Success – Check box is checked” message is NOT displayed.
        WebElement checkBoxMessage = driver.findElement(By.xpath("//*[.='Success - Check box is checked']"));
        Assert.assertFalse(checkBoxMessage.isDisplayed(),"Verify “Success – Check box is checked” message is NOT displayed.");

        //4. Click to checkbox under “Single Checkbox Demo” section
        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
        checkBox.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(checkBoxMessage.isDisplayed(),"Verify “Success – Check box is checked” message is NOT displayed.");




    }

    @Test
    public void test2(){

        // 1. Open Chrome Browser comes from setUP()

        // 2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Check All” button text is “Check All”
        WebElement checkAllButton = driver.findElement(By.xpath("//input[@type='button']"));

        String expectedText = "Check All";
        String actualText = checkAllButton.getAttribute("value");
        Assert.assertEquals(actualText,expectedText,"Verify Check All button text");

        //4. Click to “Check All” button
        checkAllButton.click();

        //5. Verify all check boxes are checked
       // WebElement checkAllConfirm = driver.findElement(By.xpath("//input[@value='true']"));

       // List<WebElement> buttons = driver.findElements(By.xpath("//input[@value='true']"))
        //System.out.println("buttons.size() = " + buttons.size());
       // Assert.assertEquals(checkAllConfirm.getAttribute("value"), "true", "Verify all check boxes are checked");
//            if(checkAllConfirm.getAttribute("value").equals("true")){
//            System.out.println("PASS");
//            }else{
//            System.out.println("FAIL");
//            }


        //6. Verify button text changed to “Uncheck All”
        expectedText ="Uncheck All";
        actualText=checkAllButton.getAttribute("value");
       Assert.assertEquals(actualText,expectedText, "Verify button text");


    }
}
