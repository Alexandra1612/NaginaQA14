package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private WebDriver driver;
    private GroupHelper groupHelper;


    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper=new NavigationHelper(driver);
        contactHelper=new ContactHelper(driver);
        open("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String admin, String secret) {
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(admin);
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(secret);
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.id("LoginForm")).click();
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void open(String url) {
      driver.get(url);
    }

    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() { return contactHelper; }


}
