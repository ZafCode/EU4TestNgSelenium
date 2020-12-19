package com.cybertek.tests.homeWorks.locatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    public static void main(String[] args) {

        /*
        Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//button/i[contains(text(),'Search')]")).click();
        driver.findElement(By.xpath("//div/a[@title='Selenium (software)']")).click();

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.endsWith("Selenium_(software)")){
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
        }

        driver.quit();


    }
}
