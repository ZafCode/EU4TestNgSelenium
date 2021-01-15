package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * open the chrome
 * go to qa1.vytrack
 * login as a sales manager
 * navigate to customers ->contacts
 * click on email mbrackstone9@example.com
 * verify that full name is Mariam Brackstone
 * verify that email is mbrackstone9@example.com
 * verify that phone number is +18982323434
 */

// Day 15'teki ÇÖZÜME BAAAAAK

public class Homework extends TestBase {
    @Test
    public void test(){
        // name of the test
        extentLogger= report.createTest("Sales Manager Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: salesmanager120");
        extentLogger.info("Enter password: UserUser123");
        extentLogger.info("Login As a Sales Manager");
        extentLogger.info("Click login button");
        loginPage.loginAsSalesManager();

        /*extentLogger.info("Enter username: salesmanager120");
        loginPage.usernameInput.sendKeys("salesmanager120");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();*/

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Customers Contacts");
        dashboardPage.navigateToModule("Customers", "Contacts");

        extentLogger.info("click on email mbrackstone9@example.com");
        dashboardPage.waitUntilLoaderScreenDisappear();
        driver.findElement(By.xpath("//td[text()='mbrackstone9@example.com'][@data-column-label='Email']")).click();

        extentLogger.info("verify that full name is Mariam Brackstone");
        Assert.assertEquals(driver.findElement(By.className("user-name")).getText(),"Mariam Brackstone","verify that full name is Mariam Brackstone");

        extentLogger.info("verify that email is mbrackstone9@example.com");
        driver.findElement(By.partialLinkText("mbrackstone9@example.com")).getText().contains("mbrackstone9@example.com");

        extentLogger.info("verify that phone number is +18982323434");
        driver.findElement(By.partialLinkText("+18982323434")).getText().contains("+18982323434");

        extentLogger.info("PASSED");









    }

}
