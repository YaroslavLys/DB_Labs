package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Hotel;
import com.fox.service.implementation.HotelService;

import java.sql.SQLException;
import java.util.List;

public class HotelController implements AbstractController<Hotel> {

    HotelService service = new HotelService();

    @Override
    public List<Hotel> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Hotel findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Hotel entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Hotel entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
