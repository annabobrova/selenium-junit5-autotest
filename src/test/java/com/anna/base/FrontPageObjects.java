package com.anna.base;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class FrontPageObjects {
    public static final By clearButton = new By.ByXPath("//button[text()='Clear']");
    public static final By openPeopleDropDown = new By.ByXPath("//div[@aria-label='Dropdown select']");
    public static final By closePeopleDropDown = new By.ByXPath("//div[@aria-label='Dropdown select']/div[2]");
}

