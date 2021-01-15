package com.cybertek.pages;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);

    }

   /* @FindAll({ // This means this locator or this locator
            @FindBy(id ="prependedInput"),
            @FindBy(name="username")
    })*/

    // driver.findElement(By.id("prependedInput")) alttaki aynı
    @FindBy(id ="prependedInput")
    public WebElement usernameInput;

    @FindBy(id= "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id= "_submit")
    public WebElement loginBtn;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }






}
