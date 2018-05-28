package com.telran.addressbook.tests;//package com.example.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateNewContact extends TestBase{


  @Test
  public void testAddNew() throws Exception {
    app.getContactHelper().goToAddingNewContact();
    app.getContactHelper().fillInTheForm( new ContactData().withAddress("Haifa, Bodenheimer").withFirstname("Alex").withLastname("nagina"));
    app.getContactHelper().submitContactModification();
  }
}
