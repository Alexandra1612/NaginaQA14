package com.telran.addressbook.tests;//package com.example.tests;

import org.testng.annotations.Test;

public class CreateNewContact extends TestBase{


  @Test
  public void testAddNew() throws Exception {
    app.getContactHelper().goToAddingNewContact();
    app.getContactHelper().fillInTheForm("Haifa, Bodenheimer", "Alex", "nagina");
    app.getContactHelper().submitContactModification();
  }
}
