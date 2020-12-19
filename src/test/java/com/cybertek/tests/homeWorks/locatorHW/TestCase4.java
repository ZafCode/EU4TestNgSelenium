package com.cybertek.tests.homeWorks.locatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase4 {
    public static void main(String[] args) throws InterruptedException {
        /*
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button

4.Print text of a,b,c,e and put some email to d

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeButton = driver.findElement(By.xpath("//li/a[.='Home']"));
        System.out.println(homeButton.getText());

        WebElement forgotHeader = driver.findElement(By.xpath("//h2[contains (text(),'Forgot')]"));
        System.out.println(forgotHeader.getText());

        WebElement eMailText = driver.findElement(By.xpath("//label[.='E-mail']"));
        System.out.println(eMailText.getText());

        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]"));
        System.out.println(retrievePasswordButton.getText());

        WebElement eMailBox = driver.findElement(By.xpath("//input[@type='text']"));
        eMailBox.sendKeys("mike@mike.com");
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();

        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(1000);
        driver.quit();





    }
}
