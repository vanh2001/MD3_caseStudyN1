package model.Management;


public class Customer {
    private int id_customer;
    private String name_customer;
    private String birth_customer;
    private String address_customer;
    private String email_customer;
    private String phoneNumber_customer;

    public Customer(String name_customer, String birth_customer, String address_customer, String email_customer, String phoneNumber_customer) {
        this.name_customer = name_customer;
        this.birth_customer = birth_customer;
        this.address_customer = address_customer;
        this.email_customer = email_customer;
        this.phoneNumber_customer = phoneNumber_customer;
    }

    public Customer(int id_customer, String name_customer, String birth_customer, String address_customer, String email_customer, String phoneNumber_customer) {
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.birth_customer = birth_customer;
        this.address_customer = address_customer;
        this.email_customer = email_customer;
        this.phoneNumber_customer = phoneNumber_customer;
    }



    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getBirth_customer() {
        return birth_customer;
    }

    public void setBirth_customer(String birth_customer) {
        this.birth_customer = birth_customer;
    }

    public String getAddress_customer() {
        return address_customer;
    }

    public void setAddress_customer(String address_customer) {
        this.address_customer = address_customer;
    }

    public String getEmail_customer() {
        return email_customer;
    }

    public void setEmail_customer(String email_customer) {
        this.email_customer = email_customer;
    }

    public String getPhoneNumber_customer() {
        return phoneNumber_customer;
    }

    public void setPhoneNumber_customer(String phoneNumber_customer) {
        this.phoneNumber_customer = phoneNumber_customer;
    }
}
