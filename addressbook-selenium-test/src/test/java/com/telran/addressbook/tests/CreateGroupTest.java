package com.telran.addressbook.tests;//package com.example.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {


  @Test
  public void testCreateGroup() throws Exception {
    app.getNavigationHelper().goToGroupsPage();
    int before= app.getGroupHelper().getGroupCount();
    app.getGroupHelper().fillGroupForm(new GroupData("name1", "header", "footer"));
    app.getGroupHelper().submitCreateGroup();
    app.getGroupHelper().returnToGroupsPage();
    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

  @Test
  public void testCreateGroupShortName() throws Exception {
   app.getNavigationHelper().goToGroupsPage();
   int before= app.getGroupHelper().getGroupCount();
   app.getGroupHelper().fillGroupForm(new GroupData("n", "h", "f"));
    app.getGroupHelper().submitCreateGroup();
   app.getGroupHelper().returnToGroupsPage();
   int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

 @Test
  public void testCreateGroupEmpty() throws Exception {
   app.getNavigationHelper().goToGroupsPage();
   int before= app.getGroupHelper().getGroupCount();
   app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
   app.getGroupHelper().submitCreateGroup();
   app.getGroupHelper().returnToGroupsPage();
   int after= app.getGroupHelper().getGroupCount();
   Assert.assertEquals(after,before+1);
 }

}
