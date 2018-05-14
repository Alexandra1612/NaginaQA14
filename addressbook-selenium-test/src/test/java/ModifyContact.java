import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {

@Test
    public void contactModificationTests(){
    int before=app.getContactCount();
    app.selectContact();
    app.initContactEdition();
    app.fillInTheForm("Tel-Aviv", "Nathan", "Forshmidt");
    app.submitContactModification();
    int after=app.getContactCount();
    Assert.assertEquals(after,before);


}


}
