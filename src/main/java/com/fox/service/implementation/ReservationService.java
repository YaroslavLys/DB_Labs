package com.fox.service.implementation;

import com.fox.model.dao.implementation.ReservationDAO;
import com.fox.model.entity.Reservation;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class ReservationService implements AbstractService<Reservation> {

    private final ReservationDAO dao = new ReservationDAO();

    @Override
    public List<Reservation> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Reservation findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Reservation entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Reservation entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
