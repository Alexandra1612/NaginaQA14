package com.telran.addressbook.appManager;

import com.telran.addressbook.generator.GroupDataGenerator;
import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);

    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"),groupData.getHeader());
        type(By.name("group_footer"),groupData.getFooter());

        }

    public void submitCreateGroup(By locator) {
        click(locator);
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyGroup() {
        click(By.xpath("//*[@value='Edit group']"));
    }

    public void submitGroupModification() {
        click(By.cssSelector("[name=update]"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        newGroup(By.name("new"));
    fillGroupForm(new GroupData().withName("n").withHeader("h").withFooter("f"));
    submitCreateGroup(By.name("submit"));
    returnToGroupsPage();
    }

    public void newGroup(By name) {
click(By.name("new"));
    }

    public void selectGroupByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups=new ArrayList<>();
      List<WebElement> elements=driver.findElements(By.cssSelector("span.group"));
      for(WebElement element:elements){
          String name=element.getText();
          int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
          GroupData group=new GroupData().withId(id).withName(name);
          groups.add(group);
      }

        return groups;
    }
}
