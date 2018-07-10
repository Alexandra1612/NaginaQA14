package com.telran.addressbook.appManager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
    private EventFiringWebDriver driver;
    public ApplicationManager(String browser) {

        this.browser=browser;
    }

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by+" found.");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println("Error!!!!! "+throwable);
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenshot=new File("screenshot-" + System.currentTimeMillis()+".png");
            try {
                Files.copy(tmp,screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screenshot);
        }
    }

    public ApplicationManager(String browser, String chrome) { }


    public void start() {

        if(browser.equals(BrowserType.CHROME)){
            driver=new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            driver=new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.IE)){
            driver=new EventFiringWebDriver(new InternetExplorerDriver());
        }
        driver.register(new MyListener());
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




    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() { return contactHelper; }


}
