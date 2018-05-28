package com.telran.addressbook.model;

public class ContactData {

    private String address;
    private String firstname;
    private String lastname;

//    public ContactData(String address, String firstname, String lastname) {
//        this.address=address;
//        this.firstname= firstname;
//        this.lastname = lastname;
//    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
