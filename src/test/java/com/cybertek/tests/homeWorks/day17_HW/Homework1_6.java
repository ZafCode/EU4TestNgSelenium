package com.cybertek.tests.homeWorks.day17_HW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework1_6 extends TestBase {


    @Test
    public void displayOptionsTest(){

/*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page subtitle "Options" is displayed

 */

        extentLogger= report.createTest("Options subtitle is displayed");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.subtitleOptions.getText(), "Options", "Verify subtitle Option");
        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        Assert.assertTrue(calendarEventsPage.subtitleOptions.isDisplayed(), "Verify Options is displayed");

        extentLogger.info("PASSED");





    }

    @Test
    public void PageNumberTest(){
        /*
        1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page number is equals to "1"
         */
        extentLogger= report.createTest("Page Number verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Verify that page number is equals to \"1\"");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1", "Page number verification");

        extentLogger.info("PASSED");

    }

    @Test
    public void viewPerPageTest(){
        /*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that view per page number is equals to
"25"
         */

        extentLogger= report.createTest("View Per Page Verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Verify that view per page number is equals to\n" +"\"25\"");
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(), "25", "Verify Per Page number");

        extentLogger.info("PASSED");

    }

    @Test
    public void numberOfRowsTest() throws InterruptedException {
        /*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that number of calendar events (rows in
the table) is equals to number of records
Hint: In HTML, <table> tag represents table, <thread> - table header, <tr> tag represents table row element,
<th> table header cell and <td> table data.
Css selector: table > tr
         */
        extentLogger= report.createTest("View Per Page Verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();


        Thread.sleep(2000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Get number of records");
        String records = calendarEventsPage.numberOfRecords.getText();
        records = records.replace("Total Of ","");
        records= records.replace(" Records","");
        int numberOfRecords = Integer.parseInt(records);


        extentLogger.info("Get all the number of rows in all pages");
        String numberOfPage = calendarEventsPage.numberOfPages.getText();
        numberOfPage =numberOfPage.replace("Of ","");
        numberOfPage= numberOfPage.replace(" |","");

        calendarEventsPage.numberOfPageInput.sendKeys(numberOfPage+ Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> numberOfRowsLastPage = driver.findElements(By.cssSelector("table>tbody>tr"));
        int numberOfTotalRows = ((Integer.parseInt(numberOfPage)-1)*25)+numberOfRowsLastPage.size();


        System.out.println("numberOfRowsLastPage.size() = " + numberOfRowsLastPage.size());
        System.out.println("numberOfTotalRows = " + numberOfTotalRows);

        extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
        Assert.assertEquals(numberOfRecords, numberOfTotalRows, "Verify number of total Rows with number of records");

        extentLogger.info("PASSED");
    }

    @Test
    public void allEventsSelectedTest() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on the top checkbox to select all
5. Verify that all calendar events were selected
         */
        extentLogger= report.createTest("View Per Page Verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        Thread.sleep(2000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.selectAllEvents.click();

        Thread.sleep(3000);
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr/td/input"));
        System.out.println("allRows.size() = " + allRows.size());
        extentLogger.info("Verify that all calendar events were selected");

        /*for (WebElement allRow : allRows) {
            System.out.println(allRow.isSelected());
            Assert.assertTrue(allRow.isSelected());

        }*/

           for(int i=1; i<=allRows.size();i++){

                WebElement eachFirstCell = driver.findElement(By.xpath("//tbody/tr["+i+"]/td/input"));
                Assert.assertTrue(eachFirstCell.isSelected());
            }

        extentLogger.info("PASSED");



    }

    @Test
    public void dataDisplayTest() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Select “Testers meeting”
5. Verify that following data is displayed:
         */
        extentLogger= report.createTest("View Per Page Verification");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();


        Thread.sleep(2000);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Select “Scrum meeting”");
        calendarEventsPage.firstRow.click();

        //System.out.print(driver.findElement(By.xpath("//div[@class='responsive-block']/div[1]/div")).getText());

        extentLogger.info("Verify that following data is displayed:");
        System.out.print(driver.findElement(By.xpath("//div[@class='responsive-block']")).getText());

        extentLogger.info("PASSED");
    }


}
