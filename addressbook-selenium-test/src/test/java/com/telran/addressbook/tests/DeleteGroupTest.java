package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteGroupTest extends TestBase {
    @Test
    public void groupDelitionTest(){
        app.getNavigationHelper().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
           app.getGroupHelper().createGroup();
        }
        int before= app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before-1);
    }


    @Test
    public void groupDelitionByIndexTest(){
        app.getNavigationHelper().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData>before=app.getGroupHelper().getGroupList();
       // int before= app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroupByIndex(before.size()-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData>after=app.getGroupHelper().getGroupList();
       // int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove( before.size()-1);
        Assert.assertEquals(before, after);
    }




}
