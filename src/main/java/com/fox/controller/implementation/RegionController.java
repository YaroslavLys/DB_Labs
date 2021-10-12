package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Region;
import com.fox.service.implementation.RegionService;

import java.sql.SQLException;
import java.util.List;

public class RegionController implements AbstractController<Region> {
    RegionService service = new RegionService();

    @Override
    public List<Region> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Region entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Region findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, Region entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
