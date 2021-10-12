package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Hotel;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements AbstractDAO<Hotel> {

    private static final String GET_ALL = "SELECT * FROM lys_db.hotel";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.hotel WHERE id=?";
    private static final String CREATE = "INSERT lys_db.hotel "
            + "(`name`, `hotel_chain_id`, `city_name`, `city_region_name`, `city_region_country_name`) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.hotel"
            + " SET name=?, hotel_chain_id=?, city_name=?, city_region_name=?, city_region_country_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.hotel WHERE id=?";

    @Override
    public List<Hotel> findAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getString("city_name"),
                        resultSet.getString("city_region_name"),
                        resultSet.getString("city_region_country_name")
                );
                hotels.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public Hotel findById(Integer id) throws SQLException {
        Hotel hotel = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotel = new Hotel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getString("city_name"),
                        resultSet.getString("city_region_name"),
                        resultSet.getString("city_region_country_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public void create(Hotel hotel) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(hotel.getName()));
            statement.setString(2, String.valueOf(hotel.getHotelChainId()));
            statement.setString(3, String.valueOf(hotel.getCityName()));
            statement.setString(4, String.valueOf(hotel.getCityRegionName()));
            statement.setString(5, String.valueOf(hotel.getCityRegionCountryName()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Hotel hotel) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, hotel.getName());
            statement.setInt(2, hotel.getHotelChainId());
            statement.setString(3, hotel.getCityName());
            statement.setString(4, hotel.getCityRegionName());
            statement.setString(5, hotel.getCityRegionCountryName());
            statement.setInt(6, hotel.getId());
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
