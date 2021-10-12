package com.fox.service.implementation;

import com.fox.model.dao.implementation.RegionDAO;
import com.fox.model.entity.Region;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class RegionService implements AbstractService<Region> {
    private final RegionDAO dao = new RegionDAO();

    @Override
    public List<Region> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Region findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(Region entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(String name, Region entity) throws SQLException {
        dao.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
