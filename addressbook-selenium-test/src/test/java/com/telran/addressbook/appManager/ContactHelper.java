package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

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


    }

    public void submitContactModification() { driver.findElement(By.name("submit")).click(); }

    public void submitContactModificationUpdate() { driver.findElement(By.name("update")).click(); }




    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initContactDeletion() {
        driver.findElement(By.xpath("//*[@value='Delete']")).click(); }

    public int getContactCount() {
        return driver.findElements(By.id("2")).size();
    }

    public void initContactEdition(){
        driver.findElement(By.xpath("//*[@title='Edit']")).click();}
}
