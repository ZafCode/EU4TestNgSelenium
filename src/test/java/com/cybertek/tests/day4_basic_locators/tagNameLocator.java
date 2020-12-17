package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // maximize window
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement inputFullName = driver.findElement(By.tagName("input"));
        inputFullName.sendKeys("Mike Smith with tagName(input)");

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("mikesmith@mail.com");

        Thread.sleep(3000);

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        driver.quit();


    }
}
