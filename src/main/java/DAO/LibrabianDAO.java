package DAO;

import model.Management.LibrarianBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LibrabianDAO {

    public static int save(LibrarianBean bean) {
        int status = 0;
        try {
            Connection connection = DB.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(insert into LibrabianBean(name_librabian_bean, password, mobile));
        }
    }
}
