package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // Make browser full screen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");



        // input full name

        WebElement inputFullName = driver.findElement(By.name("full_name"));

        inputFullName.sendKeys("Mike Smith");

        //task
        // Put some email and click SignUp button


        //proper way
        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("mikesmith@mail.com");

        // lazy way same above
        // driver.findElement(By.name("email")).sendKeys("mikesmith@mail.com");

        Thread.sleep(3000);

       WebElement clickSignUpButton = driver.findElement(By.name("wooden_spoon"));
       clickSignUpButton.click();

        // lazy way same as above
        // driver.findElement(By.name("wooden_spoon")).click();

        Thread.sleep(2000);


        driver.quit();





    }
}
