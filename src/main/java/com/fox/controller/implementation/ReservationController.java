package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Reservation;
import com.fox.service.implementation.ReservationService;

import java.sql.SQLException;
import java.util.List;

public class ReservationController implements AbstractController<Reservation> {

    ReservationService service = new ReservationService();

    @Override
    public List<Reservation> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Reservation findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Reservation entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Reservation entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
