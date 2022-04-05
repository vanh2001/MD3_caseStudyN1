package model.Management;

public class User {
    private  int idUser;
    private String nameUser;
    private String emailUser;
    private String passwordUser;
    private long phoneUser;

    public User() {
    }

    public User(int idUser, String nameUser, String emailUser, String passwordUser, long phoneUser) {
        super();
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.phoneUser = phoneUser;
    }
    public User(String nameUser, String emailUser, String passwordUser, long phoneUser) {
        super();
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.phoneUser = phoneUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public long getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(long phoneUser) {
        this.phoneUser = phoneUser;
    }
}
