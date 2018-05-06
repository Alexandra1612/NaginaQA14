//package com.example.tests;

import org.testng.annotations.Test;

public class AddNewContact extends TestBase{


  @Test
  public void testAddNew() throws Exception {
    goToAddingNewContact();
    fillInTheForm("Haifa, Bodenheimer", "Alex", "nagina");
  }
}
