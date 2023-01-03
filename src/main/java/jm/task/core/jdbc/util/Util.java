package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.sql.*;

public class Util {


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String login = "root";
        String pass = "root1!";
        String url = "jdbc:mysql://localhost:3306/base";
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url,login, pass);

    }
}

