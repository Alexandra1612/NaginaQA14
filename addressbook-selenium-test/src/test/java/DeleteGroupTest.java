import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {
    @Test
    public void groupDelitionTest(){
        goToGroupsPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

 }
