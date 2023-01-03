package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl jdbc = new UserDaoJDBCImpl();
        jdbc.createUsersTable();
//        jdbc.saveUser("Ivav","Ivavavon", (byte) 10);
//        jdbc.saveUser("Ivav","Ivavavon", (byte) 10);
//        jdbc.saveUser("Ivav","Ivavavon", (byte) 10);
//        jdbc.saveUser("Ivav","Ivavavon", (byte) 10);
        System.out.println(jdbc.getAllUsers());
        jdbc.removeUserById(10);
        jdbc.removeUserById(11);
        jdbc.removeUserById(12);
        System.out.println("");
        System.out.println(jdbc.getAllUsers());

    }
}
