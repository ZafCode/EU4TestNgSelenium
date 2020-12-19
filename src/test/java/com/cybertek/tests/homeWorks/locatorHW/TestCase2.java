package com.cybertek.tests.homeWorks.locatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {

    public static void main(String[] args) {
        /*
        Go to Ebay
search Selenium
click on search button
verify title contains Selenium

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        WebElement searchBox = driver.findElement(By.xpath("//*[@type='text']"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        String result = driver.getTitle();

        if(result.contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("result = " + result);
        }

        driver.quit();


    }
}
