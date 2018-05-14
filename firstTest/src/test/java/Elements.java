import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Elements {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void elementsTest(){
        driver.get("https://www.google.com/");
        //WebElement settings=driver.findElement(By.id("fsettl"));
        driver.findElement(By.xpath("//*[@id='fsettl']")).click();
        //settings.click();
        //driver.navigate().refresh();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
