package com.fox.service.implementation;

import com.fox.model.dao.implementation.CityDAO;
import com.fox.model.entity.City;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class CityService implements AbstractService<City> {
    private final CityDAO dao = new CityDAO();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(City entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, City entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
