import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        open("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void createNewGroup(String name, String header, String footer) {
        driver.findElement(By.name("new")).click();
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(name);
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(header);
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(footer);
      driver.findElement(By.name("submit")).click();

    }

    public void goToGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void returnToGroupsPage() {
      driver.findElement(By.linkText("group page")).click();
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


    public void goToAddingNewContact() {
        driver.findElement(By.linkText("add new")).click();
    }


    public void fillInTheForm(String address, String name, String surname) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(surname);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys("073-7766554");
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys("072-6655442");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("alexn@gmail.com");
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
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

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    protected void deleteGroup() {
        driver.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

//    protected void selectContact() {driver.findElement(By.name("selected[]")).click(); }
//
//    protected void deleteContact(){driver.findElement(By.name("delete")).click(); }

}
