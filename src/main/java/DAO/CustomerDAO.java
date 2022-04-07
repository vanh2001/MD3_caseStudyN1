package DAO;

import model.Management.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDao {
    private static final String INSERT_CUSTOMER_SQL = "insert into Customer(name_customer,birth_customer,address_customer,email_customer,phoneNumber_customer) values (?,?,?,?,?);";
    public static final String SELECT_FROM_CUSTOMER = "select * from customer";
    public static final String SELlEC_CUSTOMER_ByID = "select name_customer,birth_customer,address_customer,email_customer,phoneNumber_customer from Customer where id_customer=?;";
    private static final String DELETE_USERS_SQL = "delete from customer where id_customer = ?;";
    private static final String UPDATE_USERS_SQL = "update customer set name_customer = ?,email_customer= ?, address_customer=?,birth_customer=?,phoneNumber_cutomer =? where id_customer = ?;";

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        try(Connection connection= DB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setString(1, customer.getName_customer());
            preparedStatement.setString(2, customer.getEmail_customer());
            preparedStatement.setString(3,customer.getAddress_customer());
            preparedStatement.setString(4,customer.getBirth_customer());
            preparedStatement.setString(5,customer.getPhoneNumber_customer());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Customer selectCustomer(int id_customer) {
        Customer customer=null;
        try(Connection connection=DB.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELlEC_CUSTOMER_ByID )) {
            preparedStatement.setString(1,"name_customer");
            preparedStatement.setString(2,"email_customer");
            preparedStatement.setString(3,"address_customer");
            preparedStatement.setString(4,"phoneNumber_customer");
            preparedStatement.setString(5, "birth_customer");
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name_customer=resultSet.getString("name_customer");
                String birth_customer=resultSet.getString("birth_customer");
                String address_customer=resultSet.getString("address_customer");
                String email_customer=resultSet.getString("email_customer");
                String phoneNumber_customer=resultSet.getString("phoneNumber_customer");
                customer=new Customer(name_customer,birth_customer,address_customer,email_customer,phoneNumber_customer);
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
                Connection connection=DB.getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(SELECT_FROM_CUSTOMER);
        ) {
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_customer=resultSet.getInt("id_customer");
                String name_customer=resultSet.getString("name_customer");
                String birth_customer=resultSet.getString("birth_customer");
                String address_customer=resultSet.getString("address_customer");
                String email_customer=resultSet.getString("email_customer");
                String phoneNumber_customer=resultSet.getString("phoneNumber_customer");
                Customer customer=new Customer(id_customer,name_customer,birth_customer,address_customer,email_customer,phoneNumber_customer);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id_customer) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DB.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id_customer);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DB.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, customer.getName_customer());
            statement.setString(2, customer.getEmail_customer());
            statement.setString(3, customer.getAddress_customer());
            statement.setString(4, customer.getPhoneNumber_customer());
            statement.setString(5, customer.getBirth_customer());

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
