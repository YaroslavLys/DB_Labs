package com.fox.service.implementation;

import com.fox.model.dao.implementation.CountryDAO;
import com.fox.model.entity.Country;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CountryService implements AbstractService<Country> {

    private final CountryDAO dao = new CountryDAO();

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Country entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Country entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
