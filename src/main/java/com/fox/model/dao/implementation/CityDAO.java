package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.City;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements AbstractDAO<City> {

    private static final String GET_ALL = "SELECT * FROM lys_db.city";
    private static final String GET_BY_NAME = "SELECT * FROM lys_db.city WHERE name=?";
    private static final String CREATE = "INSERT lys_db.city "
            + "(`name`, `region_name`, `region_country_name`, `language`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.city"
            + " SET language=? WHERE name=? AND region_name=? AND region_country_name=?";
    private static final String DELETE = "DELETE FROM lys_db.city WHERE name=?";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City(
                        resultSet.getString("name"),
                        resultSet.getString("region_name"),
                        resultSet.getString("region_country_name"),
                        resultSet.getString("language")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void create(City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(city.getName()));
            statement.setString(2, String.valueOf(city.getRegionName()));
            statement.setString(3, String.valueOf(city.getRegionCountryName()));
            statement.setString(4, String.valueOf(city.getLanguage()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findByName(String name) throws SQLException {
        City city = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                city = new City(
                        resultSet.getString("name"),
                        resultSet.getString("region_name"),
                        resultSet.getString("region_country_name"),
                        resultSet.getString("language")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void update(String name, City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, city.getLanguage());
            statement.setString(2, city.getName());
            statement.setString(3, city.getRegionName());
            statement.setString(3, city.getRegionCountryName());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
