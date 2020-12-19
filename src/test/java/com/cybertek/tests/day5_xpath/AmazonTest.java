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
         * verify 1-48 of 304 results for "Java"
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("(//input[@id='twotabsearchtextbox'])"));
        searchBox.sendKeys("selenium");

        // click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Thread.sleep(3000);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
        String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

        String expectedResult = "1-48 of 304 results for ";

        if(actualResult.equals(expectedResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
        }

        driver.quit();



    }
}
