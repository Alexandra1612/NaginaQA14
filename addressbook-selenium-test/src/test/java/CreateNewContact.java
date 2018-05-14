//package com.example.tests;

import org.testng.annotations.Test;

public class CreateNewContact extends TestBase{


  @Test
  public void testAddNew() throws Exception {
    app.goToAddingNewContact();
    app.fillInTheForm("Haifa, Bodenheimer", "Alex", "nagina");
    app.submitContactModification();
  }
}
