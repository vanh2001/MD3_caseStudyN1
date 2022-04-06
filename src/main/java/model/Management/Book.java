package model.Management;

public class Book {
    int id;
    int idTitle;
    String name;
    String description;
    int amount;
    String kind;
    String publishing;
    String status;

    public Book() {
    }

    public Book(int id, int idTitle, String name, String description, int amount, String kind, String publishing, String status) {
        this.id = id;
        this.idTitle = idTitle;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.kind = kind;
        this.publishing = publishing;
        this.status = status;
    }

    public Book(int idTitle, String name, String description, int amount, String kind, String publishing, String status) {
        this.idTitle = idTitle;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.kind = kind;
        this.publishing = publishing;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
