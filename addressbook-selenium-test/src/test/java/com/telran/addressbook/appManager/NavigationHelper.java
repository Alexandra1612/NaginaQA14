package com.telran.addressbook.appManager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver driver) {
       super(driver);
    }

    public void goToGroupsPage() {
        if(isElementPresent(By.tagName("h1"))&& driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
    return;
        }
        click(By.xpath("//*[@href='group.php']"));

    }



 //   public void returnToMainPage(){driver.findElement(By.xpath("//*[@href='./']")).click(); }

    public void returnToMainPage(){
        if(isElementPresent(By.id("maintable"))&& driver.findElement(By.xpath("//*[@href='./']")).getText().equals("home")
                && isElementPresent(By.xpath("//*[@type='text']"))){
        return;
        }
        click(By.xpath("//*[@href='./']"));
    }


}
