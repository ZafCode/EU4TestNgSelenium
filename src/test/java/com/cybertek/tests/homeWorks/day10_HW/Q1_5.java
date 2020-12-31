package com.cybertek.tests.homeWorks.day10_HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Q1_5 {

    WebDriver driver;
    @BeforeMethod
    public void setUP(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        /*
        Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”

         */

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//li/a[.='Registration Form']")).click();

        Thread.sleep(2000);
        // Step 3. Enter “wrong_dob” into date of birth input box.
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed: “The date of birth is not valid”

        String expectedMessage ="The date of birth is not valid";
        String actualMessage = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();

        Assert.assertEquals(expectedMessage,actualMessage,"Verify wirning message");



    }

    @Test
    public void test2() throws InterruptedException {
        /*
        Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
         */
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//li/a[.='Registration Form']")).click();

        Thread.sleep(3000);
        //Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
        List<WebElement> checkBoxes = driver.findElements(By.className("form-check-input"));
        System.out.println("checkBoxes.size() = " + checkBoxes.size());
        for (WebElement elements : checkBoxes) {

            System.out.println("elements.isDisplayed() = " + elements.isDisplayed());
            Assert.assertTrue(elements.isDisplayed(),"Verify All all programing languages are displayed");

        }

    }

    @Test
    public void test3(){
        /*
        Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
         */
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//li/a[.='Registration Form']")).click();

        //Step 3. Enter only one alphabetic character into first name input box.
        driver.findElement(By.xpath("//div/input[@name='firstname']")).sendKeys("a");

        //Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//div/small[contains(text(),'more than 2 and less than 64')]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage,"Verify the warning message");
    }

    @Test
    public void test4(){
        /*
        Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last name input box.
Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
         */
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//li/a[.='Registration Form']")).click();

        //Step 3. Enter only one alphabetic character into last name input box.
        driver.findElement(By.xpath("//div/input[@name='lastname']")).sendKeys("a");

        //Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//div/small[contains(text(),'The last name ')][1]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage,"Verify the warning message");
    }

    @Test
    public void test5(){
        /*
        Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
  Step 3. Enter any valid first name
Step 4. Enter any valid last name
Step 5. Enter any valid username
Step 6. Enter any valid email
Step 7. Enter any valid password
Step 8. Enter any valid phone number
Step 9. Select gender.
Step 10. Enter any valid date of birth
Step 11. Select any department.
Step 12. Enter any job title.
Step 13. Select java as a programming language.
Step 14. Click Sign up.
Step 15. Verify that following success message is displayed: “You've successfully completed registration!”

         */

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//li/a[.='Registration Form']")).click();

        //Step 3. Enter any valid first name
        driver.findElement(By.xpath("//div/input[@name='firstname']")).sendKeys("Mike");

        //Step 4. Enter any valid last name
        driver.findElement(By.xpath("//div/input[@name='lastname']")).sendKeys("Smith");

        //Step 5. Enter any valid username
        driver.findElement(By.name("username")).sendKeys("Mike123");

        //Step 6. Enter any valid email
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");

        //Step 7. Enter any valid password
        driver.findElement(By.name("password")).sendKeys("Smith321");

        //Step 8. Enter any valid phone number
        driver.findElement(By.name("phone")).sendKeys("555-555-5555");

        //Step 9. Select gender.
        driver.findElement(By.name("gender")).click();

        //Step 10. Enter any valid date of birth
        driver.findElement(By.name("birthday")).sendKeys("01/01/2021");

        //Step 11. Select any department.
        WebElement dropdownElement = driver.findElement(By.name("department"));
        Select departmentSelection = new Select(dropdownElement);
        departmentSelection.selectByValue("DE");

        //Step 12. Enter any job title.
        dropdownElement= driver.findElement(By.name("job_title"));
        Select jobTitle = new Select(dropdownElement);
        jobTitle.selectByVisibleText("SDET");

        //Step 13. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox2")).click();

        //Step 14. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();


        //Step 15. Verify that following success message is displayed: “You've successfully completed registration!”
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//div/p")).getText();

        Assert.assertEquals(expectedMessage,actualMessage,"Verify the sign up display message");

    }
}
