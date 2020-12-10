package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        //navigate to another website with different selenium method
        driver.navigate().to("https://facebook.com");

        //wait 3 seconds here and then move on
        Thread.sleep(3000);

        //goes back to previus page
        driver.navigate().back();

        Thread.sleep(2000);

        //goes forward to next page
        driver.navigate().forward();

        //refresh to webpage
        driver.navigate().refresh();

        driver.quit();

    }
}
