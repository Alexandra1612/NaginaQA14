package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver=driver;
    }

    public void type(By locator, String text) {
        if(text!=null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

    }



    public void selectCertainGroup(By locator, String name) {
        new Select(driver.findElement(locator))
                .selectByVisibleText(name);
    }


    public void attach(By locator, File file) {
        if(file!=null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }

    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
}
