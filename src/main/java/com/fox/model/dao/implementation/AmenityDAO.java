package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Amenity;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmenityDAO implements AbstractDAO<Amenity> {
    private static final String GET_ALL = "SELECT * FROM lys_db.amenity";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.amenity WHERE id=?";
    private static final String CREATE = "INSERT lys_db.amenity "
            + "(`room_id`, `name`, `price`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.amenity"
            + " SET room_id=?, name=?, price=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.amenity WHERE id=?";

    @Override
    public List<Amenity> findAll() throws SQLException {
        List<Amenity> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Amenity amenity = new Amenity(
                        resultSet.getInt("id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
                amenities.add(amenity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Amenity findById(Integer id) throws SQLException {
        Amenity amenity = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                amenity = new Amenity(
                        resultSet.getInt("id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenity;
    }

    @Override
    public void create(Amenity amenity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(amenity.getRoomId()));
            statement.setString(2, String.valueOf(amenity.getName()));
            statement.setString(3, String.valueOf(amenity.getPrice()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Amenity amenity) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, amenity.getRoomId());
            statement.setString(2, amenity.getName());
            statement.setInt(3, amenity.getPrice());
            statement.setInt(4, amenity.getId());
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
