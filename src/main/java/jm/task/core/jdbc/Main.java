package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        UserDaoJDBCImpl jdbc = new UserDaoJDBCImpl();


        jdbc.createUsersTable();
//        jdbc.saveUser("Ivav", "Petro", (byte) 10);
//
//        jdbc.saveUser("Sema", "Shniperson", (byte) 10);
//        jdbc.saveUser("Izya", "Vepr", (byte) 10);
//        jdbc.saveUser("Iskander", "Aga", (byte) 10);
//
//        System.out.println(jdbc.getAllUsers());
//        jdbc.cleanUsersTable();
//        jdbc.dropUsersTable();
    }
}
