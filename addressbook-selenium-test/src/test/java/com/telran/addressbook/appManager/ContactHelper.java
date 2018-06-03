package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void goToAddingNewContact() {
       click(By.xpath("//*[@href='edit.php']"));
    }

    public void fillInTheForm(ContactData contactData) {
       type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"),contactData.getAddress());
       attach(By.name("photo"), contactData.getPhoto());
       if(isElementPresent(By.xpath("//*[@name='new_group']"))) {
           selectCertainGroup(By.xpath("//*[@name='new_group']"),contactData.getGroup());

       }
    }

    public void selectCertainGroup(By locator, String name) {
        new Select(driver.findElement(locator))
                .selectByVisibleText(name);
    }

    public void submitContactModification() { driver.findElement(By.name("submit")).click(); }

    public void submitContactModificationUpdate() { driver.findElement(By.name("update")).click(); }




    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void selectCertainContact(){
        driver.findElement(By.id("15")).click();
    }

    public void addToGroup(){driver.findElement(By.name("add")).click();}

    public void initContactDeletion() {
        driver.findElement(By.xpath("//*[@value='Delete']")).click(); }

    public int getContactCount() {
        return driver.findElements(By.id("2")).size();
    }

    public void initContactEdition(){
        driver.findElement(By.xpath("//*[@title='Edit']")).click();}
}
