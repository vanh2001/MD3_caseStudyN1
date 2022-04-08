package model.Management;

public class Book {
<<<<<<< HEAD
    private int id_book;
    private int id_title_book;
    private String name_book;
    private String description_book;
    private int amount_book;
    private String kind_book;
    private String publishing_book;
    private String status_book;
=======
    private int bookId;
    private TitleBook titleBook;
    private String bookName;
    private String bookDescription;
    private int bookAmount;
    private String bookKind;
    private String bookPublishing;
    private String bookStatus;
>>>>>>> VIetAnh1

    public Book() {
    }

<<<<<<< HEAD
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
=======
    public Book(int bookId, TitleBook titleBook, String bookName, String bookDescription, int bookAmount, String bookKind, String bookPublishing, String bookStatus) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAmount = bookAmount;
        this.bookKind = bookKind;
        this.bookPublishing = bookPublishing;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public TitleBook getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(TitleBook titleBook) {
        this.titleBook = titleBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    public String getBookKind() {
        return bookKind;
    }

    public void setBookKind(String bookKind) {
        this.bookKind = bookKind;
    }

    public String getBookPublishing() {
        return bookPublishing;
    }

    public void setBookPublishing(String bookPublishing) {
        this.bookPublishing = bookPublishing;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
>>>>>>> VIetAnh1
    }
}
