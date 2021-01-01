package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    WebDriver driver;
    @BeforeMethod
    public void setUP(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown() {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {


        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));
        driver.findElement(By.tagName("button")).click();

        //HOW TO WAIT EXPLICITLY
        // create explicit ait object
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(usernameInput));


        usernameInput.sendKeys("MikeSmith");


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //Click enable
        driver.findElement(By.xpath("//form/button[@onclick='swapInput()']")).click();

        // finding inputBox and Wait Explicit Object
        WebElement inputBox  = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait inputBoxWait = new WebDriverWait(driver,20);
        inputBoxWait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("MikeSmith");


    }
}
