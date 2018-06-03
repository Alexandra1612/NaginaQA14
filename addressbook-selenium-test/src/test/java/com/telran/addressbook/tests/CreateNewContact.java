package com.telran.addressbook.tests;//package com.example.tests;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateNewContact extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list=new ArrayList<>();
    BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line=reader.readLine();
    while(line!=null){
      String[]split=line.split(";");
      list.add(new Object[]{new ContactData().withFirstname(split[0] ).withLastname(split[1]).withAddress(split[2])});
      line=reader.readLine();
    }
    return list.iterator();
  }



  @Test(dataProvider = "validContacts")
  public void testAddNew() throws Exception {
    app.getContactHelper().goToAddingNewContact();
    File photo= new File("src/test/resources/cat1.jpg");

    app.getContactHelper().fillInTheForm( new ContactData().withAddress("Haifa, Bodenheimer")
            .withFirstname("JOhn")
            .withLastname("nagina")
            .withPhoto(photo)
            .withGroup("name1"));
    app.getContactHelper().submitContactModification();
  }

  @Test
  public void addContactToGroup(){
    app.getNavigationHelper().returnToMainPage();
    app.getContactHelper().selectCertainContact();
    app.getContactHelper().selectCertainGroup(By.name("to_group"), "name1");
    app.getContactHelper().addToGroup();

    }
}
