package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Amenity;
import com.fox.service.implementation.AmenityService;

import java.sql.SQLException;
import java.util.List;

public class AmenityController implements AbstractController<Amenity> {

    AmenityService service = new AmenityService();

    @Override
    public List<Amenity> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Amenity findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Amenity entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Amenity entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
