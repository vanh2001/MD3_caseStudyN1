package model.Management;

public class LibrarianBean {
    private int idLibrarian;
    private String nameLibrarian;
    private String emailLibrarian;
    private String passwordLibrarian;
    private long phoneLibrarian;

    public LibrarianBean() {
    }

    public LibrarianBean(int idLibrarian, String nameLibrarian, String emailLibrarian, String passwordLibrarian, long phoneLibrarian) {
        super();
        this.idLibrarian = idLibrarian;
        this.nameLibrarian = nameLibrarian;
        this.emailLibrarian = emailLibrarian;
        this.passwordLibrarian = passwordLibrarian;
        this.phoneLibrarian = phoneLibrarian;
    }

    public LibrarianBean(String nameLibrarian, String emailLibrarian, String passwordLibrarian, long phoneLibrarian) {
        super();
        this.nameLibrarian = nameLibrarian;
        this.emailLibrarian = emailLibrarian;
        this.passwordLibrarian = passwordLibrarian;
        this.phoneLibrarian = phoneLibrarian;
    }

    public int getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(int idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public String getNameLibrarian() {
        return nameLibrarian;
    }

    public void setNameLibrarian(String nameLibrarian) {
        this.nameLibrarian = nameLibrarian;
    }

    public String getEmailLibrarian() {
        return emailLibrarian;
    }

    public void setEmailLibrarian(String emailLibrarian) {
        this.emailLibrarian = emailLibrarian;
    }

    public String getPasswordLibrarian() {
        return passwordLibrarian;
    }

    public void setPasswordLibrarian(String passwordLibrarian) {
        this.passwordLibrarian = passwordLibrarian;
    }

    public long getPhoneLibrarian() {
        return phoneLibrarian;
    }

    public void setPhoneLibrarian(long phoneLibrarian) {
        this.phoneLibrarian = phoneLibrarian;
    }
}
