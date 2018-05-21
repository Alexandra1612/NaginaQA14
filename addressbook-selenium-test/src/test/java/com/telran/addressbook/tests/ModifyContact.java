package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {

@Test
    public void contactModificationTests(){
    app.getNavigationHelper().returnToMainPage();
    int before= app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactEdition();
    app.getContactHelper().fillInTheForm("Tel-Aviv", "Nathan", "Forshmidt");
    app.getContactHelper().submitContactModificationUpdate();
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);


}


}
