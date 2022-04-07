package DAO;

import model.Management.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static int save(User bean) {
        int status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into User(name_of_user, email_user, password_user, phone_number) VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, bean.getNameUser());
            preparedStatement.setString(2,bean.getEmailUser());
            preparedStatement.setString(3, bean.getPasswordUser());
            preparedStatement.setLong(4,bean.getPhoneUser());
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(User bean) {
        int  status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update user set name_of_user = ?, email_user = ?, password_user = ?, phone_number = ? where id_user = ?");
            preparedStatement.setString(1, bean.getNameUser());
            preparedStatement.setString(2, bean.getEmailUser());
            preparedStatement.setString(3, bean.getPasswordUser());
            preparedStatement.setLong(4, bean.getPhoneUser());
            preparedStatement.setInt(5, bean.getIdUser());
            status = preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<User> view() {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from User");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User bean = new User();
                bean.setIdUser(resultSet.getInt("id_user"));
                bean.setNameUser(resultSet.getString("name_of_user"));
                bean.setEmailUser(resultSet.getString("email_user"));
                bean.setPasswordUser(resultSet.getString("password_user"));
                bean.setPhoneUser(resultSet.getLong("phone_number"));
                list.add(bean);
            }
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static User viewById(int id){
        User bean=new User();
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from e_user where iduser=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                bean.setIdUser(rs.getInt(1));
                bean.setNameUser(rs.getString(2));
                bean.setPasswordUser(rs.getString(3));
                bean.setEmailUser(rs.getString(4));
                bean.setPhoneUser(rs.getLong(5));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return bean;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id_user = ?");
            preparedStatement.setInt(1, id);
            status= preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean authenticate(String emailUser, String passwordUser) {
        boolean status = false;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from User where email_user = ? and password_user = ? ");
            preparedStatement.setString(1, emailUser);
            preparedStatement.setString(2, passwordUser);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                status = true;
            }
            connection.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
