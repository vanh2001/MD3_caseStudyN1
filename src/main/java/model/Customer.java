package model;

import java.util.Date;

public class Customer {
int id;
String name;
Date birth;
String address;
String email;
String phoneNumber;

    public Customer(String name, Date birth, String address, String email, String phoneNumber) {
    }

    public Customer(int id, String name, Date birth, String address, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String email, String address, java.sql.Date birth, String phoneNumber) {

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
