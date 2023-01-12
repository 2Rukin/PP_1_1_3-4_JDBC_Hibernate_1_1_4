package jm.task.core.jdbc.dao;
//
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try (PreparedStatement preparedStatement =
                     Util.getConnection()
                             .prepareStatement("CREATE TABLE IF NOT EXISTS USERS " +
                                     "(id BIGINT primary key auto_increment, name VARCHAR(10), lastname VARCHAR(10), age TINYINT)")) {
            preparedStatement.execute();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void dropUsersTable() {

        try (PreparedStatement preparedStatement =
                     Util.getConnection()
                             .prepareStatement("DROP TABLE IF EXISTS users")) {
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {


        try (PreparedStatement preparedStatement =
                     Util.getConnection()
                             .prepareStatement("INSERT INTO users(name,lastName,age) VALUES (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("User с именем  - " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {

        try (PreparedStatement preparedStatement =
                     Util.getConnection()
                             .prepareStatement("DELETE FROM users WHERE id=?;")) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();


        try (ResultSet resultSet = Util.getConnection()
                .prepareStatement("SELECT * FROM users")
                .executeQuery()) {


            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getByte(4));
                user.setId(resultSet.getLong(1));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    public void cleanUsersTable() {

        try (PreparedStatement preparedStatement =
                     Util.getConnection()
                             .prepareStatement("TRUNCATE TABLE users")) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
