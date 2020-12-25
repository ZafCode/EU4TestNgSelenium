package com.cybertek.tests.day8_types_of_elements_2;

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

public class SelectDropdownTest {

    WebDriver driver;
    @BeforeMethod
    public void setUP(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. locate your dropdown just like any other web element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown
        List<WebElement> dropdownOptions = stateDropdown.getOptions();

        //print size of the options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());

        // print dropdownOptions one by one
        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());

        }

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. locate your dropdown just like any other web element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        // Verify that first selection is "Select a State"
        String expectedOption ="Select a State";
        String  actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify first selection");

        // HOW TO SELECT OPTIONS FROM DROPDOWN?
        // 1.SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "Verify first selection");

        //2. SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "Verify first selection");

        // 3. SELECT USING VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption = "Texas";
        actualOption= stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");




    }

}
