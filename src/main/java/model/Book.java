package model;

public class Book {
    int id;
    int idTitle;
    String name;
    String description;
    int amount;
    String kind;
    String publishing;

    public Book() {
    }

    public Book(int id, int idTitle, String name, String description, int amount, String kind, String publishing) {
        this.id = id;
        this.idTitle = idTitle;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.kind = kind;
        this.publishing = publishing;
    }

    public Book(int idTitle, String name, String description, int amount, String kind, String publishing) {
        this.idTitle = idTitle;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.kind = kind;
        this.publishing = publishing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(int idTitle) {
        this.idTitle = idTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }
}
