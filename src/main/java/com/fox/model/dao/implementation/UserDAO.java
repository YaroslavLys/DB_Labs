package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.User;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractDAO<User> {

    private static final String GET_ALL = "SELECT * FROM lys_db.user";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.user WHERE id=?";
    private static final String CREATE = "INSERT lys_db.user "
            + "(`surname`, `name`, `email`, `gender`, `age`, `birthday`, `phone`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.user"
            + " SET surname=?, name=?, email=?, gender=?, age=?, birthday=?, phone=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.user WHERE id=?";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getTimestamp("birthday"),
                        resultSet.getString("phone")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getTimestamp("birthday"),
                        resultSet.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(user.getSurname()));
            statement.setString(2, String.valueOf(user.getName()));
            statement.setString(3, String.valueOf(user.getEmail()));
            statement.setString(4, String.valueOf(user.getGender()));
            statement.setString(5, String.valueOf(user.getAge()));
            statement.setString(6, String.valueOf(user.getBirthday()));
            statement.setString(7, String.valueOf(user.getPhone()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getGender());
            statement.setInt(5, user.getAge());
            statement.setTimestamp(6, user.getBirthday());
            statement.setString(7, user.getPhone());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
