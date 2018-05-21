package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void goToAddingNewContact() {
        driver.findElement(By.xpath("//*[@href='edit.php']")).click();
    }

    public void fillInTheForm(String address, String name, String surname) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(surname);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);

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
