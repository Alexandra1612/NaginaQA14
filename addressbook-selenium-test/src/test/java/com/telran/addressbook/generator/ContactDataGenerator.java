package com.telran.addressbook.generator;

import com.telran.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count=Integer.parseInt(args[0]);
        File file=new File(args[1]);

        List<ContactData> contacts=generateContacts(count);
        save(contacts,file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer=new FileWriter(file);
        for (ContactData contact:contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s\n",contact.getFirstname(),
                    contact.getLastname(),
                    contact.getAddress(),
                    contact.getGroup()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts=new ArrayList<ContactData>();
        for(int i=0; i<count; i++){
            contacts.add(new ContactData().withFirstname(String.format("aaa %s",i))
                    .withLastname(String.format("bbb %s",i))
                    .withAddress(String.format("ccc %s",i))
            .withGroup(String.format("ddd %s",i)));
        }
        return contacts;
    }
}
