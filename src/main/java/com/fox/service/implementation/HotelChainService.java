package com.fox.service.implementation;

import com.fox.model.dao.implementation.HotelChainDAO;
import com.fox.model.entity.HotelChain;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class HotelChainService implements AbstractService<HotelChain> {

    private final HotelChainDAO dao = new HotelChainDAO();

    @Override
    public List<HotelChain> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public HotelChain findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(HotelChain entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, HotelChain entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
