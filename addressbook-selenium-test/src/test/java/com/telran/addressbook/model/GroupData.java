package com.telran.addressbook.model;

public class GroupData {
    private  String name;
    private  String header;
    private  String footer;

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

//    public GroupData(String name, String header, String footer) {
//        this.name = name;
//        this.header = header;
//        this.footer = footer;
//    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
