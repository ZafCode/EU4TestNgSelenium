package com.cybertek.tests.homeWorks.privateWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MyTime {

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
    public void ariel() throws InterruptedException {
        driver.get("https://www.mytime.de/");

        driver.findElement(By.xpath("//*[@id=\"accept-consent\"]/span")).click();

        driver.findElement(By.partialLinkText("Anmelden / Registrieren")).click();

        driver.findElement(By.id("login-username")).sendKeys("serkara2de@hotmail.com");
        driver.findElement(By.id("login-password")).sendKeys("233795Ssk.");
        driver.findElement(By.xpath("//form/div/button[2]")).click();


        driver.findElement(By.xpath("//*[@id=\"header\"]/nav/ul/li[6]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-clickmarker='Marken/Ariel']")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@id=\"product-list-220011908\"]/ol/li[1]/form/div[2]/button")));
        for (int i = 0; i < 7; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,250)");

        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"product-list-220011908\"]/ol/li[1]/form/div[2]/button")).click();

        WebElement element = driver.findElement(By.xpath("//button[@class='dialog-close']/span"));
        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath("//a[@aria-label='Zum Warenkorb']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='summary__footer']/a")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-250)");

        }
        driver.findElement(By.xpath("//div[@data-action='delete']")).click();

    }


}
