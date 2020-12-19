package com.cybertek.tests.homeWorks.locatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    public static void main(String[] args) {

        /*
        Go to Ebay
enter search term
click on search button
print number of results

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        WebElement searchBox = driver.findElement(By.xpath("//*[@type='text']"));
        searchBox.sendKeys("term");
        driver.findElement(By.xpath("//*[@type='submit']")).click();


        System.out.println(driver.findElement(By.xpath("//*[@class='srp-controls__count-heading']")).getText());

        driver.quit();
    }
}
