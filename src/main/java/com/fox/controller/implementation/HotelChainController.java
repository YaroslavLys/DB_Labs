package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.HotelChain;
import com.fox.service.implementation.HotelChainService;

import java.sql.SQLException;
import java.util.List;

public class HotelChainController implements AbstractController<HotelChain> {

    HotelChainService service = new HotelChainService();

    @Override
    public List<HotelChain> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public HotelChain findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(HotelChain entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, HotelChain entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
