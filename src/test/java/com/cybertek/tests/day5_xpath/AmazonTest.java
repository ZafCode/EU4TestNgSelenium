package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         * TASK
         * go to amazon.com
         * search for selenium
         * click search button
         * verify 1-48 of 304 over results for "Java"
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("(//input[@id='twotabsearchtextbox'])"));
        searchBox.sendKeys("java");

        // click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Thread.sleep(3000);

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

        String expectedResult = "1-48 of over 4,000 results for";

        if(expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
        }

        driver.quit();



    }
}
