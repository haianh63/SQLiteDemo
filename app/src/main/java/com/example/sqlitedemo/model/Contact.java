package com.example.sqlitedemo.model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(){}

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        String res = "Id: "+ id + ", Name: " + name + ", PhoneNumber: " + phoneNumber + "\n";
        return res;
    }
}
