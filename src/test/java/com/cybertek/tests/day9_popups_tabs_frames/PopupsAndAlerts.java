package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopupsAndAlerts {

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

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the "Destroy the World" button
        driver.findElement(By.xpath("//*[.='Destroy the World']")).click();

        //Click NO button
        driver.findElement(By.xpath("//*[.='No']")).click();


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //Click "Click for JS Alert" button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //Click "JS" button
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        // Click for "JS Prompt"
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("MikeSmith");
        alert.accept();





    }
}
