package DAO;

import model.Management.LibrarianBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibrabianDAO {

    public static int save(LibrarianBean bean) {
        int status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement("insert into LibrarianBean(name_librarian_bean, email_librarian_bean, password_librarian_bean, phone_librarian_bean) values (?, ?, ?, ?)");
            preparedStatement.setString(1, bean.getNameLibrarian());
            preparedStatement.setString(2,bean.getEmailLibrarian());
            preparedStatement.setString(3,bean.getPasswordLibrarian());
            preparedStatement.setLong(4,bean.getPhoneLibrarian());
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(LibrarianBean bean) {
        int status = 0;
        try {
           Connection connection = DB.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("update LibrarianBean set name_librarian_bean = ?, email_librarian_bean = ?, password_librarian_bean = ?, phone_librarian_bean = ? when id_librarian_bean = ?");
           preparedStatement.setString(1, bean.getNameLibrarian());
           preparedStatement.setString(2, bean.getEmailLibrarian());
           preparedStatement.setString(3,bean.getPasswordLibrarian());
           preparedStatement.setLong(4,bean.getPhoneLibrarian());
           preparedStatement.setInt(5,bean.getIdLibrarian());
           status = preparedStatement.executeUpdate();
           connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<LibrarianBean> view() {
        List<LibrarianBean> list = new ArrayList<>();
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from LibrarianBean");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while   (resultSet.next()) {
                LibrarianBean bean = new LibrarianBean();
                bean.setIdLibrarian(resultSet.getInt("id_librarian_bean"));
                bean.setNameLibrarian(resultSet.getString("name_librarian_bean"));
                bean.setEmailLibrarian(resultSet.getString("email_librarian_bean"));
                bean.setPasswordLibrarian(resultSet.getString("password_librarian_bean"));
                bean.setPhoneLibrarian(resultSet.getLong("phone_librarian_bean"));
                list.add(bean);
            }
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static LibrarianBean viewbyId(int id) {
        LibrarianBean bean = new LibrarianBean();
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from LibrarianBean where id_librarian_bean = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bean.setIdLibrarian(resultSet.getInt(1));
                bean.setNameLibrarian(resultSet.getString(2));
                bean.setPasswordLibrarian(resultSet.getString(3));
                bean.setPhoneLibrarian(resultSet.getLong(3));
            }
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from LibrarianBean where id_librarian_bean = ?");
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean authenticate(String emailLibrarian, String passwordLibrarian) {
        boolean status = false;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from LibrarianBean where email_librarian_bean = ? and  password_librarian_bean = ?");
            preparedStatement.setString(1, emailLibrarian);
            preparedStatement.setString(2, passwordLibrarian);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status = true;
            }
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }
}
