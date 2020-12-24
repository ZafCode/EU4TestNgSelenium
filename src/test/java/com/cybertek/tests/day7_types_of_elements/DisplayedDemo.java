package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //Verify username input box not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(), "Username inputbox NOt displayed");

        //click start button
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);

        //Verify username displayed on the screen
        Assert.assertTrue(usernameInput.isDisplayed(),"Username input box displayed on the screen");

        driver.quit();
    }
}
