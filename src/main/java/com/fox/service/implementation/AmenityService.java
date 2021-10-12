package com.fox.service.implementation;

import com.fox.model.dao.implementation.AmenityDAO;
import com.fox.model.entity.Amenity;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AmenityService implements AbstractService<Amenity> {

    private final AmenityDAO dao = new AmenityDAO();

    @Override
    public List<Amenity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Amenity findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Amenity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Amenity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
