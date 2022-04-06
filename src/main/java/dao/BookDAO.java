package dao;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO{

    public static final String INSERT_BOOK = "insert into book(idTitle, name, description, amount, kind, publishing) value (?,?,?,?,?,?)";
    public static final String SELECT_BOOK_BY_ID = "insert into idTitle,name, description, amount, kind, publishing from book where id=?";
    public static final String SELECT_LIST_BOOK = "insert into * from book";

    @Override
    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOK);
        try(
        Connection connection = SingletonConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)
        ){
            preparedStatement.setInt(1,book.getIdTitle());
            preparedStatement.setString(2,book.getName());
            preparedStatement.setString(3,book.getDescription());
            preparedStatement.setInt(4,book.getAmount());
            preparedStatement.setString(5,book.getKind());
            preparedStatement.setString(6, book.getPublishing());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        Book book = null;

        try (
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)
        ){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idTitle = resultSet.getInt("idTitle");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("anount");
                String kind = resultSet.getString("kind");
                String publishing = resultSet.getString("publishing");
                book = new Book(id,idTitle,name,description,amount,kind,publishing);
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
                Connection connection = SingletonConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIST_BOOK);
        ){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int idTitle = resultSet.getInt("idTitle");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                String kind = resultSet.getString("kind");
                String publishing = resultSet.getString("publishing");
                Book book = new Book(id,idTitle,name,description,amount,kind,publishing);
                books.add(book);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return selectAllBook();
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        return false;
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
