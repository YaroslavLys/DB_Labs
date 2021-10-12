package com.fox.service.implementation;

import com.fox.model.dao.implementation.RoomDAO;
import com.fox.model.entity.Room;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class RoomService implements AbstractService<Room> {

    private final RoomDAO dao = new RoomDAO();

    @Override
    public List<Room> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Room findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Room entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Room entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
