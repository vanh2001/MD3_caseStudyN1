package DAO;

import model.Management.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    public void insertBook (Book book) throws SQLException;
    public Book selectBook(int id_book);

    public List<Book> selectAllBook();

    public boolean deleteBook(int id_book) throws SQLException;

    public boolean updateBook(Book book) throws SQLException;
}
