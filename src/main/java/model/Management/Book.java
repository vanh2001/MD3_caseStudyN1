package model.Management;

public class Book {
    private int bookId;
    private TitleBook titleBook;
    private String bookName;
    private String bookDescription;
    private int bookAmount;
    private String bookKind;
    private String bookPublishing;
    private String bookStatus;

    public Book() {
    }

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
    }
}
