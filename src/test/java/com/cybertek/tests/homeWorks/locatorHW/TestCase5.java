package com.cybertek.tests.homeWorks.locatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase5 {

    public static void main(String[] args) throws InterruptedException {
        /*
        go to etsy.com
create one locator to click Clothing & Shoes
then do string manipulation to separate your locator part and text
create one variable for menuName and change value to Home & Living
your locator should work for different menus, without changing xpath part.
Art & Collectibles

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        String menuName = "Art & Collectibles";
        String xPathLocator = "//span[contains(text(),'"+menuName+"')]";



        WebElement menu = driver.findElement(By.xpath(xPathLocator));
        menu.click();

        Thread.sleep(2000);

       driver.quit();
    }
}
