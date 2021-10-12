package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.City;
import com.fox.service.implementation.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements AbstractController<City> {
    CityService service = new CityService();

    @Override
    public List<City> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(City entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public City findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, City entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
