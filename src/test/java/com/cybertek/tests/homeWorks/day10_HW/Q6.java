package com.cybertek.tests.homeWorks.day10_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Q6 {
    /*
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice- cybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from
“do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //Step 1. Go to "https://www.tempmailaddress.com/" Step 2. Copy and save email as a string.
        driver.get("https://www.tempmailaddress.com/");

        //Step 2. Copy and save email as a string.
        String emailText = driver.findElement(By.cssSelector("[id='email']")).getText();

        //Step 3. Then go to “https://practice- cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.cssSelector("[href='/sign_up']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Mike");

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(emailText);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        //Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actual, expected, "Verify that following message is displayed");

        //Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com");

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        driver.switchTo().defaultContent();
        String actualEmail = driver.findElement(By.xpath("//span[contains(text(), 'do-not')]")).getText();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmail, expectedEmail, "Verify that you've received an email from");

        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//span[contains(text(),'do-not')]")).click();

        //Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
        String actualMailFrom = driver.findElement(By.id("odesilatel")).getText();
        String expectedMailFrom = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualMailFrom, expectedMailFrom, "Verify that email is from");

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject, expectedSubject, "Verify that subject is");
    }
    }
