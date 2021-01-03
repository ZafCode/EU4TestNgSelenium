package com.cybertek.tests.homeWorks.day10_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Q8 {

    /*
    Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4 Click "Submit" button.
Step 5. Verify that following message is displayed: “You selected: United States of America”
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test(){
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();

        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        //Step 4 Click "Submit" button.
        driver.findElement(By.xpath("//input[@type='button']")).click();

        //Step 5. Verify that following message is displayed: “You selected: United States of America”
        String expectedMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message is displayed");
    }
}
