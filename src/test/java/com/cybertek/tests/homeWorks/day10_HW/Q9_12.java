package com.cybertek.tests.homeWorks.day10_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Q9_12 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @DataProvider(name = "data-provider")
    public Object[][] getData() {

        Object[][] data = {
                {"https://practice-cybertekschool.herokuapp.com","Status Codes","200","//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com","Status Codes","301","//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com","Status Codes","404","//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com","Status Codes","500","//*[contains(text(),'returned')]"},
        };

        return data;

    }
    @Test(dataProvider = "data-provider")
    public void test( String data1, String data2, String data3, String data4) {
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get(data1);

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText(data2)).click();

        //Step 3. Then click on “ ...”.
        driver.findElement(By.linkText(data3)).click();


        //Step 4. Verify that following message is displayed: “This page returned a ... status code”
        WebElement message =driver.findElement(By.xpath(data4));
        String actualMessage = message.getText();
        System.out.println(actualMessage);
        Assert.assertTrue(message.isDisplayed(),"Verify return message");

    }
}
