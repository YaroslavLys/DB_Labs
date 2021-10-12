package com.fox.service.implementation;

import com.fox.model.dao.implementation.HotelDAO;
import com.fox.model.entity.Hotel;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class HotelService implements AbstractService<Hotel> {

    private final HotelDAO dao = new HotelDAO();

    @Override
    public List<Hotel> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Hotel findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Hotel entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Hotel entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
