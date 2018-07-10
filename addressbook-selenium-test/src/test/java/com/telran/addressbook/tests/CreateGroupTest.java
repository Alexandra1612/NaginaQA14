package com.telran.addressbook.tests;//package com.example.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CreateGroupTest extends TestBase {
Logger logger=LoggerFactory.getLogger(CreateGroupTest.class);


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
        logger.info("Start testCreateGroup ");

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
      logger.info("Stop testCreateGroup ");
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

    @Test
    public void testCreateGroupShortName1() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
      //  int before= app.getGroupHelper().getGroupCount();
        List<GroupData>before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().newGroup((By.name("new")));
        GroupData group=new GroupData().withName("new");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitCreateGroup(By.name("submit"));
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData>after=app.getGroupHelper().getGroupList();
       // int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(),before.size()+1);
        int max=0;
        for(GroupData g: after){
            if(g.getId()>max){
                max=g.getId();
            }
        }
        group.withId(max);
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
