//package com.example.tests;

import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {


  @Test
  public void testCreateGroup() throws Exception {
    goToGroupsPage();
    createNewGroup("name1", "header", "footer");
    returnToGroupsPage();
  }

  @Test
  public void testCreateGroupShortName() throws Exception {
    goToGroupsPage();
    createNewGroup("n", "h", "f");
    returnToGroupsPage();
  }

  @Test
  public void testCreateGroupEmpty() throws Exception {
    goToGroupsPage();
    createNewGroup("", "", "");
    returnToGroupsPage();
  }

}
