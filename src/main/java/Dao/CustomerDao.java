package Dao;

import connection.SingletonConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {


    public static final String INSERT_CUSTOMER_SQL = "insert into Customer(name ,birth,address,email,phoneNumber) values (?,?,?,?,?);";

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        try(Connection connection= SingletonConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3,customer.getAddress());
            preparedStatement.setDate(4, (Date) customer.getBirth());
            preparedStatement.setString(5,customer.getPhoneNumber());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer=null;
        try(Connection connection=SingletonConnection.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("select name,birth,address,email,phoneNumber from Customer where id=?;")) {
            preparedStatement.setString(1,"name");
            preparedStatement.setString(2,"email");
            preparedStatement.setString(3,"address");
            preparedStatement.setString(4,"phoneNumber");
            preparedStatement.setDate(5, Date.valueOf("birth"));
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                Date birth=resultSet.getDate("birth");
                String address=resultSet.getString("address");
                String email=resultSet.getString("email");
                String phoneNumber=resultSet.getString("phoneNumber");
                customer=new Customer(name,birth,address,email,phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers=new ArrayList<>();
        try(
                Connection connection=SingletonConnection.getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement("select * from customer");
                ) {
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                Date birth=resultSet.getDate("birth");
                String address=resultSet.getString("address");
                String email=resultSet.getString("email");
                String phoneNumber=resultSet.getString("phoneNumber");
                Customer customer=new Customer(id,name,birth,address,email,phoneNumber);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
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
