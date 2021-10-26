package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Room;
import com.fox.service.implementation.RoomService;

import java.sql.SQLException;
import java.util.List;

public class RoomController implements AbstractController<Room> {

    RoomService service = new RoomService();

    @Override
    public List<Room> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Room findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Room entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Room entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
