package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {

@Test
    public void contactModificationTests(){
    app.getNavigationHelper().returnToMainPage();
    int before= app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactEdition();
    app.getContactHelper().fillInTheForm(new ContactData().withAddress("Tel-Aviv").withFirstname("Nathan").withLastname("Forshmidt") );
    app.getContactHelper().submitContactModificationUpdate();
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);


}


}
