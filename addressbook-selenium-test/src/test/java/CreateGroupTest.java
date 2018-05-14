//package com.example.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {


  @Test
  public void testCreateGroup() throws Exception {
    app.goToGroupsPage();
    int before=app.getGroupCount();
    app.fillGroupForm(new GroupData("name1", "header", "footer"));
    app.returnToGroupsPage();
    int after=app.getGroupCount();
    Assert.assertEquals(after,before+1);
  }

  @Test
  public void testCreateGroupShortName() throws Exception {
    app.goToGroupsPage();
    int before=app.getGroupCount();
    app.fillGroupForm(new GroupData("n", "h", "f"));
    app.submitCreateGroup();
    app.returnToGroupsPage();
    int after=app.getGroupCount();
    Assert.assertEquals(after,before+1);
  }

  @Test
  public void testCreateGroupEmpty() throws Exception {
    app.goToGroupsPage();
    int before=app.getGroupCount();
    app.fillGroupForm(new GroupData("", "", ""));
    app.returnToGroupsPage();
    int after=app.getGroupCount();
    Assert.assertEquals(after,before+1);
  }

}
