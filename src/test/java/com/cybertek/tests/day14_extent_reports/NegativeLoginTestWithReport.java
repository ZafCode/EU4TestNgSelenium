package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        // Name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password: wrong password");
        loginPage.passwordInput.sendKeys("wrongpassword");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.info("Wrong Password Test is Passed");
    }

    @Test
    public void wrongUsernameTest(){

        //name of the test
        extentLogger = report.createTest("Wrong username test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: wrong username");
        loginPage.usernameInput.sendKeys("wrongusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify the page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login1");

        extentLogger.info("PASSED");
    }

}
