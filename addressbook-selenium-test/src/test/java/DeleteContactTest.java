import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
   public void contactDeleting() {
        app.selectContact();
        app.initContactDeletion();
        app.acceptAlert();
        }

}
