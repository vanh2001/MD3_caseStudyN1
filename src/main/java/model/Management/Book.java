package model.Management;

public class Book {
    int id_book;
    int id_title_book;
    String name_book;
    String description_book;
    int amount_book;
    String kind_book;
    String publishing_book;
    String status_book;

    public Book() {
    }

    public Book(int id_book, int id_title_book, String name_book, String description_book, int amount_book, String kind_book, String publishing_book, String status_book) {
        this.id_book = id_book;
        this.id_title_book = id_title_book;
        this.name_book = name_book;
        this.description_book = description_book;
        this.amount_book = amount_book;
        this.kind_book = kind_book;
        this.publishing_book = publishing_book;
        this.status_book = status_book;
    }

    public Book(int id_title_book, String name_book, String description_book, int amount_book, String kind_book, String publishing_book, String status_book) {
        this.id_title_book = id_title_book;
        this.name_book = name_book;
        this.description_book = description_book;
        this.amount_book = amount_book;
        this.kind_book = kind_book;
        this.publishing_book = publishing_book;
        this.status_book = status_book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_title_book() {
        return id_title_book;
    }

    public void setId_title_book(int id_title_book) {
        this.id_title_book = id_title_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getDescription_book() {
        return description_book;
    }

    public void setDescription_book(String description_book) {
        this.description_book = description_book;
    }

    public int getAmount_book() {
        return amount_book;
    }

    public void setAmount_book(int amount_book) {
        this.amount_book = amount_book;
    }

    public String getKind_book() {
        return kind_book;
    }

    public void setKind_book(String kind_book) {
        this.kind_book = kind_book;
    }

    public String getPublishing_book() {
        return publishing_book;
    }

    public void setPublishing_book(String publishing_book) {
        this.publishing_book = publishing_book;
    }

    public String getStatus_book() {
        return status_book;
    }

    public void setStatus_book(String status_book) {
        this.status_book = status_book;
    }
}
