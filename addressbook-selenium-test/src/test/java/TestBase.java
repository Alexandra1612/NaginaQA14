import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();
        app.open("http://localhost/addressbook/");
        app.login("admin", "secret");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

    //    protected void selectContact() {driver.findElement(By.name("selected[]")).click(); }
//
//    protected void deleteContact(){driver.findElement(By.name("delete")).click(); }

}
