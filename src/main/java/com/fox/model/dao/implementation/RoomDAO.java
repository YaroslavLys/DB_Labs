package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Room;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements AbstractDAO<Room> {
    private static final String GET_ALL = "SELECT * FROM lys_db.room";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.room WHERE id=?";
    private static final String CREATE = "INSERT lys_db.room "
            + "(`hotel_id`, `room_number`, `description`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.room"
            + " SET hotel_id=?, room_number=?, description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.room WHERE id=?";

    @Override
    public List<Room> findAll() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getInt("hotel_id"),
                        resultSet.getString("room_number"),
                        resultSet.getString("description")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room findById(Integer id) throws SQLException {
        Room room = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getInt("hotel_id"),
                        resultSet.getString("room_number"),
                        resultSet.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public void create(Room room) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(room.getHotelId()));
            statement.setString(2, String.valueOf(room.getRoomNumber()));
            statement.setString(3, String.valueOf(room.getDescription()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Room room) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, room.getHotelId());
            statement.setString(2, room.getRoomNumber());
            statement.setString(3, room.getDescription());
            statement.setInt(4, room.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
