package com.cybertek.tests.homeWorks.privateWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SlackTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://cybertekschool.okta.com/login/login.htm?fromURI=%2Fapp%2FUserHome");
        driver.findElement(By.id("okta-signin-username")).sendKeys("serkara2de@hotmail.com");
        driver.findElement(By.id("okta-signin-password")).sendKeys("233795Ssk.");
        driver.findElement(By.cssSelector("#okta-signin-submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/input[@value='Send Push']")).click();


        Thread.sleep(9000);
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.COMMAND, Keys.SHIFT, "{");

        driver.findElement(By.xpath("//ul/li/a[@data-se='app-button-0oa835nowmWdRekJn2p7']")).click();

        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.COMMAND + "t");

        Thread.sleep(18000);

        driver.findElement(By.xpath("//div[@role='alert']/button")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'group17')]")).click();

        driver.findElement(By.xpath("//div[@aria-label='Message part2-group17']/p")).sendKeys("This message was sent via Selenium :sunglasses:");

        driver.findElement(By.xpath("//i[@type='paperplane-filled']")).click();

        driver.quit();

    }
}
