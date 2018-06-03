package com.telran.addressbook.tests;//package com.example.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateGroupTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line=reader.readLine();
        while(line!=null){
            String[]split=line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0] ).withHeader(split[1]).withFooter(split[2])});
            line=reader.readLine();
        }
        return list.iterator();
    }


  @Test(dataProvider = "validGroups")
  public void testCreateGroup(GroupData group) throws Exception {
    app.getNavigationHelper().goToGroupsPage();
    int before= app.getGroupHelper().getGroupCount();
      app.getGroupHelper().newGroup((By.name("new")));
    app.getGroupHelper().fillGroupForm(new GroupData().withName(group.getName())
            .withHeader(group.getHeader())
            .withFooter(group.getFooter()));
    app.getGroupHelper().submitCreateGroup(By.name("submit"));
    app.getGroupHelper().returnToGroupsPage();
    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

  @Test
  public void testCreateGroupShortName() throws Exception {
   app.getNavigationHelper().goToGroupsPage();
   int before= app.getGroupHelper().getGroupCount();
   app.getGroupHelper().newGroup((By.name("new")));
   app.getGroupHelper().fillGroupForm(new GroupData().withName("n").withHeader("h").withFooter("f"));
   app.getGroupHelper().submitCreateGroup(By.name("submit"));
   app.getGroupHelper().returnToGroupsPage();
   int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

 @Test
  public void testCreateGroupEmpty() throws Exception {
   app.getNavigationHelper().goToGroupsPage();
   int before= app.getGroupHelper().getGroupCount();
     app.getGroupHelper().newGroup((By.name("new")));
   app.getGroupHelper().fillGroupForm(new GroupData());
   app.getGroupHelper().submitCreateGroup(By.name("submit"));
   app.getGroupHelper().returnToGroupsPage();
   int after= app.getGroupHelper().getGroupCount();
   Assert.assertEquals(after,before+1);
 }

}
