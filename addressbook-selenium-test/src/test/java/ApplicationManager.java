import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void fillGroupForm(GroupData groupData) {
        //driver.findElement(By.name("new")).click();
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());


    }

    public void submitCreateGroup() {
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
     //   driver.findElement(By.name("home")).click();
     //   driver.findElement(By.name("home")).clear();
//        driver.findElement(By.name("home")).sendKeys("073-7766554");
//        driver.findElement(By.name("mobile")).click();
//        driver.findElement(By.name("mobile")).clear();
//        driver.findElement(By.name("mobile")).sendKeys("072-6655442");
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys("alexn@gmail.com");
   //     submitContactModification();
    }

    public void submitContactModification() { driver.findElement(By.name("update")).click(); }

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

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyGroup() {
        driver.findElement(By.xpath("//*[@value='Edit group']")).click();
    }


    public void submitGroupModification() {
        driver.findElement(By.cssSelector("[name=update]")).click();
    }
    
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initContactDeletion() { driver.findElement(By.xpath("//*[@value='Delete']")).click(); }

    public int getContactCount() {
        return driver.findElements(By.id("2")).size();
    }

    public void initContactEdition() { driver.findElement(By.xpath("//*[@title='Edit']")).click();}
}
