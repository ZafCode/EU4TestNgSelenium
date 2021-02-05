package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn-toolbar']/div[2]/div[@data-toggle='dropdown']")
    public WebElement subtitleOptions;

    @FindBy(xpath = "//li/input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div/button[contains(text(), '25')]")
    public WebElement viewPerPage;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement numberOfRecords;

    @FindBy(xpath = "//thead//input[@type='checkbox']")
    public WebElement selectAllEvents;

    @FindBy(xpath = "//tbody/tr[1]")
    public WebElement firstRow;

    @FindBy(xpath = "//div/label[@class='dib'][2]")
    public WebElement numberOfPages;

    @FindBy(xpath = "//li/input")
    public WebElement numberOfPageInput;



}