package com.fox.service.implementation;

import com.fox.model.dao.implementation.UserDAO;
import com.fox.model.entity.User;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements AbstractService<User> {

    private final UserDAO dao = new UserDAO();

    @Override
    public List<User> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(User entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, User entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
