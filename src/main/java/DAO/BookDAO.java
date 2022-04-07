package DAO;

import model.Management.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO{
    public BookDAO() {
    }

    public static final String DELETE_BOOK = "delete from Book where id_book=?";
    public static final String EDIT_BOOk = "update Book set id_title_book=?, name_book=?, description_book=?, amount_book=?, kind_book=?, publishing_book=?, status_book=? where id_book=?";
    public static final String INSERT_BOOK = "insert into Book(id_title_book, name_book, description_book, amount_book, kind_book, publishing_book, status_book) value (?,?,?,?,?,?,?)";
    public static final String SELECT_BOOK_BY_ID = "select id_title_book,name_book, description_book, amount_book, kind_book, publishing_book, status_book from Book where id_book=?";
    public static final String SELECT_LIST_BOOK = "select * from Book";

    @Override
    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOK);
        try(
                Connection connection = DB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)
        ){
            preparedStatement.setInt(1,book.getId_title_book());
            preparedStatement.setString(2,book.getName_book());
            preparedStatement.setString(3,book.getDescription_book());
            preparedStatement.setInt(4,book.getAmount_book());
            preparedStatement.setString(5,book.getKind_book());
            preparedStatement.setString(6, book.getPublishing_book());
            preparedStatement.setString(7,book.getStatus_book());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Book selectBook(int id_book) {
        Book book = null;

        try (
                Connection connection = DB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)
        ){
            preparedStatement.setInt(1, id_book);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_title_book = resultSet.getInt("id_title_book");
                String name_book = resultSet.getString("name_book");
                String description_book = resultSet.getString("description_book");
                int amount_book = resultSet.getInt("amount_book");
                String kind_book = resultSet.getString("kind_book");
                String publishing_book = resultSet.getString("publishing_book");
                String status_book = resultSet.getString("status_book");
                book = new Book(id_book,id_title_book,name_book,description_book,amount_book,kind_book,publishing_book,status_book);
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    @Override
    public List<Book> selectAllBook() {
        List<Book> books = new ArrayList<>();

        try (
                Connection connection = DB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIST_BOOK);
        ){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_book = resultSet.getInt("id_book");
                int id_title_book = resultSet.getInt("id_title_book");
                String name_book = resultSet.getString("name_book");
                String description_book = resultSet.getString("description_book");
                int amount_book = resultSet.getInt("amount_book");
                String kind_book = resultSet.getString("kind_book");
                String publishing_book = resultSet.getString("publishing_book");
                String status_book = resultSet.getString("status_book");
                Book book = new Book(id_book,id_title_book,name_book,description_book,amount_book,kind_book,publishing_book,status_book);
                books.add(book);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    @Override
    public boolean deleteBook(int id_book) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK);) {
            statement.setInt(1, id_book);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(EDIT_BOOk);) {
            statement.setInt(1, book.getId_title_book());
            statement.setString(2, book.getName_book());
            statement.setString(3, book.getDescription_book());
            statement.setInt(4, book.getAmount_book());
            statement.setString(5, book.getKind_book());
            statement.setString(6, book.getPublishing_book());
            statement.setString(7, book.getStatus_book());
            statement.setInt(8,book.getId_book());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
