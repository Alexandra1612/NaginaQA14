package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ModifyGroup extends TestBase{

    @Test
    public void groupModificationTests(){
        app.getNavigationHelper().goToGroupsPage();
      //  int before= app.getGroupHelper().getGroupCount();
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroupByIndex( before.size()-1);
        app.getGroupHelper().initModifyGroup();
        GroupData group=new GroupData().withName("newtest1").withId(before.get(before.size()-1).getId());
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after=app.getGroupHelper().getGroupList();
        //int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size());

        before.remove( before.size()-1);
        before.add(group);

        System.out.println(before);
        System.out.println(group);

        Assert.assertEquals(new HashSet(before), new HashSet(after));

    }
}
