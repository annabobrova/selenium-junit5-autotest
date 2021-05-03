package com.anna.base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.anna.base.FrontPageObjects.*;

public class FrontPage {
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearSelection(){
        driver.findElement(clearButton).click();
    }

    public void openDropDown(){
        driver.findElement(openPeopleDropDown).click();
    }

    public void closeDropDown(){
        driver.findElement(closePeopleDropDown).click();
    }

    public String addPerson(int personNumber){
        By  xpath = new By.ByXPath("//span[@role='option']["+personNumber+"]");
        driver.findElement(xpath).click();
        return driver.findElement(xpath).getText();
    }

    public Boolean verifyAddedPerson(String person) {
        Boolean result = true;
        try {
            driver.findElement(new By.ByXPath("//span[@role='listitem']/span[text()=\"" + person + "\"]")).isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }
}
